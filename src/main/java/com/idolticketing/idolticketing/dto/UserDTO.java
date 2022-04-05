package com.idolticketing.idolticketing.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDTO {
    private String userid;
    private String name;
    private String password;
    private String email;
    private String phone;
    private String address;
    private boolean isAdmin;
    private String id;
    private Date createTime;
    private Date updateTime;
    private Date lastLoginTime;

    public UserDTO(String userid,String name,String password, String email,String phone,String address,boolean isAdmin,
                   String id,Date createTime,Date updateTime,Date lastLoginTime){
        this.userid = userid;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.isAdmin = isAdmin;
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.lastLoginTime = lastLoginTime;

    }
}
