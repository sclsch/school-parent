package work.hdjava.school.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 对security安全配置
 */
@Configuration//相当于在xml 里面配置了bean
@EnableWebSecurity(debug = false)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean  //密码模式用到
    public AuthenticationManager authenticationManager() throws Exception {
      return super.authenticationManager();
    }
    //配置认证管理器，授权模式为“poassword”时会用到
    //配置服务详情
//    @Bean
//    public ClientDetailsService clientDetailsService(){
//        return new InMemoryClientDetailsService();
//    }
    //配置一个编码器
    @Bean
    public PasswordEncoder passwordEncoder(){
      return   new BCryptPasswordEncoder();
    }
    //配置规则
    @Override
    public void configure(HttpSecurity http ) throws Exception {
        http.formLogin().permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/oauth/**").permitAll()
                .anyRequest().authenticated()
                .and().logout().permitAll()
                .and().csrf().disable();
    }
}
