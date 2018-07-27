package main.java;

import java.util.concurrent.ThreadFactory;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @title: MyThreadFactory
 * @package: com.freemud.framework.datasourceconfig
 * @description: ${TODO}(用一句话描述该文件做什么)
 * @author: xugejun<gejun.xu@freemud.cn>
 * @date: 2018/7/26 15:23
 * @version: v1.0
 * @copyright: 2018 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目的
 */
public class MyThreadFactory implements ThreadFactory {
    private static int COUNTER = 0;

    private static String THREAD_PREFIX = "myThread";

    @Override
    public Thread newThread(Runnable r) {
        int i = COUNTER++;
        return new Thread(r, THREAD_PREFIX + i);
    }
}
