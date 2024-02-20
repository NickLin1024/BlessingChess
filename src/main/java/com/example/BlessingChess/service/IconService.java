package com.example.BlessingChess.service;

import com.example.BlessingChess.data.vo.Result;
import com.example.BlessingChess.utils.ImageStorageUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * 图标服务类，负责处理图标的上传和查询。
 *
 * @author LXY
 * @version 1.0
 * @since 2024-02-20
 */
@Service
public class IconService {
    /**
     * 图片存储工具实例，用于处理图标的存储。
     */
    ImageStorageUtils imageStorageUtils = new ImageStorageUtils("icon");

    /**
     * 上传图标的方法。
     *
     * @param file 上传的文件
     * @param userId 用户ID
     * @return 返回操作结果
     */
    public Result uploadIcon(MultipartFile file, Integer userId){
        imageStorageUtils.storeImage(file, userId);
        return Result.ok();
    }

    /**
     * 根据用户ID查询图标路径的方法。
     *
     * @param userId 用户ID
     * @return 返回图标路径列表及操作结果
     */
    public Result selectIconPaths(Integer userId){
        return Result.success(imageStorageUtils.getImagePathsForUser(userId),"success");
    }
}
