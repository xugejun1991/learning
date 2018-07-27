package com.xgj.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.Random;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @title: AutoIdUtil
 * @package: com.xgj.demo.dao
 * @description: ${TODO}(用一句话描述该文件做什么)
 * @author: xugejun<gejun.xu@freemud.cn>
 * @date: 2018/7/10 22:06
 * @version: v1.0
 * @copyright: 2018 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目的
 */
@Component
public class AutoIdUtil {

    private static int counts;

    @Value("${autoid_tab_counts}")
    public void setCounts(int tabCounts) {
        counts = tabCounts;
    }

    @Autowired
    private AutoIdDao autoIdDao;

    public int getAutoId() {
        Random rand = new Random();
        int index = rand.nextInt(counts) + 1;//[1,counts]
        String tabName = "autoid_" + String.format("%02d", index);
        int stub = rand.nextInt((100) + 1);
        return autoIdDao.getAutoId(tabName, stub, index);
    }
}
