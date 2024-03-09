package com.example.BlessingChess.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * HttpConverterConfig 类，用于配置Web应用程序的HTTP转换器和资源处理器。
 * 实现WebMvcConfigurer接口以自定义Spring MVC的默认配置。
 *
 * @author LXY
 * @version 1.0
 * @since 2024-02-20
 */
@Configuration
public class HttpConverterConfig implements WebMvcConfigurer {
    /**
     * 上传和读取图片的目录路径。
     * 该目录应存在且应用程序应具有写入权限。
     */
    public static final String uploadDirectory = "image/";//使用相对路径，image在项目的根路径中（最大的那个）

    /**
     * 配置资源处理器，用于从指定目录提供静态资源。
     *
     * @param registry 资源处理器注册表，用于注册资源处理器
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**").addResourceLocations("file:" + uploadDirectory);
    }

}
