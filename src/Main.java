import manager.InMemoryTaskManager;
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
        taskManager.saveEpic(epic);
        taskManager.saveSubTask(subTask);
        taskManager.saveSubTask(subTask1);

        Epic epic1 = new Epic("Заняться спортом", "Найти каким видом спорта заниматься");
        SubTask subTask2 = new SubTask("Найти фитнес клуб", "Промониторить фитнесс клубы твоего города", epic1);
        taskManager.saveEpic(epic1);
        taskManager.saveSubTask(subTask2);

        taskManager.showAllTask();

        System.out.println("____________________");
        taskManager.changeStatus(subTask, Status.DONE);
        taskManager.changeStatus(subTask1, Status.DONE);
        taskManager.showAllTask();

        System.out.println("____________________");
        taskManager.changeStatus(subTask, Status.IN_PROGRESS);
        taskManager.showAllTask();


        System.out.println("_______________________");
        taskManager.removeByID(4);
        taskManager.getEpic(epic);
        taskManager.getEpic(epic1);
        taskManager.getSubTask(subTask);
        taskManager.getSubTask(subTask1);
        taskManager.getSubTask(subTask2);
        for (Task task : taskManager.history()) {
            System.out.println(task);
        }
    }
}