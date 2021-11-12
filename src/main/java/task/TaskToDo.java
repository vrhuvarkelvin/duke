package task;

public class TaskToDo extends Task {

    /**
     * Constructor for TaskToDo object
     *
     * @param taskDescription Task description of todo object
     */
    public TaskToDo (String taskDescription){
        super(taskDescription);
        this.isDone = false;
        this.typeOfTask = TaskType.TODOS;
    }

    /**
     * Constructor for TaskToDo object (activates when you load tasks from text file)
     *
     * @param taskDescription task description
     * @param isDone Done status of object
     */
    public TaskToDo (String taskDescription, Boolean isDone){
        super(taskDescription);
        this.isDone = isDone;
        this.typeOfTask = TaskType.TODOS;
    }

    /**
     * To get task description
     *
     * @return task description in String
     */
    public String getTaskDescription(){
        return taskDescription;
    }

    /**
     * To get task type
     *
     * @return task type in String (e.g. "T")
     */
    public String getTaskType(){
        return TaskType.toStringTaskType(typeOfTask);
    }

    /**
     * To get task info to be saved in text file format
     *
     * @return task info to be saved into text file
     */
    public String getSave(){
        String save = getTaskType() + " | " + getDone() + " | " + getTaskDescription();
        return save;
    }

    /**
     * To mark task as done
     */
    public void setTaskDone(){
        this.isDone = true;
        System.out.println("\tNice! I've marked this task as done:\n" + "\t  [" + getTaskType() + "][X] " + getTaskDescription());
    }

    /**
     * To mark task as not done
     */
    public void setTaskUndone(){
        this.isDone = false;
        System.out.println("\tOkay! I've marked this task as not done:\n" + "\t  [" + getTaskType() + "][ ] " + getTaskDescription());
    }

    /**
     * To print task info
     */
    public void print(){
        if (isDone) {
            System.out.println("\t  [" + getTaskType() + "][X] " + getTaskDescription());
        }
        else {
            System.out.println("\t  [" + getTaskType() + "][ ] " + getTaskDescription());
        }
    }

    /**
     * To print task info
     *
     * @return task info in String
     */
    @Override
    public String toString() {
        String frontTxt = "[" + getTaskType() + "][ ] ";
        if (isDone){
            frontTxt = "[" + getTaskType() + "][X] ";
        }
        return (frontTxt + getTaskDescription());
    }

}
