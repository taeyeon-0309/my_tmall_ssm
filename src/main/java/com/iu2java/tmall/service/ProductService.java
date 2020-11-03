package com.iu2java.tmall.service;

import com.iu2java.tmall.pojo.Product;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 1
 */

public interface ProductService {
    void add(Product p);
    void delete(int id);
    void update(Product p);
    Product get(int id);
    List list(int cid);
    void setFirstProductImage(Product p);
}
