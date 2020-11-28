package com.neuedu.backend.dao;

import com.neuedu.backend.model.BaseModel;

import java.util.List;

public interface BaseDao<T extends BaseModel> {
    //泛型
    //公有的方法，增删改 insert update find findById findList delete insertBatch
    void insert(T t);

    void update(T t);

    void deleteById(Long id);

    T find(T condition);

    T findById(Long id);

    List<T> findList(T condition);

    List<T> findAll();
}
