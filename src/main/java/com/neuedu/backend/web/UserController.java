package com.neuedu.backend.web;

import com.neuedu.backend.dao.UserDao;
import com.neuedu.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @PostMapping("/login")
    public User login(@RequestBody User user, HttpServletResponse response, HttpSession session) {
        User result = userDao.findByUsername(user.getUsername());
        //判断结果不为空且密码输入正确，登录成功，直接返回结果的user对象
        if (result != null && result.getPassword().equals(user.getPassword())) {
            //为当前登录客户端创建一个session，并且在session中可以存储用户的信息
            session.setAttribute("user", result);
            return result;
        }
        // 如果用户名和密码输入错误，那么直接修改状态 码为403，告知前台登录失败，返回空数据
        response.setStatus(403);
        return null;
    }
}
