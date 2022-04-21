package com.idolticketing.idolticketing.dao;


import com.idolticketing.idolticketing.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {
     int registUser(UserDTO userDTO);
     int loginUser(String id,String password);
     int logoutUser(UserDTO userDTO);
     int updatePassword(String userDTO);
     int deleteUser(UserDTO userDTO);

}
