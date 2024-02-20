package com.example.BlessingChess.controller;

import com.example.BlessingChess.data.vo.Result;
import com.example.BlessingChess.service.BackgroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 背景控制器类，负责处理与背景图片相关的HTTP请求。
 *
 * @author LXY
 * @version 1.0
 * @since 2024-02-20
 */
@RestController
@RequestMapping("/background")
public class BackgroundController {
    /**
     * 背景服务实例，通过Spring的自动装配功能注入。
     */
    @Autowired
    BackgroundService backgroundService;

    /**
     * 上传背景图片的方法。
     *
     * @param id 用户ID
     * @param image 上传的图片文件
     * @return 返回操作结果
     */
    @PostMapping("/{id}")
    public Result uploadBackground(@PathVariable Integer id, @RequestParam MultipartFile image){
        return backgroundService.uploadBackground(image, id);
    }

    /**
     * 根据用户ID查询背景图片路径的方法。
     *
     * @param id 用户ID
     * @return 返回背景图片路径列表及操作结果
     */
    @GetMapping("/{id}")
    public Result selectBackgroundPaths(@PathVariable Integer id){
        return backgroundService.selectBackgroundPaths(id);
    }
}
