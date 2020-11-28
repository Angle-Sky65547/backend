package com.neuedu.backend.dao;

import com.neuedu.backend.model.User;
import org.apache.ibatis.annotations.Select;

public interface UserDao extends BaseDao<User> {

    @Select("select * from t_user where username=#{username}")
    User findByUsername(String username);

}
