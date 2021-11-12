package task;

import java.time.LocalDateTime;

public abstract class Task {
    protected String taskDescription;
    protected boolean isDone;
    protected TaskType typeOfTask;

    /**
     * Constructor of Task object
     *
     * @param description task description
     */
    public Task(String description) {
        this.taskDescription = description;
    }

    /**
     * To get the task description
     *
     * @return task description in String
     */
    public String getTask(){
        return taskDescription;
    }

    public abstract void print();
    public abstract void setTaskDone();
    public abstract void setTaskUndone();
    public abstract String getTaskDescription();
    public abstract String getSave();
    public abstract String getTaskType();

    /**
     * To get the date time of task object except todo task return null
     *
     * @return date/time of TaskDeadline/TaskEvents
     */
    public LocalDateTime getDateTime(){
        return null;
    }

    /**
     * To get task status (Done/Not done)
     *
     * @return  Task status in String (1 / 0)
     */
    public String getDone(){
        if(isDone){
            return "1";
        } else {
            return "0";
        }
    }

}
