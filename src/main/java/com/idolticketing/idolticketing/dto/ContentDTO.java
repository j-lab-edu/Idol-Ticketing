package com.idolticketing.idolticketing.dto;

import lombok.Data;

import java.sql.Blob;
import java.util.Date;

@Data
public class ContentDTO {
    private int id;
    private String name;
    private long price;
    private Blob picture;
    private String description;
    private Date date;
    private String location;
    private String seat;
    private String category;
    private String userId;
    private Date createTime;
    private Date updateTime;
    private int popularity;
    private Date deadLine;
    private String keyword;

    public ContentDTO(){
    }

    public ContentDTO(int id, String name, long price, Blob picture, String description, Date date,String location,
                      String seat,String category,String userId,Date createTime,Date updateTime,int popularity, Date deadLine,String keyword){
        this.id = id;
        this.name = name;
        this.price = price;
        this.picture = picture;
        this.description = description;
        this.date = date;
        this.location = location;
        this.seat = seat;
        this.category = category;
        this.userId = userId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.popularity = popularity;
        this.deadLine = deadLine;
        this.keyword= keyword;

    }


}
