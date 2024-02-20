package com.example.BlessingChess.data.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 表示一张图片的类。
 *
 * @author LXY
 * @version 1.0
 * @since 2024-02-20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageData {
    /**
     * 图片的URL地址。
     */
    private String url;

    /**
     * 图片的所有者ID。
     * 0表示为公共的
     */
    private Integer owner;
}
