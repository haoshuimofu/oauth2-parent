package com.demo.oauth2.game.controller;

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

    @GetMapping("/union")
    public String ulogin(Model model) {
        model.addAttribute("notice", "暂不支持系统登录，请使用qq连登!");
        return "union-login";
    }

}