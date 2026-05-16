package com.project_agh.simpletaskmanagerspringboot.event;

import org.springframework.context.ApplicationEvent;

public class SaveTaskEvent extends ApplicationEvent {
    public SaveTaskEvent(Object source) {
        super(source);
    }
}
