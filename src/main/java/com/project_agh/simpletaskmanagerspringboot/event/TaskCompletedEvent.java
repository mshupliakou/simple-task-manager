package com.project_agh.simpletaskmanagerspringboot.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

public class TaskCompletedEvent extends ApplicationEvent {

    @Getter
    private final String taskId;
    private final boolean completed;

    public TaskCompletedEvent(Object source, String taskId, Boolean completed) {
        super(source);
        this.taskId = taskId;
        this.completed = completed;
    }

    boolean isTaskCompleted(){
        return this.completed;
    }


}
