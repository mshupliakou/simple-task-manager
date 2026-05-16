package com.project_agh.simpletaskmanagerspringboot.event;

import com.project_agh.simpletaskmanagerspringboot.service.TaskService;
import lombok.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SaveTasksEventListener {
    @Value("${app.task-file-path}")
    private String filepath;

    private final TaskService taskService;

    public SaveTasksEventListener(TaskService taskService) {
        this.taskService = taskService;
    }

    @EventListener(SaveTaskEvent.class)
    public void onEvent(ContextRefreshedEvent event) {
        System.out.println("Save tasks...");
    }
}
