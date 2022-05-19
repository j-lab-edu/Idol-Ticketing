package com.idolticketing.idolticketing.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Blob;
import java.util.Date;

@Data
@Builder
public class ContentDTO {
    private int id;
    private String name;
    private long price;
    private Blob picture;
    private String description;
    private Date date;
    private String location;
    private String seat;
    private ContentCategory category;
    private String userId;
    private Date createTime;
    private Date updateTime;
    private int popularity;
    private Date deadLine;
    private String keyword;
    private SortType sortType;
    private UpDownType upDownType;
    private int limitCount;
    private ContentCategory contentCategory;

    public ContentDTO() {
    }

    public ContentDTO(int id, String name, long price, Blob picture, String description, Date date, String location,
                      String seat, ContentCategory category, String userId, Date createTime, Date updateTime, int popularity, Date deadLine, String keyword,
                      SortType sortType, UpDownType upDownType, int limitCount,ContentCategory contentCategory) {
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
        this.keyword = keyword;
        this.sortType = sortType;
        this.upDownType = upDownType;
        this.limitCount = limitCount;
        this.contentCategory = contentCategory;

    }


}
