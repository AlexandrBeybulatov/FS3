package manager;

import tasks.Epic;
import tasks.Status;
import tasks.SubTask;
import tasks.Task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTaskManager implements TaskManager {

    private final HistoryManager historyManager;
    private HashMap<Integer, Task> tasks = new HashMap<>();
    private HashMap<Integer, Epic> epics = new HashMap<>();
    private HashMap<Integer, SubTask> subtasks = new HashMap<>();


    public InMemoryTaskManager(HistoryManager historyManager) {
        this.historyManager = historyManager;
    }

    @Override
    public void saveTask(Task task) {
        tasks.put(task.getId(), task);
    }

    @Override
    public void saveEpic(Epic epic) {
        epics.put(epic.getId(), epic);
    }

    @Override
    public void saveSubTask(SubTask subTask) {
        subtasks.put(subTask.getId(), subTask);
        subTask.getEpic().getSubTasks().add(subTask);
    }

    @Override
    public void showAllTask() {
        for (Map.Entry entry : tasks.entrySet()
        ) {
            System.out.println(entry);
        }

        for (Map.Entry entry : epics.entrySet()
        ) {
            System.out.println(entry);
        }
    }

    @Override
    public void clearAllTasks() {
        tasks.clear();
        epics.clear();
        subtasks.clear();
    }

    @Override
    public void showTasksByID(int id) {
        System.out.println(tasks.get(id));
        System.out.println(epics.get(id));
    }

    @Override
    public void updateEpic(Epic epic, int id) {
        epics.put(id, epic);
    }

    @Override
    public void removeByID(int id) {
        tasks.remove(id);
        epics.remove(id);
        for (int i = 2; i < 5; i++) {
            historyManager.remove(i);
        }
        subtasks.remove(id);
        historyManager.remove(id);
    }

    @Override
    public void getAllSubTasksByEpic(Epic epic) {
        for (int i = 0; i < epic.getSubTasks().size(); i++) {
            System.out.println(epic.getSubTasks().get(i));
        }
    }

    @Override
    public void changeStatus(SubTask subTask, Status status) {
        subTask.setStatus(status);
        int countDone = 0;
        for (int i = 0; i < subTask.getEpic().getSubTasks().size(); i++) {

            if (subTask.getEpic().getSubTasks().get(i).getStatus().equals(Status.NEW)) {
                return;
            } else if (subTask.getEpic().getSubTasks().get(i).getStatus().equals(Status.IN_PROGRESS)) {
                epics.get(subTask.getEpic().getId()).setStatus(Status.IN_PROGRESS);
            } else if (subTask.getEpic().getSubTasks().get(i).getStatus().equals(Status.DONE)) {
                countDone++;
            }
        }
        if (countDone == subTask.getEpic().getSubTasks().size()) {
            epics.get(subTask.getEpic().getId()).setStatus(Status.DONE);
        }
    }

    @Override
    public List<Task> history() {
        return historyManager.getHistory();
    }

    @Override
    public Task getTask(Task task) {

        historyManager.add(task);
        return tasks.get(task.getId());
    }

    @Override
    public Task getEpic(Epic epic) {
        historyManager.add(epic);
        return epics.get(epic.getId());
    }

    @Override
    public Task getSubTask(SubTask subTask) {
        historyManager.add(subTask);
        return subtasks.get(subTask.getId());
    }

    public HashMap<Integer, Task> getTasks() {
        return tasks;
    }

    public void setTasks(HashMap<Integer, Task> tasks) {
        this.tasks = tasks;
    }

    public HashMap<Integer, Epic> getEpics() {
        return epics;
    }

    public void setEpics(HashMap<Integer, Epic> epics) {
        this.epics = epics;
    }

    public HashMap<Integer, SubTask> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(HashMap<Integer, SubTask> subtasks) {
        this.subtasks = subtasks;
    }
}
