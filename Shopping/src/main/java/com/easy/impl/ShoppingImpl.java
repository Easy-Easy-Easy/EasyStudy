package com.easy.impl;

import com.easy.service.IShopping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShoppingImpl implements IShopping {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Transactional
    public int qianggou() {
        //在单机模式下,这种方式就能够解决高并发下的抢购问题.不会出现超卖的情况,
        // 但如果存在集群的情况下,仍可能会发生超卖的情况
        //List lst= jdbcTemplate.queryForList("select 1");
        int updateResult=jdbcTemplate.update("update  tb_constant set  max_order_num = max_order_num-1 where max_order_num-1>=0 ");
        if(updateResult>0){
            String insertSql = "insert into tb_order_info values(?,?)";
            String[] args = {"xiaowang", "订购了一个娃娃"};
            int result = jdbcTemplate.update(insertSql, args);
            return  result;
        }else
            return 0;
    }
}
