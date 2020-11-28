package com.neuedu.backend.model;

import lombok.Data;

@Data
public class Customer extends BaseModel {
    private String account;
    private String password;
    private String identity;
    private String gender;
    private String telNumber;
    private String email;
}
