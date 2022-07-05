package com.idolticketing.idolticketing.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HelpDTO {
    private int num;
    private int id;
    private int count;
    private String title;
    private String description;
    private String userId;
    private Boolean isAdmin;


    public HelpDTO(){

    }
    public HelpDTO(int num,int id, int count,String title,String description,String userId,Boolean isAdmin){
        this.num = num;
        this.id = id;
        this.count = count;
        this.title = title;
        this.description = description;
        this.userId = userId;
        this.isAdmin = isAdmin;
    }



}
