package com.iu2java.tmall.service;

import com.iu2java.tmall.pojo.Product;
import com.iu2java.tmall.pojo.PropertyValue;

import java.util.List;

public interface PropertyValueService {

    void init(Product p);
    void update(PropertyValue pv);

    //根据属性id和产品id获取对应的属性值
    PropertyValue get(int ptid, int pid);
    //根据产品id获取所有的属性值列表
    List<PropertyValue> list(int pid);
}
