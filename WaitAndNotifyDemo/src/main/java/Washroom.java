package main.java;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @title: Washroom
 * @package: main.java
 * @description: ${TODO}(用一句话描述该文件做什么)
 * @author: xugejun<gejun.xu@freemud.cn>
 * @date: 2018/8/1 11:51
 * @version: v1.0
 * @copyright: 2018 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目的
 */
public class Washroom {
    private volatile boolean isAvailable = false; //表示是否可用
    private Object lock = new Object(); // 表示锁

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Object getLock() {
        return lock;
    }
}
