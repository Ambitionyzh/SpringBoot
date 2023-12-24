package com.example.autoConfig;


import com.example.Service.IpCountService;
import com.example.properties.IpProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * @author yongzh
 * @version 1.0
 * @description: TODO
 * @date 2023/12/22 0:14
 */
@Import(IpProperties.class)
public class IpAutoConfiguration {
    @Bean
    public IpCountService ipCountService(){
        return new IpCountService();
    }
}
