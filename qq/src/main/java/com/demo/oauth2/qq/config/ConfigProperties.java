package com.demo.oauth2.qq.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author wude
 * @date 2020/7/23 13:21
 */
@Component
public class ConfigProperties {

    @Value("${app.clientId}")
    public String clientId;

    @Value("${app.secret}")
    public String secret;

}