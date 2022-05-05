package com.idolticketing.idolticketing.service.Impl;

import com.idolticketing.idolticketing.dao.UserMapper;
import com.idolticketing.idolticketing.dto.UserDTO;
import com.idolticketing.idolticketing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
//회원가입
    @Override
    public int register(UserDTO userDTO) {
        return userMapper.registUser(userDTO);
    }

    @Override
    public UserDTO login(UserDTO userDTO) {
        return userMapper.findByIdAndPassword(userDTO);

    }

    @Override
    public int updateUser(UserDTO userDTO) {
        return userMapper.updateUser(userDTO);

    }

    @Override
    public UserDTO getUserInfo(String userId) {
        return userMapper.getUser(userId);
    }

    public int logout(UserDTO userDTO) {
        return userMapper.logoutUser(userDTO);
    }

    @Override
    public int delete(UserDTO userDTO) {
        return userMapper.deleteUser(userDTO);
    }

}
