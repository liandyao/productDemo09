package com.yidu.product.controller;

import com.yidu.product.dao.YiduProductMapper;
import com.yidu.product.domain.YiduProduct;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liandyao
 * Date: 2019-09-03
 * Time: 17:18
 * Description: No Description
 */
@Controller
@RequestMapping("/product")
public class YiduProductController {

    @Resource
    YiduProductMapper yiduProductMapper;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }

    @RequestMapping("/findById")
    @ResponseBody
    public YiduProduct findById(String id){
        return yiduProductMapper.selectByPrimaryKey(id);
    }
}
