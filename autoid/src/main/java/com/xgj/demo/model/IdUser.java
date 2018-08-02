package com.xgj.demo.model;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @title: User
 * @package: com.xgj.demo.model
 * @description: ${TODO}(用一句话描述该文件做什么)
 * @author: xugejun<gejun.xu@freemud.cn>
 * @date: 2018/8/1 17:05
 * @version: v1.0
 * @copyright: 2018 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目的
 */

public class IdUser {
    private String id;
    private String name;

    public IdUser() {
    }

    public IdUser(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "IdUser{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
