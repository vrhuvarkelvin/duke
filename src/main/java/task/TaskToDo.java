package task;

public class TaskToDo extends Task {

    public TaskToDo (String taskDescription){
        super(taskDescription);
        this.isDone = false;
        this.typeOfTask = TaskType.TODOS;
    }

    public TaskToDo (String taskDescription, Boolean isDone){
        super(taskDescription);
        this.isDone = isDone;
        this.typeOfTask = TaskType.TODOS;
    }

    public String getTaskDescription(){
        return taskDescription;
    }

    public String getTaskType(){
        return TaskType.toStringTaskType(typeOfTask);
    }

    public String getSave(){
        String save = getTaskType() + " | " + getDone() + " | " + getTaskDescription();
        return save;
    }

    public void setTaskDone(){
        this.isDone = true;
        System.out.println("\tNice! I've marked this task as done:\n" + "\t  [" + getTaskType() + "][X] " + getTaskDescription());
    }

    public void setTaskUndone(){
        this.isDone = false;
        System.out.println("\tOkay! I've marked this task as not done:\n" + "\t  [" + getTaskType() + "][ ] " + getTaskDescription());
    }

    public void print(){
        if (isDone) {
            System.out.println("\t  [" + getTaskType() + "][X] " + getTaskDescription());
        }
        else {
            System.out.println("\t  [" + getTaskType() + "][ ] " + getTaskDescription());
        }
    }

    @Override
    public String toString() {
        String frontTxt = "[" + getTaskType() + "][ ] ";
        if (isDone){
            frontTxt = "[" + getTaskType() + "][X] ";
        }
        return (frontTxt + getTaskDescription());
    }

}
