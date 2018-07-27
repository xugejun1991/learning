package com.xgj.amqp.messageconverter;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: FastJsonMessageConverter
 * @Package com.freemud.pay
 * @Description: 消息转换器
 * @author: xudong.cai
 * @date: 17/5/15 下午2:55
 * @Copyright: 2017 www.freemud.com Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */

import com.alibaba.fastjson.JSON;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.AbstractMessageConverter;
import org.springframework.amqp.support.converter.MessageConversionException;

import java.io.UnsupportedEncodingException;
// 这里本人换成fastjson的jsonobject实现


public class FastJsonMessageConverter<T> extends AbstractMessageConverter {
    private Class<T> tClass;

    private static Log log = LogFactory.getLog(FastJsonMessageConverter.class);


    public static final String DEFAULT_CHARSET = "UTF-8";


    private volatile String defaultCharset = DEFAULT_CHARSET;


    public FastJsonMessageConverter(Class<T> tClass) {
        super();
        System.setProperty("fastjson.parser.autoTypeSupport", "true");
        this.tClass = tClass;
    }


    public void setDefaultCharset(String defaultCharset) {
        this.defaultCharset = (defaultCharset != null) ? defaultCharset : DEFAULT_CHARSET;
    }

    @Override
    public T fromMessage(Message message) {
        String json = "";
        try {
            json = new String(message.getBody(), defaultCharset);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return (T) JSON.parseObject(json, tClass);
    }


    protected Message createMessage(Object objectToConvert,
                                    MessageProperties messageProperties)
            throws MessageConversionException {
        byte[] bytes = null;
        try {
            bytes = JSON.toJSONString(objectToConvert).getBytes(DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            throw new MessageConversionException(
                    "Failed to convert Message content", e);
        }
        messageProperties.setContentType(MessageProperties.CONTENT_TYPE_JSON);
        messageProperties.setContentEncoding(this.defaultCharset);
        if (bytes != null) {
            messageProperties.setContentLength(bytes.length);
        }
        return new Message(bytes, messageProperties);


    }
}
