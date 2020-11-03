package com.iu2java.tmall.service;

import com.iu2java.tmall.mapper.OrderItemMapper;
import com.iu2java.tmall.pojo.Order;
import com.iu2java.tmall.pojo.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface OrderItemService {
    void add(OrderItem oi);

    void delete(int id);

    void update(OrderItem oi);

    OrderItem get(int id);

    List list();

    void fill(List<Order> orders);

    void fill(Order order);
}
