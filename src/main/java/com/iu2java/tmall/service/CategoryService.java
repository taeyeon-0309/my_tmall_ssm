package com.iu2java.tmall.service;

import com.iu2java.tmall.pojo.Category;
import com.iu2java.tmall.util.Page;

import java.util.List;

public interface CategoryService {

    List<Category> list();
    void add(Category category);
    void delete(int id);

    Category get(int id);

    void update(Category category);
}
