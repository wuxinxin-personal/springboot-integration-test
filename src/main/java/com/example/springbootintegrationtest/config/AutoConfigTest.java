package com.example.springbootintegrationtest.config;

//import com.example.test.autoconfig.BambooServer;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/**
 * @author wuxinxin
 *
 * 自己创建的starter测试其原理
 */
@Configuration
public class AutoConfigTest implements ApplicationContextAware {

    /*@Autowired
    private BambooServer bambooServer;*/


    private ApplicationContext applicationContext;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
        //System.out.println(bambooServer);
        //System.out.println(bambooServer.getName());
    }
}
