package com.yidu.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yidu.order.domain.YiduProduct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liandyao
 * Date: 2019-09-06
 * Time: 17:49
 * Description: No Description
 */
@RestController
public class OrderController {



    public Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Resource
    private RestTemplate restTemplate;
    //discoveryClient是SpringCloud提供的Eureka注册中心的核心对象,使用这个对象可以发现注册中心提供的微服务
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/order")
    public YiduProduct findById() {

        //这里得到的id是商品的id,而实际业务中,我们需要得到商品的相关信息
        String proId = "1001";
        //这里开始使用SpringCloud提供的分布式微服务查询商品的信息
        String serviceId = "yidu-product-microService";
        List<ServiceInstance> serviceList = discoveryClient.getInstances(serviceId);
        if(serviceList.isEmpty()){
            logger.info("找不到微服务,请确认Eureka服务中心是否已经注册yidu_product_microService");
        }
        // 为了演示，在这里只获取一个实例
        ServiceInstance serviceInstance = serviceList.get(0);
        String url = serviceInstance.getHost() + ":" + serviceInstance.getPort();
        logger.info("得到的注册中心的地址是:"+url);
        YiduProduct yiduProduct = restTemplate.getForObject("http://"+url+"/yidu/product/"+proId, YiduProduct.class);
        //将查询出来商品信息的结果设置到订单中

        return yiduProduct;
    }

    @GetMapping("/orderOne")
    @HystrixCommand(fallbackMethod = "findByIdBack")
    public YiduProduct findByIdOne() {

        //这里得到的id是商品的id,而实际业务中,我们需要得到商品的相关信息
        String proId = "1001";
        //这里开始使用SpringCloud提供的分布式微服务查询商品的信息
        String serviceId = "yidu-product-microService";

        YiduProduct yiduProduct = restTemplate.getForObject("http://"+serviceId+"/yidu/product/"+proId, YiduProduct.class);
        //将查询出来商品信息的结果设置到订单中

        return yiduProduct;
    }

    /**
     * 回调方法
     * @return
     */
    public YiduProduct findByIdBack(){
        YiduProduct yiduProduct = new YiduProduct();
        yiduProduct.setProName("无法找到商品信息!");
        return yiduProduct;
    }
}

