package com.example.BlessingChess.utils;

import com.example.BlessingChess.config.HttpConverterConfig;
import com.example.BlessingChess.data.po.ImageData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 工具类，用于处理图片文件的存储。
 *
 * @author LXY
 * @version 1.0
 * @since 2024.2.19
 */
public class ImageStorageUtils {
    /**
     * 上传目录的静态路径前缀。
     */
    @Value("${uploadDirectory}")
    private String uploadDirectory = HttpConverterConfig.uploadDirectory;

    /**
     * 图片存储目录。
     */
    private final String directory;

    /**
     * 构造方法，用于创建ImageStorageUtils实例。
     *
     * @param directory 图片存储目录
     */
    public ImageStorageUtils(String directory){
        this.directory=directory;
    }

    /**
     * 存储图片文件的方法。
     *
     * @param file        要存储的MultipartFile对象
     * @param userId      用户ID，用于构建存储目录
     * @throws IllegalArgumentException 如果文件为空
     * @throws RuntimeException         如果文件存储失败
     */
    public void storeImage(MultipartFile file, Integer userId) {
        // 验证文件不为空
        if (file.isEmpty()) {
            throw new IllegalArgumentException("File is empty");
        }

        // 生成UUID作为文件名
        String fileName = UUID.randomUUID().toString() + "." + getFileExtension(file.getOriginalFilename());

        // 构建保存路径
        String savePath = uploadDirectory + directory + "/"+userId.toString() + "/";
        File saveDir = new File(savePath);

        // 如果目录不存在，则创建目录
        if (!saveDir.exists()) {
            saveDir.mkdirs();
        }

        // 构建文件保存完整路径
        Path saveFilePath = Paths.get(savePath, fileName);

        // 保存文件
        try {
            Files.copy(file.getInputStream(), saveFilePath);

        } catch (IOException e) {
            throw new RuntimeException("Failed to store image");
        }
    }

    /**
     * 辅助方法，用于获取文件的扩展名。
     *
     * @param fileName 文件的原始名称
     * @return         文件的扩展名（包括点号"."），如果文件没有扩展名则返回空字符串
     */
    private String getFileExtension(String fileName) {
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf("."));
        }
        return "";
    }

    /**
     * 获取指定用户ID目录下的和公共的图片文件的绝对路径列表。
     *
     * @param userId      用户ID，用于定位用户的特定目录
     * @return            包含所有图片文件绝对路径的列表；如果目录不存在或不是目录，将抛出异常
     * @throws IllegalArgumentException 如果指定的路径不存在或不是一个目录
     */
    public List<ImageData> getImagePathsForUser(Integer userId) {
        //获取公共的图片
        List<ImageData> filePaths = getImagePaths(0);
        //添加用户的图片
        filePaths.addAll(getImagePaths(userId));
        return filePaths;
    }

    /**
     * 获取指定ID目录下的所有图片文件的绝对路径列表。
     *
     * @param id      用户ID，用于定位用户的特定目录
     * @return            包含所有图片文件绝对路径的列表；如果目录不存在或不是目录，将抛出异常
     * @throws IllegalArgumentException 如果指定的路径不存在或不是一个目录
     */
    public List<ImageData> getImagePaths(Integer id) {
        String directoryPath =uploadDirectory + directory + "/" + id.toString() + "/";
        File directories = new File(directoryPath);

        // 验证目录是否存在
        if (!directories.exists()  || !directories.isDirectory()) {
            return new ArrayList<ImageData>();
        }

        // 收集所有文件的路径
        List<ImageData> filePaths = new ArrayList<>();
        File[] files = directories.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    filePaths.add(new ImageData("/image/" +
                            file.getAbsolutePath()  //将文件路径转化为url路径
                                    .substring(uploadDirectory.length())
                                    .replace("\\", "/"),id));
                }
            }
        }
        return filePaths;
    }
}
