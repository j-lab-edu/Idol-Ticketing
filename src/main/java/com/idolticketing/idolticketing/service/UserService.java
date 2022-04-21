package com.idolticketing.idolticketing.service;

import com.idolticketing.idolticketing.dto.UserDTO;


public interface UserService {

    //회원가입
    int register(UserDTO userDTO);
    //로그인
    int login(String id, String password);

    int password(String password);

    int logout(UserDTO userDTO);

    int delete(UserDTO userDTO);


}
