package com.project_agh.simpletaskmanagerspringboot;

import com.project_agh.simpletaskmanagerspringboot.service.TaskService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("load")
public class TaskLoader {

    @Value("${app.task-file-path}")
    private String filepath;

    private final TaskService taskService;

    public TaskLoader(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostConstruct
    public void loadTasks() {
        System.out.println("Loading Tasks");
        taskService.loadTasks(filepath);
    }
}
