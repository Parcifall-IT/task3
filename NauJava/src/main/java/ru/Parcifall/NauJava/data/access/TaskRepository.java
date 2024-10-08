package ru.Parcifall.NauJava.data.access;

import ru.Parcifall.NauJava.Entitys.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class TaskRepository implements CrudRepository<Task, Long> {
    private final HashMap<Long, Task> taskContainer;

    @Autowired
    public TaskRepository(HashMap<Long, Task> taskContainer) {
        this.taskContainer = taskContainer;
    }
    @Override
    public void create(Task task) {
        taskContainer.put(task.getId(), task);
        System.out.println("Task id=" + task.getId() + " added");
    }

    @Override
    public Task read(Long id) {
        System.out.println(taskContainer.get(id));
        return taskContainer.get(id);
    }

    @Override
    public void update(Task task) {
        if (!taskContainer.containsKey(task.getId())) {
            System.out.println("Incorrect task id");
            return;
        }
        delete(task.getId());
        create(task);
        System.out.println("Task id=" + task.getId() + " updated");
    }

    @Override
    public void delete(Long id) {
        if (!taskContainer.containsKey(id)) {
            System.out.println("Incorrect task id");
            return;
        }
        taskContainer.remove(id);
        System.out.println("Task id=" + id + " deleted");
    }
}

