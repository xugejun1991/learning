package main.java;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @title: LongTimeTask
 * @package: com.freemud.framework.datasourceconfig
 * @description: ${TODO}(用一句话描述该文件做什么)
 * @author: xugejun<gejun.xu@freemud.cn>
 * @date: 2018/7/26 15:21
 * @version: v1.0
 * @copyright: 2018 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目的
 */
public class LongTimeTask implements Runnable {
    private int num;

    public LongTimeTask(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + "线程正在执行第" + num + "个任务");
            Thread.sleep(1000000L);     //模拟耗时操作
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
