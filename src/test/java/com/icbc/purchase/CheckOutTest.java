package com.icbc.purchase;

import com.icbc.purchase.entity.dto.Result;
import com.icbc.purchase.service.CheckoutService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CheckOutTest {

    @Autowired
    private CheckoutService checkoutService;

    // 问题1测试用例
    @Test
    public void test01() {
        Map<String, Integer> map = new HashMap<>();
//        map.put("apple", 3);
        map.put("apple", 4);
        map.put("strawberry", 7);
        Result checkout = checkoutService.checkout(map, 0);
        System.out.println(checkout);
    }

    // 问题2测试用例
    @Test
    public void test02() {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 1);
//        map.put("strawberry", 6);  //临界值测试
        map.put("strawberry", 7);
        map.put("mango", 1);
        Result checkout = checkoutService.checkout(map, 0);
        System.out.println(checkout);
    }

    // 问题3测试用例
    @Test
    public void test03() {
        Map<String, Integer> map = new HashMap<>();
//        map.put("apple", 3);
        map.put("apple", 4);
        map.put("strawberry", 7);
        map.put("mango", 6);
        Result checkout = checkoutService.checkout(map, 0);
        System.out.println(checkout);
    }



    // 问题4测试用例
    @Test
    public void test04() {
        Map<String, Integer> map = new HashMap<>();
//        map.put("apple", 3);
        map.put("apple", 4);
        map.put("strawberry", 7);
        map.put("mango", 6);
        Result checkout = checkoutService.checkout(map, 1);
        System.out.println(checkout);
    }



}
