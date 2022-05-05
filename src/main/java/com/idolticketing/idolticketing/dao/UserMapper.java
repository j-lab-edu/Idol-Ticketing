package com.idolticketing.idolticketing.dao;


import com.idolticketing.idolticketing.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {
     int registUser(UserDTO userDTO);
     int loginUser(String id,String password);
     // TODO: password만 변경되었던 정보를 userDTO 전체를 변경하기.
     int logoutUser(UserDTO userDTO);
     int updatePassword(UserDTO userDTO);
     int updateUser(UserDTO userDTO);
     int deleteUser(UserDTO userDTO);
     UserDTO findByIdAndPassword (UserDTO userDTO);
     UserDTO getUser (String userId);

}
