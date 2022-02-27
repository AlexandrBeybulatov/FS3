package manager;

import tasks.Epic;
import tasks.Status;
import tasks.SubTask;
import tasks.Task;

import java.util.List;

public interface TaskManager {

    void saveTask(Task task);

    void saveEpic(Epic epic);

    void saveSubTask(SubTask subTask);

    List<Task> history();

    void showAllTask();

    void clearAllTasks();

    void showTasksByID(int id);

    void updateEpic(Epic epic, int id);

    void removeByID(int id);

    void getAllSubTasksByEpic(Epic epic);

    void changeStatus(SubTask subTask, Status status);

    Task getTask(Task task);

    Task getEpic(Epic epic);

    Task getSubTask(SubTask subTask);
}
