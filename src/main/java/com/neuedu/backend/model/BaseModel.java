package com.neuedu.backend.model;

import lombok.Data;

/**
 * 所有实体类的父类，抽象了实体类一些共通属性和方法
 */
@Data
public class BaseModel {

    protected Long id;
    protected String flag;
}
