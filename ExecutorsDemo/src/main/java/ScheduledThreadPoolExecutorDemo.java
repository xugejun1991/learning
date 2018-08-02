package main.java;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @title: ScheduledThreadPoolExecutorDemo
 * @package: main.java
 * @description: ${TODO}(用一句话描述该文件做什么)
 * @author: xugejun<gejun.xu@freemud.cn>
 * @date: 2018/8/2 10:41
 * @version: v1.0
 * @copyright: 2018 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目的
 */
public class ScheduledThreadPoolExecutorDemo {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor service4 = (ScheduledThreadPoolExecutor) Executors
                .newScheduledThreadPool(2);

        // 如果前面的任务没有完成，则调度也不会启动
//        service4.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    // 如果任务执行时间大于间隔时间，那么就以执行时间为准（防止任务出现堆叠）。
//                    Thread.sleep(4000);
//                    System.out.println(System.currentTimeMillis() / 1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, 0, 6, TimeUnit.SECONDS);// initialDelay（初始延迟） 表示第一次延时时间 ; period 表示间隔时间


        service4.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                    System.out.println(System.currentTimeMillis() / 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }// initialDelay（初始延迟） 表示延时时间；delay + 任务执行时间 = 等于间隔时间 period
        }, 0, 3, TimeUnit.SECONDS);

        // 在给定时间，对任务进行一次调度
        service4.schedule(() -> System.out.println("5 秒之后执行 schedule"), 5, TimeUnit.SECONDS);
    }
}
