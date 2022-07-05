package com.idolticketing.idolticketing.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class BookDTO {
    private String userId;
    private String category;
    private String contentId;
    private Date createTime;
    private Date updateTime;
    private int id;
    private String bookState;

    public BookDTO(String bookState,String userId, String category, String contentId, Date createTime, Date updateTime, int id){
       this.bookState = bookState;
        this.userId = userId;
        this.category = category;
        this.contentId = contentId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.id = id;
    }


    public BookDTO() {

    }

}
