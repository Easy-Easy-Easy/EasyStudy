package com.easy;

import com.easy.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //实例化spring 容器
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.easy");
        System.out.println(Arrays.toString(applicationContext.getBeanDefinitionNames()));
        UserService userService = (UserService) applicationContext.getBean("userServiceImpl");
        userService.test();
        //ioc 的实现原理 （AnnotationConfigApplicationContext 下的doScan 方法）
        //1.扫描传入的package 包下所有的.class 文件（递归文件夹下的所有文件），并放入到一个Resource 数组中
        //2.把所有带有注解的类 包装成一个ScannedGenericBeanDefinition 对象放入到 Set<BeanDefinition> 中
        //3.根据BeanDefinition 中BeanClassName 和注解信息，生成该对象对应的别名（没有配置时默认生成，有配置时获取该配置信息，生成名称）
        //4.把BeanDefinition对象再次包装成 BeanDefinitionHolder 对象 （该对象中有别名beanName和BeanDefinition 对象两个属性）
        //5.通过BeanDefinitionRegistry接口中的registerBeanDefinition 方法，把 该对象放入到 DefaultListableBeanFactory （BeanDefinitionRegistry 的实现类）
        //中的Map 里（key 为上述的beanName）
    }
}
