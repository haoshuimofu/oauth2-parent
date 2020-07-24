package com.demo.oauth2.game.controller;

import com.demo.oauth2.game.config.ConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wude
 * @date 2020/7/23 11:27
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private ConfigProperties configProperties;

    @GetMapping("/union")
    public String ulogin(Model model) {
        model.addAttribute("notice", "暂不支持系统登录，请使用qq连登!");

        model.addAttribute("authUrl", configProperties.authUrl);
        model.addAttribute("redirectUri", configProperties.redirectUrl);
        model.addAttribute("clientId", configProperties.clientId);
        return "union-login";
    }

}