package com.easy.controller;

import com.easy.service.IShopping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ShoppingController {
    @Autowired
    private IShopping iShopping;
    @ResponseBody
    @RequestMapping("/shopping")
    public void shopping(){
      int i=  iShopping.qianggou();
      if(i>0){
          System.out.println("------------抢到了-------");
      }else{
          System.out.println("------------没抢到-------");
      }
    }
}
