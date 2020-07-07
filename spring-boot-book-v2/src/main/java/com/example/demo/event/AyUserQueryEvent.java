package com.example.demo.event;

import org.springframework.context.ApplicationEvent;

public class AyUserQueryEvent extends ApplicationEvent {
    private final int userCount;

    public AyUserQueryEvent(Object source, int userCount) {
        super(source);
        this.userCount = userCount;
    }

    public int getUserCount() {
        return userCount;
    }
}
