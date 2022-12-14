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
        //??????????????????????????????
        endpoints.authenticationManager(authenticationManagerBean)

           .tokenStore(tokenStore)
           .reuseRefreshTokens(false) //refresh_token??????????????????
           .userDetailsService(userService) //????????????????????????????????????????????????
           .allowedTokenEndpointRequestMethods(HttpMethod.GET,HttpMethod.POST); //??????GET,POST??????
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        //??????????????????
        security.checkTokenAccess("isAuthenticated()");
      //  security.checkTokenAccess("permitAll()");
        security.allowFormAuthenticationForClients();
    }

    @Override  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.inMemory()
//        //??????client_id
//        .withClient("client")  //??????client???secret
//        .secret(passwordEncoder.encode("123123"))
//                //????????????token????????????
//        .accessTokenValiditySeconds(3600)
//                //????????????token????????????
//        .refreshTokenValiditySeconds(864000)
//                //??????redirect_uri??????????????????????????????
//        .redirectUris("http://www.baidu.com")
//        .autoApprove(true)//????????????
//                //???????????????????????????
//        .scopes("all")
//                //??????grant_type?????????????????????
//        .authorizedGrantTypes("authorization_code","password","client_credentials");

        //???????????????
        //http://localhost:1111/oauth/authorize?response_type=code&client_id=client
        //http://localhost:4444/oauth/authorize?response_type=code&client_id=client
        //http://localhost:4444/auth/oauth/authorize?response_type=code&client_id=client
        //password??????
        //http://localhost:1111/oauth/token?username=fox&password=123456&grant_type=password&client_id=client&client_secret=123123&scope=all


        clients.withClientDetails(jdbcClientDetailsService());
    }
}