package com.icbc.purchase.enums;

public enum FruitEnum implements BasicEnum {

    // 苹果
    APPLE("apple", 8.0,1.0),
    // 草莓
    STRAWBERRY("strawberry", 13.0, 0.8),
    // 芒果
    MANGO("mango", 20.0, 1.0),
    ;

    private String name;

    private Double discount;
    private Double price;

    //根据水果名称获取水果的折扣和价格
    public static FruitEnum getFruitEnumByName(String name) {
        for (FruitEnum fruitEnum : FruitEnum.values()) {
            if (fruitEnum.getName().equals(name)) {
                return fruitEnum;
            }
        }
        return null;
    }

    FruitEnum(String name, Double price,Double discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double getDiscount() {
        return discount;
    }

    @Override
    public Double getPrice() {
        return price;
    }
}
