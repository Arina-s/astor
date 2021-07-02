package com.arinauniversity.astor;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        TestBean testBean = applicationContext.getBean("testBean", TestBean.class);
        System.out.println(testBean);
        applicationContext.close();
    }

}
