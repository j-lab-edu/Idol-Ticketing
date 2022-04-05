package com.idolticketing.idolticketing.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BookDTO {
    private String userid;
    private String type;
    private int contentid;
    private Date createTime;
    private Date updateTime;
    private int id;

    public BookDTO(String userid, String type, int contentid, Date createTime, Date updateTime, int id){
        this.userid = userid;
        this.type = type;
        this.contentid = contentid;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.id = id;
    }


}
