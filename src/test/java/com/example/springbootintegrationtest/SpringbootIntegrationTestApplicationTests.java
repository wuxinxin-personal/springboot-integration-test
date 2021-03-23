package com.example.springbootintegrationtest;

//import com.example.test.autoconfig.BambooServer;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootIntegrationTestApplicationTests {

    @Autowired
    private FileSystem fileSystem;

    /*@Autowired
    private BambooServer bambooServer;*/

   /* @Test
    void contextLoads() {
        System.out.println(bambooServer.getName());
    }*/


    @Test
    void hadoopTest() throws Exception {

        fileSystem.copyFromLocalFile(
                new Path("/Users/wuxinxin/IdeaProjects/springboot-integration-test/src/main/java/com/example/springbootintegrationtest/config/HadoopConfig.java"),
                new Path("/user"));

    }


    @Test
    void hadoopTest1() throws Exception {

        fileSystem.copyToLocalFile(
                new Path("/user"),
                new Path("test.java"));

    }

}
