package com.yongzh.autoConfig;

import com.yongzh.Service.IpCountService;
import org.springframework.context.annotation.Bean;

/**
 * @author yongzh
 * @version 1.0
 * @description: TODO
 * @date 2023/12/22 0:14
 */
public class IpAutoConfiguration {
    @Bean
    public IpCountService ipCountService(){
        return new IpCountService();
    }
}
