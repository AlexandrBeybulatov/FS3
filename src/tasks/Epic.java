package tasks;

import java.util.ArrayList;

public class Epic extends Task {
    private ArrayList<SubTask> subTasks = new ArrayList<>();

    public Epic(String name, String description) {
        super(name, description);

    }

    public ArrayList<SubTask> getSubTasks() {

        return subTasks;
    }

    public void setSubTasks(ArrayList<SubTask> subTasks) {
        this.subTasks = subTasks;
    }

    @Override
    public String toString() {
        return "tasks.Epic{" + "name=" + super.getName() + ", " + " description=" + super.getDescription() +
                ", " +
                ", id=" + super.getId() +
                ", status=" + super.getStatus() +
                "} SubTasks=" + subTasks
                ;
    }
}
