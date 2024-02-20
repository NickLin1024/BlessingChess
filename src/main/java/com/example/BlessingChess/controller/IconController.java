package com.example.BlessingChess.controller;

import com.example.BlessingChess.data.vo.Result;
import com.example.BlessingChess.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 图标控制器类，负责处理与图标相关的HTTP请求。
 *
 * @author LXY
 * @version 1.0
 * @since 2024-02-20
 */
@RestController
@RequestMapping("/icon")
public class IconController {
    /**
     * 图标服务实例，通过Spring的自动装配功能注入。
     */
    @Autowired
    IconService iconService;

    /**
     * 上传图标的方法。
     *
     * @param id 用户ID
     * @param image 上传的图片文件
     * @return 返回操作结果
     */
    @PostMapping("/{id}")
    public Result uploadIcon(@PathVariable Integer id, @RequestParam MultipartFile image){
        return iconService.uploadIcon(image, id);
    }

    /**
     * 根据用户ID查询图标路径的方法。
     *
     * @param id 用户ID
     * @return 返回图标路径列表及操作结果
     */
    @GetMapping("/{id}")
    public Result selectIconPaths(@PathVariable Integer id){
        return iconService.selectIconPaths(id);
    }
}
