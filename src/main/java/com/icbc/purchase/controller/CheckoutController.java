package com.icbc.purchase.controller;

import com.icbc.purchase.entity.dto.Result;
import com.icbc.purchase.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {


    @Autowired
    private CheckoutService checkoutService;

    /**
     * @param map           key-水果名称，value-水果斤数
     * @param extraDiscount 额外优惠 0-无优惠 1-满一百减十块
     * @return
     */
    @RequestMapping("/test")
    public Result checkout(@RequestBody Map<String, Integer> map, @RequestParam(defaultValue = "0") Integer extraDiscount) {
        //参数校验
        if (CollectionUtils.isEmpty(map)) {
            return Result.errorMessage("请检查是否添加水果");
        }
        return checkoutService.checkout(map, extraDiscount);
    }


}
