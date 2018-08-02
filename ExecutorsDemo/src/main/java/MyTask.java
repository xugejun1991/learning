package main.java;


import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @title: MyTask
 * @package: main.java
 * @description: ${TODO}(用一句话描述该文件做什么)
 * @author: xugejun<gejun.xu@freemud.cn>
 * @date: 2018/8/2 10:07
 * @version: v1.0
 * @copyright: 2018 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目的
 */
public class MyTask implements Runnable {
    @Override
    public void run() {
//        System.out.println(System.currentTimeMillis() + ":Thread ID: %s" + Thread.currentThread().getId());
        System.out.printf("[当前时间:%s],Thread ID: %s,Thread Name:%s \n", System.currentTimeMillis() , Thread.currentThread().getId(),Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i <10 ; i++) {
            service.submit(myTask);
        }
        service.shutdown();
//        Executor executor = Executors.newFixedThreadPool(5); // ExecutorService extends Executor
//        for (int i = 0; i <5 ; i++) {
//            executor.execute(myTask);
//        }
    }
}
