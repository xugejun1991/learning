package com.xgj.demo.controller;

import com.xgj.demo.dao.AutoIdUtil;
import com.xgj.demo.manager.ThreadManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @title: TestController
 * @package: com.xgj.demo.controller
 * @description: ${TODO}(用一句话描述该文件做什么)
 * @author: xugejun<gejun.xu@freemud.cn>
 * @date: 2018/7/11 10:47
 * @version: v1.0
 * @copyright: 2018 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目的
 */
@RestController
public class TestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private AutoIdUtil autoIdUtil;
    @Autowired
    private ThreadManager threadManager;

    @PostMapping(value = "/test01")
    public void test01(){
        jdbcTemplate.update("insert into autoid01(stub) values(1)");
    }

    @PostMapping(value = "/get")
    public void getAutoId(){
        autoIdUtil.getAutoId();
    }

    @PostMapping(value = "/threadGet")
    public void threadGet(){
        threadManager.serviceExecute();
    }
}
