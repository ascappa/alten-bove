package alten.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskScheduler {
    private final List<Task> tasks;

    public TaskScheduler(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Task> getTasksByDeadline(LocalDate date) {
        List<Task> filteredTasks = new ArrayList<>();
        for (Task task : tasks) {
            LocalDate currentTaskDeadline = task.getDeadline();
            if (currentTaskDeadline.isEqual(date)) {
                filteredTasks.add(task);
            }
        }
        return filteredTasks;
    }
    public void addTask(Task task) {
        tasks.add(task);
    }
}
