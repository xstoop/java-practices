package com.example.demo.listener;

import com.example.demo.event.AyUserQueryEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class LogUserCountListener implements ApplicationListener<AyUserQueryEvent> {
    @Override
    public void onApplicationEvent(AyUserQueryEvent ayUserQueryEvent) {
        System.out.println("log user count listener ------> has "+ ayUserQueryEvent.getUserCount() + " users");
    }
}
