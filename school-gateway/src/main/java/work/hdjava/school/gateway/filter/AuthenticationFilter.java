package work.hdjava.school.gateway.filter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import work.hdjava.school.gateway.common.MDA;
import work.hdjava.school.gateway.common.TokenInfo;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 认证过滤器
 * @author Fox
 */
@Component
@Order(0)
public class AuthenticationFilter implements GlobalFilter, InitializingBean {

    @Autowired
    private RestTemplate restTemplate;

    private static Set<String> shouldSkipUrl = new LinkedHashSet<>();
    @Override
    public void afterPropertiesSet() throws Exception {
        // 不拦截认证的请求
        shouldSkipUrl.add("/auth/oauth/token");
        shouldSkipUrl.add("/auth/oauth/check_token");
        shouldSkipUrl.add("/auth/user/getCurrentUser");
        shouldSkipUrl.add("/oauth/token");
        shouldSkipUrl.add("/oauth/check_token");
        shouldSkipUrl.add("/oauth/authorize");
        shouldSkipUrl.add("/oauth/user/getCurrentUser");
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        String requestPath = exchange.getRequest().getURI().getPath();
        
        //不需要认证的url
        if(shouldSkip(requestPath)) {
            return chain.filter(exchange);
        }

        //获取请求头
        String authHeader = exchange.getRequest().getHeaders().getFirst("Authorization");

        //请求头为空
        if(StringUtils.isEmpty(authHeader)) {
            throw new RuntimeException("请求头为空");
        }

        TokenInfo tokenInfo=null;
        try {
            //获取token信息
            tokenInfo = getTokenInfo(authHeader);
        }catch (Exception e) {
            throw new RuntimeException("校验令牌异常");
        }
        // tokenInfo
        exchange.getAttributes().put("tokenInfo",tokenInfo);
        return chain.filter(exchange);
    }

    private boolean shouldSkip(String reqPath) {

        for(String skipPath:shouldSkipUrl) {
            if(reqPath.contains(skipPath)) {
                return true;
            }
        }
        return false;
    }

    private TokenInfo getTokenInfo(String authHeader) {
        // 往授权服务发请求 /oauth/check_token
        // 获取token的值
        String token = StringUtils.substringAfter(authHeader, "bearer ");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        //必须 basicAuth clienId clientSecret
        headers.setBasicAuth(MDA.clientId, MDA.clientSecret);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("token", token);

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params, headers);

        ResponseEntity<TokenInfo> response = restTemplate.exchange(MDA.checkTokenUrl, HttpMethod.POST, entity, TokenInfo.class);

        return response.getBody();
    }
}
