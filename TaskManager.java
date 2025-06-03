import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addTask();
                    break;
                case "2":
                    viewTasks();
                    break;
                case "3":
                    markTaskComplete();
                    break;
                case "4":
                    deleteTask();
                    break;
                case "5":
                    System.out.println("Exiting Task Manager.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n=== TASK MANAGER ===");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Mark Task Completed");
        System.out.println("4. Delete Task");
        System.out.println("5. Exit");
        System.out.print("Enter choice: ");
    }

    private static void addTask() {
        System.out.print("Enter task name: ");
        String name = scanner.nextLine();
        System.out.print("Enter due date: ");
        String dueDate = scanner.nextLine();
        tasks.add(new Task(name, dueDate));
        System.out.println("Task added.");
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to show.");
            return;
        }
        System.out.println("\n--- Current Tasks ---");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    private static void markTaskComplete() {
        viewTasks();
        System.out.print("Enter task number to mark complete: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markCompleted();
            System.out.println("Task marked as complete.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private static void deleteTask() {
        viewTasks();
        System.out.print("Enter task number to delete: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task deleted.");
        } else {
            System.out.println("Invalid task number.");
        }
    }
}
