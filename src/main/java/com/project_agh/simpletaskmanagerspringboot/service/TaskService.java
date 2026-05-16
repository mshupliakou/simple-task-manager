package com.project_agh.simpletaskmanagerspringboot.service;

import com.project_agh.simpletaskmanagerspringboot.event.TaskCompletedEvent;
import com.project_agh.simpletaskmanagerspringboot.model.Task;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    private final ApplicationEventPublisher applicationEventPublisher;

    private final List<Task> taskList = new ArrayList<>();

    public TaskService(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void addTask(String description){
        Task task = new Task();
        task.setDescription(description);
        task.setId((UUID.randomUUID().toString()));
        task.setCompleted(false);
        taskList.add(task);
    }

    public void completeTask(String taskId){
        var completedTask = taskList.stream().
                filter(task -> task.getId().equals(taskId)).findFirst();
        if(completedTask.isPresent()){
            completedTask.get().setCompleted(true);
        }
        applicationEventPublisher.publishEvent(new TaskCompletedEvent(
                this, taskId, completedTask.map(Task::getCompleted).orElse(false)
        ));
    }

    public void saveTask(String filepath){
        try(FileOutputStream fileOutputStream = new FileOutputStream(filepath)){
            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
            oos.writeObject(taskList);
            oos.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void loadTasks(String filepath){
        try(FileInputStream fileInputStream = new FileInputStream(filepath)){
            ObjectInputStream ois = new ObjectInputStream(fileInputStream);
            taskList.addAll((List<Task>) ois.readObject());
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

}
