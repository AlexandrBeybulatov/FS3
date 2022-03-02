import manager.Managers;
import manager.TaskManager;
import tasks.Epic;
import tasks.Status;
import tasks.SubTask;
import tasks.Task;

public class Main {

    public static void main(String[] args) {


        TaskManager taskManager = Managers.getDefault(Managers.getDefaultHistory());

        Epic epic = new Epic("Сходить в магазин", "Купить продукты");
        SubTask subTask = new SubTask("Купить яйца", "Купить 10шт куриных яиц", epic);
        SubTask subTask1 = new SubTask("Купить молоко", "Купить 2л молока", epic);
        SubTask subTask2 = new SubTask("Купить печенье", "Купить шоколадное печенье", epic);
        taskManager.saveEpic(epic);
        taskManager.saveSubTask(subTask);
        taskManager.saveSubTask(subTask1);
        taskManager.saveSubTask(subTask2);

        Epic epic1 = new Epic("Заняться спортом", "Найти каким видом спорта заниматься");
        taskManager.saveEpic(epic1);

        taskManager.showAllTask();
        taskManager.changeStatus(subTask, Status.DONE);
        taskManager.changeStatus(subTask1, Status.DONE);
        taskManager.changeStatus(subTask, Status.IN_PROGRESS);

        System.out.println("_______________________");
        taskManager.getEpic(epic);
        taskManager.getEpic(epic1);
        taskManager.getSubTask(subTask);
        taskManager.getSubTask(subTask1);
        taskManager.getSubTask(subTask2);
        taskManager.getSubTask(subTask);
        for (Task task : taskManager.history()) {
            System.out.println(task);
        }
        System.out.println("_________________________________");
        taskManager.getSubTask(subTask1);
        taskManager.getEpic(epic);
        for (Task task : taskManager.history()) {
            System.out.println(task);
        }
        System.out.println("_________________________________");

        taskManager.removeByID(1);
        for (Task task : taskManager.history()) {
            System.out.println(task);
        }
    }
}
