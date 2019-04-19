package com.easy;

import com.easy.domain.OrderInfo;
import com.easy.mapper.OrderInfoMapper;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class Demo {
    @Test
    public void test() throws Exception {
        //加载主配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建sqlSessionFactory 对象
        //xpath 语法,Document 对象 ,把解析后的这些内容存储起来
        //存在一个名叫 configuration 对象中 ,configuration 中又保存了配置文件中所有配置信息
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过sessionFactory 获取sqlSession(其中的Executor ,是用来执行sql 对象)
        SqlSession session = sessionFactory.openSession();
        //获取代理类对象 (调用jdk 的动态代理,获取到代理对象)
        OrderInfoMapper mapper = session.getMapper(OrderInfoMapper.class);
        List<OrderInfo> lst = mapper.getOrderList();
        for (OrderInfo orderInfo : lst) {
            System.out.println(orderInfo);
        }
        session.close();
        inputStream.close();
    }
}
