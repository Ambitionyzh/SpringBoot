package com.yongzh.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0
 * @description: TODO
 * @date 2023/12/21 23:38
 */
@Service
public class IpCountService {
    private Map<String,Integer> ipCountMap = new HashMap<String,Integer>(16);

    @Autowired
    private HttpServletRequest httpServletRequest;

    public void count() {
        System.out.println("------------开始记录访问ip---------------");
        //每次调用记录，就记录当前访问的IP，然后累加访问次数
        //1获取当前ip地址
        String ip = httpServletRequest.getRemoteAddr();
        System.out.println("------------开始记录访问ip---------------"+ip);
        //2.根据ip地址从Map取值，并递增。
        Integer count = ipCountMap.get(ip);
        if(count == null){
            ipCountMap.put(ip, 1);
        }else{
            ipCountMap.put(ip,count + 1);
        }


    }
}
