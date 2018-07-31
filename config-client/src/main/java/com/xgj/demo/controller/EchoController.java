package com.xgj.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @title: EchoController
 * @package: com.xgj.demo.controller
 * @description: ${TODO}(用一句话描述该文件做什么)
 * @author: xugejun<gejun.xu@freemud.cn>
 * @date: 2018/7/31 10:38
 * @version: v1.0
 * @copyright: 2018 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目的
 */
@RestController
@RefreshScope
@RequestMapping(value = "/cfg")
public class EchoController {
    @Value("${my.name}")
    private String myName;

    @GetMapping("/my-name")
    public String getName(){
        return myName;
    }

}
