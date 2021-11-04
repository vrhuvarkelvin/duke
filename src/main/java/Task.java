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

    public Boolean getStatus() {
        return isDone;
    }

    public TaskType getTypeOfTask() {
        return typeOfTask;
    }

    public void setTask(String newTaskDetails){
        taskDescription = newTaskDetails;
    }

    public void setTaskDone(){
        isDone = true;
    }

    public void setTypeOfTask(TaskType typeOfTask){
        this.typeOfTask = typeOfTask;
    }

}
