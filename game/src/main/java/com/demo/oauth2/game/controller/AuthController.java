package com.demo.oauth2.game.controller;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.demo.oauth2.game.config.ConfigProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wude
 * @date 2020/7/23 13:58
 */
@Controller
@RequestMapping("oauth2")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private ConfigProperties configProperties;

    @GetMapping("callback")
    @ResponseBody
    public String callback(HttpServletRequest request,
                           @RequestParam("code") String code) {

        logger.info("### oauth2/call! referer=[{}].", request.getHeader("referer"));
        logger.info("### 认证服务器回调! code=[{}]", code);
        logger.info("### 拿code换取access_token!");

        Map<String, Object> params = new HashMap<>();
        params.put("client_id", configProperties.clientId);
        params.put("secret", configProperties.secret);
        params.put("code", code);
        params.put("grant_type", "authorization_code");
        String tokenResult = HttpUtil.get("http://localhost:8081/game/oauth2/token", params, 3000);
        JSONObject json = JSONObject.parseObject(tokenResult);

        logger.info("### 根据code换取token! code=[{}], token_result=[{}].", code, json == null ? "" : json.toJSONString());

        return tokenResult;
    }

}