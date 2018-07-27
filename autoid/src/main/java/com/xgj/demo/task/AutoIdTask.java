//package com.xgj.demo.task;
//
//import com.xgj.demo.dao.AutoIdDao;
//import com.xgj.demo.dao.AutoIdUtil;
//import com.xgj.demo.utils.SpringBeanUtil;
//import org.springframework.stereotype.Component;
//
///**
// * All rights Reserved, Designed By www.freemud.cn
// *
// * @title: AutoIdTask
// * @package: com.xgj.demo.task
// * @description: ${TODO}(用一句话描述该文件做什么)
// * @author: xugejun<gejun.xu@freemud.cn>
// * @date: 2018/7/11 13:20
// * @version: v1.0
// * @copyright: 2018 www.freemud.cn Inc. All rights reserved.
// * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目的
// */
//@Component
//public class AutoIdTask implements Runnable{
//    private AutoIdUtil autoIdUtil;
//
//    public AutoIdTask() {
//        this.autoIdUtil = SpringBeanUtil.getBean(AutoIdUtil.class);
//    }
//
//    @Override
//    public void run() {
//        for (int i = 0; i <100 ; i++) {
//            int j = autoIdUtil.getAutoId();
//            System.out.println("线程："+Thread.currentThread().getName() +"id:"+ j);
//        }
//    }
//}
