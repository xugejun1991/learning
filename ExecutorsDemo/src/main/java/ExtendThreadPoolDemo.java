package main.java;


import java.util.concurrent.*;

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
public class ExtendThreadPoolDemo {
    static class MyTask implements Runnable {

        String name;

        public MyTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out
                    .println("正在执行：Thread ID:" + Thread.currentThread().getId() + ", Task Name = " + name);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>()) {
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("准备执行：" + ((MyTask) r).name);
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println("执行完成： " + ((MyTask) r).name);
            }

            @Override
            protected void terminated() {
                System.out.println("线程池退出");
            }
        };

        for (int i = 0; i < 5; i++) {
            MyTask myTask = new MyTask("TASK-GEYM-" + i);
            es.execute(myTask);
            Thread.sleep(10);

        }

        es.shutdown();
    }
}
