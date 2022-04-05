package com.idolticketing.idolticketing.service;

import com.idolticketing.idolticketing.dto.UserDTO;


public interface UserService {

    void register(UserDTO user);
    void login(String id, String password);
    void password(String password);
    void userid(String id, String password);

}
