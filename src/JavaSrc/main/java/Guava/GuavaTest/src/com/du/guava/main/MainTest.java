package Guava.GuavaTest.src.com.du.guava.main;


import Guava.GuavaTest.src.joiner.JoinerTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2017/8/15.
 */
public class MainTest {
    public static void main(String[] args){
        JoinerTest joinTest = new JoinerTest();
        List<String> li = new ArrayList<String>();
        li.add("aaa");
        li.add("bbb");
        li.add("ccc");
        li.add(null);

        li.add("ddd");
        String result1 = joinTest.buildString(li,"#");
        System.out.println(result1);
        String result2 = joinTest.guavaJoiner(li, "$");
        System.out.println(result2);
        joinTest.test();
        joinTest.testMapJoiner();
        System.out.println("=========================================================");
        joinTest.testSplit();
    }
}
