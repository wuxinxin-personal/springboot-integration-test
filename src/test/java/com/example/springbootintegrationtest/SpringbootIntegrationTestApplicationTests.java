package com.example.springbootintegrationtest;

import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class SpringbootIntegrationTestApplicationTests {

    @Autowired
    private FileSystem fileSystem;

    @Test
    void contextLoads() {
    }

    @Test
    void hadoopTest() throws Exception {

        fileSystem.copyFromLocalFile(
                new Path("/Users/wuxinxin/IdeaProjects/springboot-integration-test/src/main/java/com/example/springbootintegrationtest/config/HadoopConfig.java"),
                new Path("/user"));

    }

}
