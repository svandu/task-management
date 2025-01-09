import java.util.*;

public class TaskManager {
    private final Map<Integer, List<Task>> userTasks;
    
    public TaskManager() {
        this.userTasks = new HashMap<>();   
    }

    public void addTask(int userId, Task task) {
        userTasks.putIfAbsent(userId, new ArrayList<>());
        userTasks.get(userId).add(task);
    }

    public void removeTask(int userId, int taskId) {
        if(userTasks.containsKey(userId)) {
            userTasks.get(userId).removeIf(task -> task.getId() == taskId);
        }
    }

    public List<Task> getTasksByUser(int userId) {
        return userTasks.getOrDefault(userId, new ArrayList<>());
    }

    public Task getTaskById(int userId, int taskId) {
        return userTasks.getOrDefault(userId, new ArrayList<>())
                .stream()
                .filter(task -> task.getId() == taskId)
                .findFirst()
                .orElse(null);
    }

    public void markTaskAsCompleted(int userId, int taskId) {
        Task task = getTaskById(userId, taskId);
        if(task != null) {
            task.setStatus("completed");
        }
    }
}