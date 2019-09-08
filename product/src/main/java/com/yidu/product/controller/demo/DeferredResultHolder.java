package com.yidu.product.controller.demo;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: liandyao
 * Date: 2019-09-05
 * Time: 17:32
 * Description: No Description
 */
@Component
public class DeferredResultHolder {
    /**
     * key代表订单号，DeferredResult放的是处理结果
     */
    private Map<String, DeferredResult<String>> map  = new HashMap<String, DeferredResult<String>>() ;

    public Map<String, DeferredResult<String>> getMap() {
        return map;
    }

    public void setMap(Map<String, DeferredResult<String>> map) {
        this.map = map;
    }

}
