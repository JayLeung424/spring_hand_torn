package com.spring.springframework.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName: FileSystemResource
 * @Description: 文件系统资源加载类
 * 指定文件路径的方式读取文件信息
 * @Author: jay
 **/
public class FileSystemResource implements Resource{
    private final String path;

    private final File file;

    public FileSystemResource(String path) {
        this.path = path;
        this.file = new File(path);
    }

    public FileSystemResource(File file) {
        this.file = file;
        this.path = file.getPath();
    }


    @Override
    public InputStream getInputStream() throws IOException{
        return new FileInputStream(this.file);
    }

    public String getPath() {
        return this.path;
    }

    public File getFile() {
        return this.file;
    }
}
