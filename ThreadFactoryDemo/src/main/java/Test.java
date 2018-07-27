package main.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @title: Test
 * @package: com.freemud.framework.datasourceconfig
 * @description: ${TODO}(用一句话描述该文件做什么)
 * @author: xugejun<gejun.xu@freemud.cn>
 * @date: 2018/7/26 15:22
 * @version: v1.0
 * @copyright: 2018 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目的
 */
public class Test {
    public static void main(String[] args) {
        int numberOfCPUs = Runtime.getRuntime().availableProcessors();
        System.out.println("获取当前计算机处理器数量" + numberOfCPUs);
        ExecutorService service = new ThreadPoolExecutor(
                1,  //基本大小为1
                1,  //最大大小为1
                0,  //表示线程不会因为长时间空闲而被停止
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1),   //大小为1的阻塞队列
                new MyThreadFactory(),  //自定义线程工厂
                new ThreadPoolExecutor.CallerRunsPolicy());  //饱和策略

        try {
            service.submit(new LongTimeTask(1));    //该任务会被线程立即执行
            service.submit(new LongTimeTask(2));    //该任务会被塞到阻塞队列中
            service.submit(new LongTimeTask(3));    //该任务会根据不同的饱和策略而产生不同的反应
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
