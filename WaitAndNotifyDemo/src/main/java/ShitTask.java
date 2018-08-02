package main.java;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @title: ShitTask
 * @package: main.java
 * @description: ${TODO}(用一句话描述该文件做什么)
 * @author: xugejun<gejun.xu@freemud.cn>
 * @date: 2018/8/1 13:56
 * @version: v1.0
 * @copyright: 2018 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目的
 */
public class ShitTask implements Runnable {
    private Washroom washroom;
    private String name;

    public ShitTask(Washroom washroom, String name) {
        this.washroom = washroom;
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (washroom.getLock()) {
            System.out.println(name + "获取了门锁！");
            while (!washroom.isAvailable()){
                try {
                    washroom.getLock().wait(); //加入等待线程
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(name + "已wash完！");
        }
    }
}
