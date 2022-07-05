package com.idolticketing.idolticketing.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import java.util.Date;

@Data
@Builder
public class UserDTO {

    private String userId;
    private String name;
    private String password;
    @Email
    private String email;
    private String phone;
    private String address;
    private boolean isAdmin;
    private String id;
    private Date createTime;
    private Date updateTime;
    private Date lastLoginTime;

    public UserDTO(){
    }

    public UserDTO(String userId,String name,String password, String email,String phone,String address,boolean isAdmin,
                   String id,Date createTime,Date updateTime,Date lastLoginTime){

        this.userId = userId;
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
