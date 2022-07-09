package com.idolticketing.idolticketing.dao;


import dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
     int registUser(UserDTO userDTO);
     UserDTO loginUser(String id,String password);
     int logoutUser(UserDTO userDTO);
     int updatePassword(UserDTO userDTO);
     UserDTO updateUser(UserDTO userDTO);
     int deleteUser(UserDTO userDTO);
     UserDTO findByIdAndPassword (UserDTO userDTO);
     UserDTO getUser (String userId);

}
