package main.java.model;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @title: Person
 * @package: main.java.model
 * @description: ${TODO}(用一句话描述该文件做什么)
 * @author: xugejun<gejun.xu@freemud.cn>
 * @date: 2018/8/6 14:39
 * @version: v1.0
 * @copyright: 2018 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目的
 */
public class Person {
    private int id;
    private String name;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Person(String name, int id) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
