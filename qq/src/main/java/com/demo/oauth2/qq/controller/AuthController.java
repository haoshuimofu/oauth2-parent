package com.demo.oauth2.qq.controller;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 参考用sina账号连登zhihu
 * https://api.weibo.com/oauth2/authorize?scope=email&state=34663339366531392d383430372d343761342d386164322d663562316639626532643464&redirect_uri=http%3A%2F%2Fwww.zhihu.com%2Foauth%2Fcallback%2Fsina&response_type=code&client_id=3063806388
 *
 * @author wude
 * @date 2020/7/23 13:32
 */
@Controller
@RequestMapping("oauth2")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @RequestMapping("authorize")
    public String authorize(@RequestParam("client_id") String clientId,
                            @RequestParam("response_type") String responseType,
                            @RequestParam("redirect_uri") String redirectUri,
                            @RequestParam("scope") String scope,
                            HttpServletResponse response, Model model) throws Exception {

        logger.info("### oauth2/authorize! client_id=[{}], response_type=[{}], redirect_uri=[{}], scope=[{}].",
                clientId, responseType, redirectUri, scope);
        // 校验clientId 和 secrete, 看客户端提交的信息是否正确
        String code = UUID.randomUUID().toString();
        logger.info("### 认证服务器接收到的商户信息正确! 返回商户授权码! clientId=[{}], code=[{}].",
                clientId, code);
        Thread.sleep(3000);
        if (true) {
            response.sendRedirect(redirectUri + "?code=" + code);
            return null;
        } else {
            model.addAttribute("warn", "商户认证信息错误!");
            return "warn";
        }
    }

    @RequestMapping("token")
    @ResponseBody
    public String token(@RequestParam("client_id") String clientId,
                        @RequestParam("secret") String secret,
                        @RequestParam("code") String code,
                        @RequestParam(value = "grant_type", defaultValue = "authorization_code") String grantType,
                        HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("### 商户客户端根据授权码换取access_token!");

        // 校验secret
        Thread.sleep(3000);

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("access_token", UUID.randomUUID().toString());
        dataMap.put("expires_in", 7200);
        dataMap.put("open_id", "wangbo");
        dataMap.put("scope", "app");
        return JSON.toJSONString(dataMap);
    }

}