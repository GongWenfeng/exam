package com.icbc.purchase.service.impl;

import com.icbc.purchase.entity.dto.Result;
import com.icbc.purchase.enums.FruitEnum;
import com.icbc.purchase.service.CheckoutService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    @Override
    public Result checkout(Map<String, Integer> map, Integer ExtraDiscount) {
        //取出map中水果的名称和斤数,计算总价
        Double totalPrice = 0.0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String fruitName = entry.getKey();
            Integer fruitNum = entry.getValue();
            //根据水果名称和斤数，计算出该水果的总价
            FruitEnum fruitByName = FruitEnum.getFruitEnumByName(fruitName);
            if (fruitByName == null) {
                return Result.errorMessage("请检查是否添加了该水果");
            }
            totalPrice += fruitByName.getPrice() * fruitNum * fruitByName.getDiscount();

        }
        //判断是否满100减10
        if (totalPrice >= 100 && ExtraDiscount == 1) {
            totalPrice = totalPrice - (int)(totalPrice/ 100) * 10;
        }
        //todo 待删除
        System.out.println("总价为：" + totalPrice);
        return Result.ok(totalPrice);
    }

}
