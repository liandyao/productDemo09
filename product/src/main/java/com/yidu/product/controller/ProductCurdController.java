package com.yidu.product.controller;

import com.yidu.product.dao.YiduProductMapper;
import com.yidu.product.domain.YiduProduct;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liandyao
 * Date: 2019-09-04
 * Time: 17:23
 * Description: No Description
 */
@Api(description = "Restful风格的商品接口")
@RestController
public class ProductCurdController {

    @Resource
    YiduProductMapper yiduProductMapper;

    @ApiOperation(value = "查询所有的商品信息" ,  notes="所有的商品信息返回")
    @GetMapping("/products")
    //@RequestMapping(method = RequestMethod.GET,value = "/products")
    public List<YiduProduct> findAll(){

        return yiduProductMapper.findAll() ;
    }
    @ApiOperation(value = "根据ID的商品信息" ,  notes="根据ID的商品信息")

    @GetMapping("/product/{id}")
    //@RequestMapping(method = RequestMethod.GET,value = "/product/{id}")
    public YiduProduct getYiduProduct(@PathVariable("id") String id) {

        return yiduProductMapper.selectByPrimaryKey(id);
    }

    /**
     * 保存商品
     * @param yiduProduct RequestBody这个注解可以接收json数据
     * @return 是否保存成功
     */
    //@RequestMapping(method = RequestMethod.POST,value = "/product")
    @PostMapping("/product") //此种方式也可以
    public boolean insert(@RequestBody YiduProduct yiduProduct){
        return yiduProductMapper.insert(yiduProduct)>0 ;
    }

    /**
     * 修改商品
     * @param yiduProduct RequestBody这个注解可以接收json数据
     * @return
     */
    //@RequestMapping(method = RequestMethod.PUT,value = "/product")
    @PutMapping("/product") //此种方式也可以
    public boolean update(@RequestBody  YiduProduct yiduProduct){
        return yiduProductMapper.updateByPrimaryKey(yiduProduct)>0;
    }

    /**
     * 删除商品
     * @param id
     * @return
     */
    //@RequestMapping(method = RequestMethod.DELETE,value = "/product/{id}")
    @DeleteMapping("/product/{id}") //此种方式也可以
    public boolean delete(@PathVariable String id){
        return yiduProductMapper.deleteByPrimaryKey(id)>0;
    }


}
