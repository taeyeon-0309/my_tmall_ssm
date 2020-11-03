package com.iu2java.tmall.service;

import com.iu2java.tmall.pojo.Property;

import java.util.List;

public interface PropertyService {
    void add(Property p);
    void delete(int id);
    void update(Property c);
    Property get(int id);
    List list(int cid);
}
