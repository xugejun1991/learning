package com.xgj.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xgj.demo.HttpUtils;
import com.xgj.demo.mapper.AreaMapper;
import com.xgj.demo.model.Area;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @title: AreaController
 * @package: com.xgj.demo.controller
 * @description: ${TODO}(用一句话描述该文件做什么)
 * @author: xugejun<gejun.xu@freemud.cn>
 * @date: 2018/8/8 15:42
 * @version: v1.0
 * @copyright: 2018 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目的
 */
@RestController
public class AreaController {

    @Autowired
    private AreaMapper areaMapper;

    @GetMapping("/insert")
    public void insert(){
        String host = "https://jisuarea.market.alicloudapi.com";
        String path = "/area/all";
        String method = "GET";
        String appcode = "c2f633f3d9d54d4cb3c5950356423d6a";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();


        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            System.out.println(response.toString());
            //获取response的body
//            System.out.println(EntityUtils.toString(response.getEntity()));
            Map map = JSON.parseObject(EntityUtils.toString(response.getEntity()));
            List<Map<String,Object>> result = (List) map.get("result");
//            result.stream().map().collect(Collectors.toMap());
//            result.stream().map(s-> System.out.println(s))
            for (int i = 0; i < result.size(); i++) {
                JSONObject jb = (JSONObject) result.get(i);
                Area area = new Area();
                area.setId(jb.get("id").toString());
                area.setZipCode(jb.get("zipcode").toString());
                area.setParentName(jb.get("parentname").toString());
                area.setDepth(jb.get("depth").toString());
                area.setName(jb.get("name").toString());
                area.setAreaCode(jb.get("areacode").toString());
                area.setParentId(jb.get("parentid").toString());
                areaMapper.insertAllArea(area);
                System.out.println(jb);
            }
            System.out.println(123);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
