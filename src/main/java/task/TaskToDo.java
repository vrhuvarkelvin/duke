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
        return "T";
    }

    public String getSave(){
        String save = getTaskType() + " | " + getDone() + " | " + getTaskDescription();
        return save;
    }

    public void setDone(){
        this.isDone = true;
        System.out.println("\tNice! I've marked this task as done:\n" + "\t  [T][X] " + getTaskDescription());
    }

    public void print(){
        if (isDone) {
            System.out.println("\t  [T][X] " + getTaskDescription());
        }
        else {
            System.out.println("\t  [T][ ] " + getTaskDescription());
        }
    }

    @Override
    public String toString() {
        String frontTxt = "[T][ ] ";
        if (isDone){
            frontTxt = "[T][X] ";
        }
        return (frontTxt + getTaskDescription());
    }

}
