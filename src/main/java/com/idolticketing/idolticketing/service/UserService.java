package com.idolticketing.idolticketing.service;

import dto.UserDTO;


public interface UserService {


    int register(UserDTO userDTO);

    UserDTO login(UserDTO userDTO);

    UserDTO updateUser(UserDTO userDTO);

    UserDTO getUserInfo(String userId);

    int logout(UserDTO userDTO);

    int delete(UserDTO userDTO);


}
