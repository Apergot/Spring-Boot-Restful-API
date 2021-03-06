package com.apergot.springbootrestapi.auth;

import com.apergot.springbootrestapi.models.entity.User;
import com.apergot.springbootrestapi.models.services.IUserServiceClaims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InfoAditionalToken implements TokenEnhancer {

    @Autowired
    IUserServiceClaims userService;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        User user = userService.findByUsername(oAuth2Authentication.getName());
        Map<String, Object> claims = new HashMap<>();
        claims.put("user_id", user.getId());
        claims.put("fullname", user.getFirstname()+" "+user.getLastname());
        claims.put("email", user.getEmail());
        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(claims);
        return oAuth2AccessToken;
    }
}
