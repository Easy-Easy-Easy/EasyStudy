package com.easy.servlet;

import com.easy.annotation.EAutowired;
import com.easy.annotation.EController;
import com.easy.annotation.ERequestMapping;
import com.easy.annotation.EService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URL;
import java.util.*;

public class EDispatcherServlet extends HttpServlet {
    private Properties contextConfig = new Properties();
    //存放扫描包下 所有的类名称
    List<String> classList = new ArrayList<String>();
    //存放实例化的bean
    Map<String, Object> ioc = new HashMap<>();
    //handlermppimg 存放所有的url
    Map<String, Method> handlerMapping = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doDispathcer(req, resp);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("EDispatcherServlet.init");
        //1.加载配置文件
        doLoadConfig(config.getInitParameter("contextConfigLocation"));
        //2.解析配置文件,扫描所有相关的类
        doScaner(contextConfig.getProperty("scanPackage"));
        System.out.println(classList.toString());
        //3.初始化所有相关的类,并且存放到ioc 容器中
        doInstance();
        //4.完成自动化依赖注入 DI
        doAutowired();
        //5.创建HandlerMapping 将url 和method 关联
        initHandlerMapping();
        //6.调用doGet doPost 方法,将结果返回给浏览器
    }


    private void doLoadConfig(String contextConfigLocation) {
        System.out.println("待读取的配置文件是contextConfigLocation = [" + contextConfigLocation + "]");
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(contextConfigLocation);
        try {
            contextConfig.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //contextConfig.load();
    }

    //扫描包(例:com.easy)
    private void doScaner(String scanPackage) {
        URL url = this.getClass().getClassLoader().getResource("/" + scanPackage.replaceAll("\\.", "/"));
        File classDir = new File(url.getPath());
        for (File file : classDir.listFiles()) {
            //文件夹,继续递归
            if (file.isDirectory()) {
                doScaner(scanPackage + "." + file.getName());
            } else {
                //文件
                String fileName = scanPackage + "." + file.getName().replace(".class", "");
                classList.add(fileName);
            }
        }

    }

    private void doInstance() {
        try {
            //循环遍历初始化类
            for (String className : classList) {
                Class clazz = Class.forName(className);
                //只处理加入了注解的特定类(例:EController,EService),将这些类放入ioc中
                //当前类是一个controller
                if (clazz.isAnnotationPresent(EController.class)) {
                    ioc.put(lowCaseFirstChar(clazz.getSimpleName()), clazz.newInstance());
                } else if (clazz.isAnnotationPresent(EService.class)) {//当前类是一个service
                    //没有设置名称时用首字母小写
                    EService service = (EService) clazz.getAnnotation(EService.class);
                    String beanName = service.value();
                    if ("".equals(beanName)) {
                        beanName = lowCaseFirstChar(clazz.getSimpleName());
                    }
                    Object instance= clazz.newInstance();
                    ioc.put(beanName, instance);
                    //另外一种情况,用接口名称作为key,接口的实现类作为value
                    Class[] interfaces = clazz.getInterfaces();
                    for (Class i : interfaces) {
                        if (ioc.containsKey(i.getName())) {
                            throw new Exception("this bean is exsit");
                        }
                        //注意此处用的是getName 不是getSimpleName
                        ioc.put(i.getName(), instance);
                    }

                } else {
                    continue;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void doAutowired() {
        if (ioc.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
            Field[] fileds = entry.getValue().getClass().getDeclaredFields();
            for (Field filed : fileds) {
                //字段上是否有注解
                if (!filed.isAnnotationPresent(EAutowired.class)) {
                    continue;
                }
                EAutowired autowired = filed.getAnnotation(EAutowired.class);
                String beanName = autowired.value();
                if ("".equals(beanName)) {
                    beanName = filed.getType().getName();
                }
                //强制赋值
                filed.setAccessible(true);
                try {
                    filed.set(entry.getValue(), ioc.get(beanName));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    continue;
                }
            }
        }
    }

    private void initHandlerMapping() {
        if (ioc.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
            Class clazz = entry.getValue().getClass();
            //只处理有controller 注解的bean
            if (!clazz.isAnnotationPresent(EController.class)) {
                continue;
            }
            String controllerUrl = "";
            if (clazz.isAnnotationPresent(ERequestMapping.class)) {
                ERequestMapping requestMapping = (ERequestMapping) clazz.getAnnotation(ERequestMapping.class);
                controllerUrl = requestMapping.value();
            }
            //获取所有方法
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                //method 上是否有requestMapping 注解
                if (!method.isAnnotationPresent(ERequestMapping.class)) {
                    continue;
                }
                ERequestMapping requestMapping = method.getAnnotation(ERequestMapping.class);
                String url = ("/" + controllerUrl + "/" + requestMapping.value()).replaceAll("/+", "/");
                handlerMapping.put(url, method);
                System.out.println("mapping url " + url + "method :" + method.getName());
            }

        }
    }

    private void doDispathcer(HttpServletRequest req, HttpServletResponse resp) throws IOException, InvocationTargetException, IllegalAccessException {
        if (handlerMapping.isEmpty()) {
            return;
        }
        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        url = url.replace(contextPath, "").replaceAll("/+", "/");
        if (!this.handlerMapping.containsKey(url)) {
            resp.getWriter().write("404 Not Found");
            return;
        }
        Method method = this.handlerMapping.get(url);
        String beanName = lowCaseFirstChar(method.getDeclaringClass().getSimpleName());
        Map<String ,String[]> params=req.getParameterMap();
        String name="";
        if (params.containsKey("name")){
            name=params.get("name")[0];
        }
        method.invoke(ioc.get(beanName), new Object[]{req, resp,name});
    }

    private String lowCaseFirstChar(String content) {
        char[] chars = content.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

}
