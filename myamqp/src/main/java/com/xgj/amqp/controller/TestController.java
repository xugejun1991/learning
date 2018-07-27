package com.xgj.amqp.controller;

import com.xgj.amqp.model.User;
import com.xgj.amqp.provider.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @title: TestController
 * @package: com.xgj.amqp.controller
 * @description: ${TODO}(用一句话描述该文件做什么)
 * @author: xugejun<gejun.xu@freemud.cn>
 * @date: 2018/7/27 14:27
 * @version: v1.0
 * @copyright: 2018 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目的
 */
@RestController
public class TestController {
    /**
     * 消息队列 - 消息提供者 注入
     */
    @Autowired
    private MessageProvider messageProvider;

    /**
     * 测试发送消息队列方法
     *
     * @param user 发送消息实体内容
     * @return
     */
    @PostMapping(value = "/index")
    public String index(@RequestBody User user) {
        // 将实体实例写入消息队列
        messageProvider.sendMessage(user);
        return "Success";
    }

    @GetMapping(value = "/test01")
    public String test01(@RequestParam String id) {
        messageProvider.sendMessage(id);
        return "success";
    }

}
