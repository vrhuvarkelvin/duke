public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getTask(){
        return description;
    }

    public Boolean getStatus() {
        return isDone;
    }

    public void setTask(String newTaskDetails){
        description = newTaskDetails;
    }

    public void setTaskDone(){
        isDone = true;
    }

}
