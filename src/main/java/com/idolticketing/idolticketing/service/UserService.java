package com.idolticketing.idolticketing.service;

import com.idolticketing.idolticketing.dto.UserDTO;
import org.apache.catalina.User;


public interface UserService {


    UserDTO register(UserDTO userDTO);

    UserDTO login(UserDTO userDTO);

    UserDTO updateUser(UserDTO userDTO);

    UserDTO getUserInfo(String userId);

    int logout(UserDTO userDTO);

    int delete(UserDTO userDTO);


}
