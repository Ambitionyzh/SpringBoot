package com.example.Listener;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author yongzh
 * @version 1.0
 * @description:  //想要干预哪个事件就传参对应的事件,ApplicationEvent,ApplicationStartingEvent
 * @date 2023/12/24 10:25
 */
public class MyListener implements ApplicationListener<ApplicationStartingEvent> {
    //在SpringBoot启动的过程中的各种事件
    //想要干预哪个事件就传参对应的事件,ApplicationEvent,ApplicationStartingEvent等等

    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {

    }


}
