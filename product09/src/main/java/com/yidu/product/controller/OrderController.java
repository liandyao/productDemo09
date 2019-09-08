package com.yidu.product.controller;

import com.yidu.product.controller.demo.DeferredResultHolder;
import com.yidu.product.controller.demo.OrderQueue;
import jdk.nashorn.internal.codegen.CompilerConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import javax.annotation.Resource;
import java.util.concurrent.Callable;

/**
 * Created with IntelliJ IDEA.
 * User: liandyao
 * Date: 2019-09-05
 * Time: 17:10
 * Description: No Description
 */
@RestController
public class OrderController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    DeferredResultHolder deferredResultHolder;

    @Resource
    OrderQueue orderQueue;

    @GetMapping("/order/{id}")
    public String order(String id){
        logger.info("进来了:"+id);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("完成了:"+id);
        return "下单成功";
    }

    @GetMapping("/orderT/{id}")
    public Callable<String> orderThread(String id){
        logger.info("主线程进来了----------------:"+id);
        Callable<String> call = new Callable<String>() {
            @Override
            public String call() throws Exception {
                logger.info("子线程进来了:"+id);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                logger.info("子线程订单处理完成:"+id);
                return "下单成功";
            }
        };
        logger.info("主线程完成了-------------:"+id);
        return call ;
    }

    @GetMapping("orderD/{id}")
    public DeferredResult<String> orderResult(String id){

        orderQueue.setPlaceOrder(id);

        DeferredResult<String> deferredResult = new DeferredResult<String>();
        deferredResultHolder.getMap().put(id,deferredResult);

        return deferredResult ;
    }

}
