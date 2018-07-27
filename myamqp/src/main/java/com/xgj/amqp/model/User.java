package com.xgj.amqp.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: ${title}
 * @Package: com.freemud.base.message
 * @Descripttion:
 * @author:FmStatusCode
 * @date: 2017/5/10
 * @Copyright: 2017 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目.
 */
@Component
public class User{
    private Long id;

    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
