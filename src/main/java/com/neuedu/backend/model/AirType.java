package com.neuedu.backend.model;

import lombok.Data;

@Data
public class AirType extends BaseModel{

    private String code;
    private Integer fnumber;
    private Integer cnumber;
    private Integer unumber;
    private Integer totalnumber;
}
