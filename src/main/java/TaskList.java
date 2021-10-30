import java.util.ArrayList;

import java.util.*;

public class TaskList {
    private ArrayList<Task> list;


    public TaskList() {
        list = new ArrayList<Task>();
    }

    public void addItem(String s) {
        list.add(new Task(s));
    }

    public void removeItem(int index) {
        list.remove(index);
    }

    public Task getTask(int index) {
        return list.get(index);
    }

    public String getTaskDetails(int index){
        Task task = list.get(index);
        return task.getTask();
    }

    public boolean getTaskStatus(int index){
        Task task = list.get(index);
        return task.getStatus();
    }

    public int getNumOfTotalItem() {
        return list.size();
    }

    public void setTaskDone(int index){
        Task task = list.get(index);
        task.setTaskDone();
    }
}
