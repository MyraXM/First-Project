package cn.wolfcode.lww.service.impl;

import cn.wolfcode.lww.domain.User;
import cn.wolfcode.lww.mapper.UserMapper;
import cn.wolfcode.lww.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/*
* alt+ enter xuan impl... 全选
*
* */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<User> selectAll() {
        return null;
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return 0;
    }

    @Override
    public User queryUserByUserNameAndPwd(User user) {
        return userMapper.queryUserByUserNameAndPwd(user);
    }
}
