package com.easy.impl;

import com.easy.service.IShopping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingImpl implements IShopping {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int qianggou() {
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
