package com.idolticketing.idolticketing.service;

import com.idolticketing.idolticketing.dto.UserDTO;
import org.apache.catalina.User;


public interface UserService {

    //회원가입
    int register(UserDTO userDTO);
    //로그인
    UserDTO login(UserDTO userDTO);

    int password(UserDTO userDTO);

    UserDTO getUserInfo(String userId);

    int logout(UserDTO userDTO);

    int delete(UserDTO userDTO);


}
