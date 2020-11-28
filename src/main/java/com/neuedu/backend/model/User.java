package com.neuedu.backend.model;

import lombok.Data;

@Data
public class User extends BaseModel {
    private String username;
    private String password;
}
