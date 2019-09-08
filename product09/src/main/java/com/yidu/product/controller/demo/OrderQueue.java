package com.yidu.product.controller.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: liandyao
 * Date: 2019-09-05
 * Time: 17:27
 * Description: No Description
 */
@Component
public class OrderQueue {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 下单的消息
     * 当这个字符串有值的时候就认为接到了一个下单的消息
     */
    private String placeOrder;
    /**
     * 订单完成的消息
     * 当这个字符串有值的时候就认为订单处理完成
     */
    private String completeOrder;

    public String getPlaceOrder() {
        return placeOrder;
    }

    public void setPlaceOrder(String placeOrder) {
        new Thread(){
            @Override
            public void run() {
                logger.info("消息队列正在接收订单ID"+placeOrder);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                logger.info("消息队列已经接收到订单ID"+placeOrder);
                completeOrder=placeOrder;
            }
        }.start();
        this.placeOrder = placeOrder;
    }

    public String getCompleteOrder() {
        return completeOrder;
    }

    public void setCompleteOrder(String completeOrder) {
        this.completeOrder = completeOrder;
    }
}
