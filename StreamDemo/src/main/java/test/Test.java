package main.java.test;

import main.java.model.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @title: Test
 * @package: main.java
 * @description: ${TODO}(用一句话描述该文件做什么)
 * @author: xugejun<gejun.xu@freemud.cn>
 * @date: 2018/8/6 11:28
 * @version: v1.0
 * @copyright: 2018 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目的
 */
public class Test {
    public static void main(String[] args) throws IOException {

        List<String> list = new ArrayList<>();
        list.add("aaa bbb ccc");
        list.add("ddd eee fff");
        list.add("ggg hhh iii");

        list = list.stream().map(s -> s.split(" ")).flatMap(Arrays::stream).collect(Collectors.toList());

        System.out.println(list);

        IntStream intStream = IntStream.rangeClosed(1, 10);
        int sum = intStream.sum();
        System.out.println(sum);

        //读取文件转换成stream，再将stream转换成list，每个值都是文件里的一行数据
        Stream<String> stream = Files.lines(Paths.get(System.getProperty("user.dir")+"/StreamDemo/src\\main\\resources\\data.txt"));
//        System.out.println(stream.collect(Collectors.toList())); // List<String>,每个元素都是文件的一行数据
        System.out.println(stream.collect(Collectors.joining("\r\n"))); // String  每行数据的String集，但是不带换行符.(连接符其实可以自己指定)


        List<Person> personList = new ArrayList<>();
        personList.add(new Person("jack", 20));
        personList.add(new Person("jack2", 20));
        personList.add(new Person("mike", 25));
        personList.add(new Person("mike2", 25));
        personList.add(new Person("tom", 30));
        personList.add(new Person("tom2", 30));
        //groupingBy 用于将数据分组，最终返回一个 Map 类型,Person::getAge 决定 Map 的键（Integer 类型），list 类型决定 Map 的值（List<Person> 类型）
        Map<Integer, List<Person>> collect = personList.stream().collect(groupingBy(Person::getId));
//        Map<Integer, Map<T, List<Person>>> map = list.stream().collect(groupingBy(Person::getId, groupBy(...)));
        Map<Integer, Integer> map = personList.stream().collect(groupingBy(Person::getId, summingInt(Person::getId)));
        System.out.println(collect);

        //分区与分组的区别在于，分区是按照 true 和 false 来分的，因此partitioningBy 接受的参数的 lambda 也是 T -> boolean
        Map<Boolean, List<Person>> map2 = personList.stream().collect(partitioningBy(p -> p.getId() <=20));
        System.out.println(map2);


    }

}
