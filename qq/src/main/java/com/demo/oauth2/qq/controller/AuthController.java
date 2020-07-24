package com.demo.oauth2.qq.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
                            @RequestParam("scope") String scope) {

        logger.info("### oauth2/authorize! client_id=[{}], response_type=[{}], redirect_uri=[{}], scope=[{}].",
                clientId, responseType, redirectUri, scope);

        return null;
    }

}