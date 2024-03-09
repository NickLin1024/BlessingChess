package com.example.BlessingChess.filter;

import com.alibaba.fastjson.JSONObject;
import com.example.BlessingChess.data.vo.Result;
import com.example.BlessingChess.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * 登录检查过滤器，用于拦截所有请求并进行登录验证。
 *
 * @author LXY
 * @version 1.0
 * @since 2024-02-5
 */
@WebFilter(urlPatterns = "/*") //拦截所有请求
public class LoginCheckFilter implements Filter {

    /**
     * 对请求进行过滤，检查用户是否已登录。
     *
     * @param servletRequest  HTTP请求对象
     * @param servletResponse HTTP响应对象
     * @param chain           过滤器链，用于继续传递请求
     * @throws IOException      如果发生I/O错误
     * @throws ServletException 如果发生Servlet异常
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

        //前置：强制转换为http协议的请求对象、响应对象
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //获取请求url
        String url = request.getRequestURL().toString();
        System.out.println(url);

        //判断请求url中是否包含login，如果包含，说明是登录操作，放行
        if(url.contains("/user/login")||url.contains("/test")||url.contains("/image")){
            chain.doFilter(request, response);//放行请求
            return;//结束当前方法的执行
        }

        String token;

        if (request.getHeader("Authorization")==null){
            Result responseResult = Result.error(0,"NO_TOKEN");
            //把Result对象转换为JSON格式字符串 (fastjson是阿里巴巴提供的用于实现对象和json的转换工具类)
            String json = JSONObject.toJSONString(responseResult);
            response.setContentType("application/json;charset=utf-8");
            //响应
            response.getWriter().write(json);
            return;
        }else {
            //获取请求头中的令牌（token）
            token = request.getHeader("Authorization").substring(6);
        }

        //判断令牌是否存在，如果不存在，返回错误
        if(!StringUtils.hasLength(token)){	//说明字符串为空串或者null

            Result responseResult = Result.error(0,"NOT_LOGIN");
            //把Result对象转换为JSON格式字符串 (fastjson是阿里巴巴提供的用于实现对象和json的转换工具类)
            String json = JSONObject.toJSONString(responseResult);
            response.setContentType("application/json;charset=utf-8");
            //响应
            response.getWriter().write(json);

            return;
        }

        //解析token，如果解析失败，返回错误结果（未登录）
        try {
            JwtUtils.parseJWT(token);
        }catch (Exception e){

            Result responseResult = Result.error(0,"NOT_LOGIN");
            //把Result对象转换为JSON格式字符串
            String json = JSONObject.toJSONString(responseResult);
            response.setContentType("application/json;charset=utf-8");
            //响应
            response.getWriter().write(json);

            return;
        }


        //放行
        chain.doFilter(request, response);

    }
}