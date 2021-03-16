package com.example.springbootintegrationtest.config;

import org.apache.hadoop.fs.FileSystem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * 集成hadoop
 */
@Configuration
public class HadoopConfig {


    @Value("${hadoop.node}")
    private String hadoopNode;

    @Bean("fileSystem")
    public FileSystem createFs() throws Exception {
        //读取配置文件
        org.apache.hadoop.conf.Configuration conf = new org.apache.hadoop.conf.Configuration();
        conf.set("fs.defalutFS", hadoopNode);
        conf.set("dfs.client.use.datanode.hostname","true");
        conf.set("dfs.replication", "1");
        FileSystem fs = null;
        // 返回指定的文件系统,如果在本地测试，需要使用此种方法获取文件系统
        fs = FileSystem.get(new URI(hadoopNode), conf, "root");
        return  fs;
    }

}
