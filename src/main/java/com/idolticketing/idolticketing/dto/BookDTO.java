package com.idolticketing.idolticketing.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BookDTO {
    private String userId;
    private String category;
    private String contentId;
    private Date createTime;
    private Date updateTime;
    private int id;

    public BookDTO(){
    }

    public BookDTO(String userId, String category, String contentId, Date createTime, Date updateTime, int id){
        this.userId = userId;
        this.category = category;
        this.contentId = contentId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.id = id;
    }


}
