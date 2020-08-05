package com.yczuoxin;

import com.yczuoxin.annotation.NameRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DerivedComponentAnnotationBootstrap {

    static {
        System.setProperty("java.version", "1.7.0");
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        context.setConfigLocation("classpath:/META-INF/spring/context.xml");
        context.refresh();
        NameRepository chineseNameRepository = (NameRepository) context.getBean("chineseNameRepository");
        System.out.println(chineseNameRepository.findAll());
    }

}
