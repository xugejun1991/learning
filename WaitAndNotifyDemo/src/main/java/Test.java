package main.java;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @title: Test
 * @package: main.java
 * @description: ${TODO}(用一句话描述该文件做什么)
 * @author: xugejun<gejun.xu@freemud.cn>
 * @date: 2018/8/1 14:03
 * @version: v1.0
 * @copyright: 2018 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目的
 */
public class Test {
    public static void main(String[] args) {
        Washroom washroom = new Washroom();

        new Thread(new ShitTask(washroom, "狗哥"), "BROTHER-DOG-THREAD").start();
        new Thread(new ShitTask(washroom, "猫爷"), "GRANDPA-CAT-THREAD").start();
        new Thread(new ShitTask(washroom, "王尼妹"), "WANG-NI-MEI-THREAD").start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        new Thread(new RepairTask(washroom), "REPAIR-THREAD").start();
    }

}
