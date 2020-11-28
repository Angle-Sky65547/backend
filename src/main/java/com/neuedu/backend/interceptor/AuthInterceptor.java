package com.neuedu.backend.interceptor;

import com.neuedu.backend.model.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 创建权限拦截器
 */
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1.获取session，如果有session，再检查session中是否有user对象，如果有，我就放行
        HttpSession session = request.getSession(false);
        if (session != null) {
            //获取user对象
            User user = (User) session.getAttribute("user");
            if (user != null) {
                //已经登录，可以放行
                return true;
            }
        }

        //2 如果验证失败，返回状态码401，以及失败的信息
        response.setStatus(401);
        response.getWriter().write("forbidden");
        return false;
    }
}
