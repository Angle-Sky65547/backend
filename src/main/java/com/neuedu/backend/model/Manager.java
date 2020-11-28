package com.neuedu.backend.model;

import lombok.Data;

@Data
public class Manager extends BaseModel {
    private String account ;
    private String pwd;
    private String idcard;
    private String telephone;
    private String email;
}
