public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        //create Users
        User user1 = new User(1, "surbhi", "xyz@gmail.com");
        User user2 = new User(2, "subrat", "pqr@gmail.com");

        //create Task
        Task task1 = new Task(1, "Morining Tasks", "Eat breakfast", "not done/");
        Task task2 = new Task(2, "Meeting", "Today is meeting at 3pm", "completed");

        // add task to users
        taskManager.addTask(user1.getId(), task1);
        taskManager.addTask(user2.getId(), task2);

        for(Task task : taskManager.getTasksByUser(user1.getId())) {
            System.out.println(" - " + task.getTaskTitle() + " (" + task.getStatus() + ")");
        }

        // mark a task as completed
        taskManager.markTaskAsCompleted(user1.getId(), 1);

        for(Task task : taskManager.getTasksByUser(user1.getId())) {
            System.out.println(" - " + task.getTaskTitle() + " (" + task.getStatus() + ")");
        }
    }
}
