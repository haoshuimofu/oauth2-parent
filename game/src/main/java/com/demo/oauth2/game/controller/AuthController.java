package com.demo.oauth2.game.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wude
 * @date 2020/7/23 13:58
 */
@Controller
@RequestMapping("oauth2")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @GetMapping("callback")
    public String callback(HttpServletRequest request) {

        logger.error("### oauth2/call! referer=[{}].", request.getHeader("referer"));
        return "callback";
    }

}