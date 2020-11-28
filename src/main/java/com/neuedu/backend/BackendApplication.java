package com.neuedu.backend;

import com.neuedu.backend.interceptor.AuthInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
// 配置mybatis接口所属的包
@MapperScan("com.neuedu.backend.dao")
public class BackendApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    /**
     * 配置拦截器
     *
     * @param registry 拦截器的注册器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor())
                //拦截所有请求，除了登录请求
                .addPathPatterns("/**").excludePathPatterns("/login");
    }
}
