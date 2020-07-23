package com.demo.oauth2.game;

import com.demo.oauth2.game.controller.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author wude
 * @date 2020/7/23 12:55
 */
@Configuration
public class MvcConfiguration extends WebMvcConfigurationSupport {

    @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自定义拦截器，添加拦截路径和排除拦截路径
        InterceptorRegistration registration = registry.addInterceptor(loginInterceptor());

        registration.excludePathPatterns("/login/**");
    }

}