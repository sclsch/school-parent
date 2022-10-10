package work.hdjava.school.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/getCurrentUser")
    public Object getCurrentUser(Authentication authentication) {
        return authentication.getPrincipal();
    }

    @Autowired
    private TokenStore tokenStore;

    @RequestMapping("/getCurrentUserByToken")
    public Object getCurrentUserByToken(@RequestParam("access_token") String token) {
        OAuth2Authentication oAuth2Authentication =  tokenStore.readAuthentication(token);

        return oAuth2Authentication.getUserAuthentication().getPrincipal();
    }
}