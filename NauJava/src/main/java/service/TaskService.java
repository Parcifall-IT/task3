package service;

import Entitys.Status;
import Entitys.Task;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public interface TaskService {
    void createTask(Long id, String name, String description, Calendar deadline, Status status);

    Task findById(Long id);

    void deleteById(Long id);

    void updateStatus(Long id, Status status);

    void updateDeadline(Long id, Calendar deadline);
}
