package com.neuedu.backend.model;

import lombok.Data;


@Data
public class Flight extends  BaseModel{
    private String code;
    private String no;
    private String baddress;
    private String aaddress;
    private String btime;
    private String atime;
    private String fflag;

    public void setBtime(String btime) {
        this.btime = btime;
    }

    public void setAtime(String atime) {
        this.atime = atime;
    }
}
