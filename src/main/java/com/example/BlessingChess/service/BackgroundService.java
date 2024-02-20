package com.example.BlessingChess.service;

import com.example.BlessingChess.data.vo.Result;
import com.example.BlessingChess.utils.ImageStorageUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * 背景服务类，负责处理背景的上传和查询。
 *
 * @author LXY
 * @version 1.0
 * @since 2024-02-20
 */
@Service
public class BackgroundService {
    /**
     * 图片存储工具实例，用于处理背景的存储。
     */
    ImageStorageUtils imageStorageUtils = new ImageStorageUtils("background");

    /**
     * 上传背景的方法。
     *
     * @param file 上传的文件
     * @param userId 用户ID
     * @return 返回操作结果
     */
    public Result uploadBackground(MultipartFile file, Integer userId){
        imageStorageUtils.storeImage(file, userId);
        return Result.ok();
    }

    /**
     * 根据用户ID查询背景路径的方法。
     *
     * @param userId 用户ID
     * @return 返回背景路径列表及操作结果
     */
    public Result selectBackgroundPaths(Integer userId){
        return Result.success(imageStorageUtils.getImagePathsForUser(userId),"success");
    }
}
