package com.idolticketing.idolticketing.dao;

import dto.HelpDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HelpMapper {

    int createBoard(HelpDTO helpDTO);
    int updateBoard(HelpDTO helpDTO);
    int deleteBoard(HelpDTO helpDTO);
    int deleteBoardAdmin(HelpDTO helpDTO);

}

