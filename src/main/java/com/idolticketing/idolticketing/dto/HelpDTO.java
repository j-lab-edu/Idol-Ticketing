package com.idolticketing.idolticketing.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HelpDTO {
    private int id;
    private int count;
    private String title;
    private String description;
    private String userid;

    public HelpDTO(){

    }
    public HelpDTO(int id, int count,String title,String description,String userid){
        this.id = id;
        this.count = count;
        this.title = title;
        this.description = description;
        this.userid = userid;
    }



}
