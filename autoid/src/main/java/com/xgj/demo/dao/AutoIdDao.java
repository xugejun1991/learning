package com.xgj.demo.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @title: AutoIdDao
 * @package: com.xgj.demo
 * @description: ${TODO}(用一句话描述该文件做什么)
 * @author: xugejun<gejun.xu@freemud.cn>
 * @date: 2018/7/10 21:36
 * @version: v1.0
 * @copyright: 2018 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目的
 */
@Repository
public class AutoIdDao {
    private JdbcTemplate jdbcTemplate;

    public AutoIdDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public int getAutoId(String tab,int stub,int index){
        jdbcTemplate.update("insert into "+ tab + "(stub) values(?)",stub);
        jdbcTemplate.update("update "+tab+" set id=last_insert_id(id+?) where id =(select last_insert_id())",index-1);//todo:后续直接返回值+1,不进行更表操作
        return jdbcTemplate.queryForObject("select LAST_INSERT_ID()",int.class);
    }
}
