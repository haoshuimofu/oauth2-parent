package com.demo.oauth2.game.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wude
 * @date 2020/7/23 11:04
 */
@Controller
@RequestMapping("/index")
public class GameHomeController {


    @RequestMapping("/view")
    public String index(Model model) {
        model.addAttribute("app", "game");
        return "index";
    }


}