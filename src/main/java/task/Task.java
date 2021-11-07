package task;

import java.time.LocalDateTime;

public abstract class Task {
    protected String taskDescription;
    protected boolean isDone;
    protected TaskType typeOfTask;

    public Task(String description) {
        this.taskDescription = description;
    }

    public String getTask(){
        return taskDescription;
    }

    public void setTask(String newTaskDetails){
        taskDescription = newTaskDetails;
    }

    public abstract void print();
    public abstract void setTaskDone();
    public abstract void setTaskUndone();
    public abstract String getTaskDescription();
    public abstract String getSave();
    public abstract String getTaskType();

    public LocalDateTime getDateTime(){
        return null;
    }

    public String getDone(){
        if(isDone){
            return "1";
        } else {
            return "0";
        }
    }

}
