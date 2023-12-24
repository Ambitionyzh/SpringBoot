package com.example.Service;


import com.example.properties.IpProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
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
    @Autowired
    private IpProperties ipProperties;

    //    @Scheduled(cron = "0/${tools.ip.cycle:5} * * * * ?")
//    @Scheduled(cron = "0/#{ipProperties.cycle} * * * * ?")
    @Scheduled(cron = "0/#{ipProperties.cycle} * * * * ?")
    public void print(){

        if(ipProperties.getModel().equals(IpProperties.LogModel.DETAIL.getValue())){
            System.out.println("         IP访问监控");
            System.out.println("+-----ip-address-----+--num--+");
            for (Map.Entry<String, Integer> entry : ipCountMap.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                System.out.println(String.format("|%18s  |%5d  |",key,value));
            }
            System.out.println("+--------------------+-------+");
        }else if(ipProperties.getModel().equals(IpProperties.LogModel.SIMPLE.getValue())){
            System.out.println("     IP访问监控");
            System.out.println("+-----ip-address-----+");
            for (String key: ipCountMap.keySet()) {
                System.out.println(String.format("|%18s  |",key));
            }
            System.out.println("+--------------------+");
        }

        if(ipProperties.getCycleReset()){
            ipCountMap.clear();
        }
    }


    public static void main(String[] args) {
        new IpCountService().print();
    }

}
