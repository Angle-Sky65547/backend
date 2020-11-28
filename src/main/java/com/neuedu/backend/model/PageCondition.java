package com.neuedu.backend.model;

import lombok.Data;

/**
 * 分页查询的条件：包含，当前查询页码，每页条目数，条件对象
 */
@Data
public class PageCondition<T> {

    private Integer pageNum; //查询页码
    private Integer pageSize; // 每页条目数
    private T condition; //查询条件对象

}
