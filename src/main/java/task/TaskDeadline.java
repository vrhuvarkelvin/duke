package task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TaskDeadline extends Task {
    private final String PRINT_FORMAT = "MMM d yyyy HH:mm a";
    private final String SAVE_FORMAT = "yyyy-MM-dd HHmm";
    protected LocalDateTime deadline;

    /**
     * Constructor for TaskDeadline object
     *
     * @param taskDescription Task description of deadline object
     * @param deadline deadline of task in Date & Time format
     */
    public TaskDeadline(String taskDescription, LocalDateTime deadline){
        super(taskDescription);
        this.isDone = false;
        this.typeOfTask = TaskType.DEADLINE;
        this.deadline = deadline;
    }

    /**
     * Constructor for TaskDeadline object (activates when you load tasks from text file)
     *
     * @param taskDescription task description
     * @param deadline deadline of task in Date & Time format
     * @param isDone Done status of object
     */
    public TaskDeadline(String taskDescription, LocalDateTime deadline, Boolean isDone){
        super(taskDescription);
        setDeadline(deadline);
        setTaskType();
        this.isDone = isDone;
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
     * To print deadline of task
     *
     * @return deadline of task in String
     */
    public String getDeadlinePrint(){
        return deadline.format(DateTimeFormatter.ofPattern(PRINT_FORMAT));
    }

    /**
     * To print deadline of task to be saved in text file format
     *
     * @return deadline of task in String
     */
    public String getDeadlineSave(){
        return deadline.format(DateTimeFormatter.ofPattern(SAVE_FORMAT));
    }

    /**
     * To get task type
     *
     * @return task type in String (e.g. "D")
     */
    public String getTaskType(){
        return TaskType.toStringTaskType(typeOfTask);
    }

    /**
     * To get task info to be saved in text file format
     *
     * @return task info in String
     */
    public String getSave(){
        String save = getTaskType() + " | " + getDone() + " | " + getTaskDescription() + " | " + getDeadlineSave();
        return save;
    }

    /**
     * To get deadline of task
     *
     * @return deadline of task in LocalDateTime
     */
    @Override
    public LocalDateTime getDateTime() {
        return deadline;
    }

    /**
     * Initiates deadline of task
     *
     * @param deadline deadline of task in LocalDateTime
     */
    public void setDeadline(LocalDateTime deadline){
        this.deadline = deadline;
    }

    /**
     * Initiates task type of task
     */
    public void setTaskType(){
        this.typeOfTask = TaskType.DEADLINE;
    }

    /**
     * To mark task as done
     */
    public void setTaskDone(){
        this.isDone = true;
        System.out.println("\tNice! I've marked this task as done:\n" +
                "\t  [" + getTaskType() + "][X] " + getTaskDescription() + "(by: " + getDeadlinePrint() + ")");
    }

    /**
     * To mark task as not done
     */
    public void setTaskUndone(){
        this.isDone = false;
        System.out.println("\tOkay! I've marked this task as not done:\n" +
                "\t  [" + getTaskType() + "][ ] " + getTaskDescription() + "(by: " + getDeadlinePrint() + ")");
    }

    /**
     * To print task info
     */
    public void print(){
        if (isDone) {
            System.out.println("\t  [" + getTaskType() + "][X] " + getTaskDescription() + "(by: " + getDeadlinePrint() + ")");
        }
        else {
            System.out.println("\t  [" + getTaskType() + "][ ] " + getTaskDescription() + "(by: " + getDeadlinePrint() + ")");
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
        return (frontTxt + getTaskDescription() + "(by: " + getDeadlinePrint() + ")");
    }
}
