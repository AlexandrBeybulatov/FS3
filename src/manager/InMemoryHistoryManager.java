package manager;

import tasks.Task;

import java.util.*;

public class InMemoryHistoryManager implements HistoryManager {

    private HashMap<Integer, Node<Task>> historyTask = new HashMap<>();
    private Node<Task> head;
    private Node<Task> tail;

    @Override
    public void add(Task task) {
        if (task == null) {
            return;
        }
        if (historyTask.containsKey(task.getId())) {
            remove(task.getId());
        }
        historyTask.put(task.getId(), linkLast(task));
    }


    @Override
    public List<Task> getHistory() {
        return getTasks();
    }

    @Override
    public void remove(int id) {
        removeNode(historyTask.get(id));
        historyTask.remove(id);
    }

    private List<Task> getTasks() {
        List<Task> tasksList = new ArrayList<>(20);
        Node<Task> node = head;
        while (node != null) {
            tasksList.add(node.task);
            node = node.next;
        }
        return tasksList;
    }


    static class Node<Task> {

        private Task task;
        private Node<Task> next;
        private Node<Task> prev;

        public Node(Task task, Node<Task> prev, Node<Task> next) {
            this.task = task;
            this.next = next;
            this.prev = prev;

        }
    }

    private Node<Task> linkLast(Task task) {
        final Node<Task> lastNode = tail;
        final Node<Task> newNode = new Node<>(task, lastNode, null);
        tail = newNode;
        if (lastNode == null) {
            head = newNode;
        } else {
            lastNode.next = newNode;
        }
        return newNode;
    }

    private void removeNode(Node<Task> node) {
        if (node != null) {
            final Node<Task> next = node.next;
            final Node<Task> prev = node.prev;
            if (prev == null) {
                head = next;
            } else {
                prev.next = next;
                node.prev = null;
            }
            if (next == null) {
                tail = prev;
            } else {
                next.prev = prev;
                node.next = null;
            }
            node.task = null;
        }
    }

    public HashMap<Integer, Node<Task>> getHistoryTask() {
        return historyTask;
    }

    public void setHistoryTask(HashMap<Integer, Node<Task>> historyTask) {
        this.historyTask = historyTask;
    }

    public Node<Task> getHead() {
        return head;
    }

    public void setHead(Node<Task> head) {
        this.head = head;
    }

    public Node<Task> getTail() {
        return tail;
    }

    public void setTail(Node<Task> tail) {
        this.tail = tail;
    }
}
