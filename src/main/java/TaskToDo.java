public class TaskToDo extends Task {

    public TaskToDo (String taskDescription){
        super(taskDescription);
        this.isDone = false;
        this.typeOfTask = TaskType.TODOS;
    }
}
