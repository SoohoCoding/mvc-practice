package org.example;

import org.example.annotation.Controller;
import org.example.annotation.Service;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;


// @Controller 애노테이션이 설정돼 있는 모든 클래스를 찾아서 출력한다.


public class ReflectionTest {

    private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);



    @Test
    void controllerScan() {
        Reflections reflection = new Reflections("org.example");

        Set<Class<?>> beans = new HashSet<>();
        beans.addAll(reflection.getTypesAnnotatedWith(Controller.class));
        beans.addAll(reflection.getTypesAnnotatedWith(Service.class));

        logger.debug("beans: [{}]", beans);


    }

}
