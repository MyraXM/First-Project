package cn.wolfcode.lww.service;

import cn.wolfcode.lww.domain.User;

import java.util.List;

public interface UserService {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
    /*
     *
     * 根据用户名和密码查询信息
     * @param user 储存用户和密码
     *
     * */
    User queryUserByUserNameAndPwd(User user);


}
