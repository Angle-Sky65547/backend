package com.neuedu.backend.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neuedu.backend.dao.BaseDao;
import com.neuedu.backend.model.BaseModel;
import com.neuedu.backend.model.PageCondition;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 业务service的父类，抽象共同方法
 */
public class BaseService<D extends BaseDao<T>, T extends BaseModel> {

    @Autowired  // spring的泛型依赖注入
    protected D dao;

    public void insert(T t) {
        dao.insert(t);
    }

    public void update(T t) {
        dao.update(t);
    }

    public void deleteById(Long id) {
        dao.deleteById(id);
    }

    public List<T> findList(T condition) {
        return dao.findList(condition);
    }

    public T find(T condition) {
        return dao.find(condition);
    }

    public T findById(Long id) {
        return dao.findById(id);
    }

    public List<T> findAll() {
        return dao.findAll();
    }

    /**
     * 用pageHelper进行分页查询
     *
     * @return
     */
    public PageInfo<T> page(PageCondition<T> pageCondition) {
        return PageHelper.startPage(pageCondition.getPageNum(), pageCondition.getPageSize())
                .doSelectPageInfo(() -> dao.findList(pageCondition.getCondition()));
    }
}
