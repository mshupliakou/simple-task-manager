package com.project_agh.simpletaskmanagerspringboot.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TaskEventCompletedListener {
    @EventListener(TaskCompletedEvent.class)
    public void onTaskCompletedEvent(TaskCompletedEvent event){
        if(event.isTaskCompleted()){
            System.out.println("Task is completed ID:" + event.getTaskId());
        }
        else{
            System.out.println("Task is not completed ID:" + event.getTaskId());
        }
    }
}
