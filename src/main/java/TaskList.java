import com.sun.source.util.TaskEvent;

import java.util.ArrayList;

import java.util.*;
import java.sql.Time;
import java.util.Date;

public class TaskList {
    private ArrayList<Task> list;


    public TaskList() {
        list = new ArrayList<Task>();
    }

    public void addItemToDo(String taskDescription) {
        list.add(new TaskToDo(taskDescription));
    }

    public void addItemToDeadline(String taskDescription, String dateInString){
        list.add(new TaskDeadline(taskDescription,dateInString));
    }
    public void addItemToEvents(String taskDescription, String timePeriod){
        list.add(new TaskEvents(taskDescription,timePeriod));
    }

    public void removeItem(int index) {
        list.remove(index);
    }

    public Task getTask(int index) {
        return list.get(index);
    }

    public boolean getTaskStatus(int index){
        Task task = list.get(index);
        return task.getStatus();
    }

    public int getNumOfTotalItem() {
        return list.size();
    }

    public TaskType getTypeOfTask(int index){
        Task task = list.get(index);
        return task.getTypeOfTask();
    }

    public String getTaskDescription(int index){
        Task task = list.get(index);
        return task.getTask();
    }

    public String getTaskDeadlineInString(int index){
        TaskDeadline task = (TaskDeadline) list.get(index);
        return task.getDateInString();
    }

    public String getTaskEventTimePeriodInString(int index){
        TaskEvents task = (TaskEvents) list.get(index);
        return task.getTimePeriod();
    }

    public void setTaskDone(int index){
        Task task = list.get(index);
        task.setTaskDone();
    }
}
