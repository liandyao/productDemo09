package com.yidu.product.controller.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: liandyao
 * Date: 2019-09-05
 * Time: 17:37
 * Description: No Description
 */

public class QueueListener implements ApplicationListener<ContextRefreshedEvent> {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    OrderQueue orderQueue;

    @Resource
    DeferredResultHolder deferredResultHolder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        new Thread(){
            @Override
            public void run() {
                while(true){
                    logger.info("应用2发送消息开始"+orderQueue.getPlaceOrder());
                    if(orderQueue.getCompleteOrder()!=null){

                        deferredResultHolder.getMap().get(orderQueue.getCompleteOrder()).setResult("订单处理完成");
                        orderQueue.setCompleteOrder(null);
                    }else{
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    logger.info("应用2发送消息结束"+orderQueue.getPlaceOrder());
                }
            }
        }.start();
    }
}
