package tasks;

import tasks.Epic;
import tasks.Task;

public class SubTask extends Task {
    private Epic epic;

    public SubTask(String name, String description, Epic epic) {
        super(name, description);

        this.epic = epic;
    }

    public Epic getEpic() {
        return epic;
    }

    public void setEpic(Epic epic) {
        this.epic = epic;
    }

    @Override
    public String toString() {
        return "tasks.SubTask{" +
                "name='" + super.getName() + '\'' +
                ", description='" + super.getDescription() + '\'' +
                ", id=" + super.getId() +
                ", status=" + super.getStatus() +
                '}';
    }
}
