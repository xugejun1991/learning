package com.xgj.amqp.MyMQPlat;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @title: Header
 * @package: com.xgj.amqp.config
 * @description: ${TODO}(用一句话描述该文件做什么)
 * @author: xugejun<gejun.xu@freemud.cn>
 * @date: 2018/7/27 11:38
 * @version: v1.0
 * @copyright: 2018 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目的
 */
public class Header {
    private String action;
    private String from;
    private String key;
    private String category;
    private String version = "1";

    public Header() {
    }

    public Header(String action, String from, String key, String category) {
        this.action = action;
        this.from = from;
        this.key = key;
        this.category = category;
    }

    public Header(String action, String from, String key, String category, String version) {

        this.action = action;
        this.from = from;
        this.key = key;
        this.category = category;
        this.version = version;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
