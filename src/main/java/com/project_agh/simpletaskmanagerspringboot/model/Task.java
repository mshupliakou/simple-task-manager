package com.project_agh.simpletaskmanagerspringboot.model;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;

@Data
public class Task implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String description;
    private Boolean completed = false;
}
