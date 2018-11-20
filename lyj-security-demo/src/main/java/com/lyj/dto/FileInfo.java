package com.lyj.dto;

import lombok.Data;

/**
 * @auther lyj
 * @date 2018/11/20 0020 下午 14:09
 */
@Data
public class FileInfo {
    public FileInfo(String path){
        this.path=path;
    }

    private String path;


}
