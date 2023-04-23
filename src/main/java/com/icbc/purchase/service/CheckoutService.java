package com.icbc.purchase.service;

import com.icbc.purchase.entity.dto.Result;

import java.util.Map;

public interface CheckoutService {

    Result checkout(Map<String, Integer> map, Integer ExtraDiscount);

}
