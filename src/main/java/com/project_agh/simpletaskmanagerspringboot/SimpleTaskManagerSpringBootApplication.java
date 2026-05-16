package com.project_agh.simpletaskmanagerspringboot;

import com.project_agh.simpletaskmanagerspringboot.event.SaveTaskEvent;
import com.project_agh.simpletaskmanagerspringboot.service.TaskService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class SimpleTaskManagerSpringBootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SimpleTaskManagerSpringBootApplication.class, args);

        TaskService taskService = context.getBean(TaskService.class);
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("\n1. Add task | 2. Complete task | 3. List tasks | 4. Save tasks | 5. Exit");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch(option){
                case 1: {
                    System.out.println("Enter task description:");
                    String desc = scanner.nextLine();
                    taskService.addTask(desc);
                    break;
                }
                case 2: {
                    System.out.println("Enter task ID to complete:");
                    String id = scanner.nextLine();
                    taskService.completeTask(id);
                    break;
                }
                case 3: {
                    System.out.println("All tasks:");
                    taskService.getAllTasks();
                    break;
                }
                case 4: {
                    System.out.println("Save tasks:");
                    context.publishEvent(new SaveTaskEvent(SimpleTaskManagerSpringBootApplication.class));
                    break;
                }
                case 5: {
                    context.close();
                    return;
                }
                default: {
                    System.out.println("Invalid option. Try again");
                }
            }
        }
    }
}