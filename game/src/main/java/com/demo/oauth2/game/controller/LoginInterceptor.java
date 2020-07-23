package com.demo.oauth2.game.controller;

import com.demo.oauth2.game.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wude
 * @date 2020/7/23 11:41
 */
public class LoginInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String name = (String) request.getSession(true).getAttribute(Constants.SESSION_USER_INFO_KEY);
        if (name == null) {
            logger.warn("### 未登录重定向! url=[{}]...", request.getRequestURI());
            response.sendRedirect("/game/login/union");
            return false;
        }
        return true;
    }

}