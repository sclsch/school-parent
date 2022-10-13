package work.hdjava.school.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import work.hdjava.school.server.service.UserService;

import javax.sql.DataSource;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManagerBean;

    @Autowired
    private UserService userService;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private TokenStore tokenStore;

    @Bean
    TokenStore tokenStore(){
        return new JdbcTokenStore(dataSource);
    }

    @Bean
    public ClientDetailsService jdbcClientDetailsService(){
        return new JdbcClientDetailsService(dataSource);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        //使用密码模式需要配置
        endpoints.authenticationManager(authenticationManagerBean)

           .tokenStore(tokenStore)
           .reuseRefreshTokens(false) //refresh_token是否重复使用
           .userDetailsService(userService) //刷新令牌授权包含对用户信息的检查
           .allowedTokenEndpointRequestMethods(HttpMethod.GET,HttpMethod.POST); //支持GET,POST请求
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        //允许表单认证
        security.allowFormAuthenticationForClients();
    }

    @Override  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.inMemory()
//        //配置client_id
//        .withClient("client")  //配置client‐secret
//        .secret(passwordEncoder.encode("123123"))
//                //配置访问token的有效期
//        .accessTokenValiditySeconds(3600)
//                //配置刷新token的有效期
//        .refreshTokenValiditySeconds(864000)
//                //配置redirect_uri，用于授权成功后跳转
//        .redirectUris("http://www.baidu.com")
//        .autoApprove(true)//自动授权
//                //配置申请的权限范围
//        .scopes("all")
//                //配置grant_type，表示授权类型
//        .authorizedGrantTypes("authorization_code","password","client_credentials");

        //授权码模式
        //http://localhost:1111/oauth/authorize?response_type=code&client_id=client
        //http://localhost:4444/oauth/authorize?response_type=code&client_id=client
        //password模式
        //http://localhost:1111/oauth/token?username=fox&password=123456&grant_type=password&client_id=client&client_secret=123123&scope=all


        clients.withClientDetails(jdbcClientDetailsService());
    }
}