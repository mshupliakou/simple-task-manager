package com.project_agh.simpletaskmanagerspringboot;

import com.project_agh.simpletaskmanagerspringboot.event.SaveTaskEvent;
import com.project_agh.simpletaskmanagerspringboot.service.TaskService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class SimpleTaskManagerSpringBootApplication {

    public static void main(String[] args) {
        new SimpleTaskManagerSpringBootApplication().start();
    }

    public void start(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TaskService taskService = context.getBean(TaskService.class);
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print("1. Add task");
            System.out.print("2. Complete task");
            System.out.print("3. List tasks");
            System.out.print("4. Save tasks");
            System.out.print("5. Exit");

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
                    context.publishEvent(new SaveTaskEvent(this));
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
