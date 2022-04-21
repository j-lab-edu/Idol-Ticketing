package com.idolticketing.idolticketing.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BookDTO {
    private String userid;
    private String type;
    private int contentId;
    private Date createTime;
    private Date updateTime;
    private int id;

    public BookDTO(String userid, String type, int contentId, Date createTime, Date updateTime, int id){
        this.userid = userid;
        this.type = type;
        this.contentId = contentId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.id = id;
    }


}
