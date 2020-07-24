package com.demo.oauth2.game.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author wude
 * @date 2020/7/23 13:05
 */
@Component
public class ConfigProperties {

    @Value("${app.authUrl}")
    public String authUrl;

    @Value("${app.redirectUri}")
    public String redirectUrl;

    @Value("${app.clientId}")
    public String clientId;

    @Value("${app.secret}")
    public String secret;

}