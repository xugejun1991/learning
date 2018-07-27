package com.xgj.amqp.MyMQPlat;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @title: MQAction
 * @package: com.xgj.amqp
 * @description: ${TODO}(用一句话描述该文件做什么)
 * @author: xugejun<gejun.xu@freemud.cn>
 * @date: 2018/7/27 11:36
 * @version: v1.0
 * @copyright: 2018 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目的
 */
public class MQMessage<T> {
    private Header header;
    private T body;

    public MQMessage() {
    }

    public MQMessage(Header header, T body) {

        this.header = header;
        this.body = body;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
