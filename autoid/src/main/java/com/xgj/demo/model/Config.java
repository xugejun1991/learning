package com.xgj.demo.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @title: Config
 * @package: com.xgj.demo.model
 * @description: ${TODO}(用一句话描述该文件做什么)
 * @author: xugejun<gejun.xu@freemud.cn>
 * @date: 2018/8/1 17:16
 * @version: v1.0
 * @copyright: 2018 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目的
 */
@Configuration
public class Config {
    @Bean
    public IdUser get(){
        return new IdUser("12","22");
    }
}
