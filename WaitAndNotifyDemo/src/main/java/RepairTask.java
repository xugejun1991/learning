package main.java;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @title: RepairTask
 * @package: main.java
 * @description: ${TODO}(用一句话描述该文件做什么)
 * @author: xugejun<gejun.xu@freemud.cn>
 * @date: 2018/8/1 11:53
 * @version: v1.0
 * @copyright: 2018 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目的
 */
public class RepairTask implements Runnable {
    private Washroom washroom;

    public RepairTask(Washroom washroom) {
        this.washroom = washroom;
    }

    @Override
    public void run() {
        synchronized (washroom.getLock()) {
            System.out.println("维修工 获取了厕所的锁");
            System.out.println("厕所维修中，维修厕所是一件辛苦活，需要很长时间。。。");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            washroom.setAvailable(true);
            washroom.getLock().notifyAll(); //加入唤醒线程,从等待队列移出。notify也必须加入到同步代码块中
            //因为wait方法是运行在等待线程里的，notify或者notifyAll是运行在通知线程里的。而执行wait方法前需要判断一下某个条件是否满足，如果不满足才会执行wait方法，这是一个先检查后执行的操作，不是一个原子性操作，
            System.out.println("维修工把厕所修好了，准备释放锁了");
        }
    }
}
