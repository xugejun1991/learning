package com.xgj.demo.manager;

import com.xgj.demo.dao.AutoIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @title: ThreadManager
 * @package: com.xgj.demo.manager
 * @description: ${TODO}(用一句话描述该文件做什么)
 * @author: xugejun<gejun.xu@freemud.cn>
 * @date: 2018/7/11 13:34
 * @version: v1.0
 * @copyright: 2018 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目的
 */
@Component
public class ThreadManager {

    @Autowired
    private AutoIdUtil autoIdUtil;

    public void serviceExecute(){
        //在这里开启线程，执行操作
        ThreadExample te = new ThreadExample();
        te.start();
    }

    /**
     * 内部类解决了多线程情况下，@Autowired注入为null的问题
     */
    private class ThreadExample extends Thread{

        public ThreadExample(){
            //todo:也可以在构造函数中传入参数
        }
        public void run(){
            //这里为线程的操作
            //就可以使用注入之后Bean了
            for (int i = 0; i <100 ; i++) {
                int j = autoIdUtil.getAutoId();
                System.out.println("线程："+Thread.currentThread().getName() +"  id:"+ j);
            }
        }
    }

}
