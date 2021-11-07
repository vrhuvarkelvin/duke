package task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TaskDeadline extends Task {
    private final String PRINT_FORMAT = "MMM d yyyy HH:mm a";
    private final String SAVE_FORMAT = "yyyy-MM-dd HHmm";
    private LocalDateTime deadline;

    public TaskDeadline(String TaskDescription, LocalDateTime deadline){
        super(TaskDescription);
        this.isDone = false;
        this.typeOfTask = TaskType.DEADLINE;
        this.deadline = deadline;
    }

    public TaskDeadline(String taskDescription, LocalDateTime deadline, Boolean isDone){
        super(taskDescription);
        setDeadline(deadline);
        setTaskType();
        this.isDone = isDone;
    }

    public String getTaskDescription(){
        return taskDescription;
    }

    public String getDeadlinePrint(){
        return deadline.format(DateTimeFormatter.ofPattern(PRINT_FORMAT));
    }

    public String getDeadlineSave(){
        return deadline.format(DateTimeFormatter.ofPattern(SAVE_FORMAT));
    }

    public String getTaskType(){
        return TaskType.toStringTaskType(typeOfTask);
    }

    public String getSave(){
        String save = getTaskType() + " | " + getDone() + " | " + getTaskDescription() + " | " + getDeadlineSave();
        return save;
    }

    @Override
    public LocalDateTime getDateTime() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline){
        this.deadline = deadline;
    }

    public void setTaskType(){
        this.typeOfTask = TaskType.DEADLINE;
    }

    public void setTaskDone(){
        this.isDone = true;
        System.out.println("\tNice! I've marked this task as done:\n" +
                "\t  [" + getTaskType() + "][X] " + getTaskDescription() + "(by: " + getDeadlinePrint() + ")");
    }

    public void setTaskUndone(){
        this.isDone = false;
        System.out.println("\tOkay! I've marked this task as not done:\n" +
                "\t  [" + getTaskType() + "][ ] " + getTaskDescription() + "(by: " + getDeadlinePrint() + ")");
    }

    public void print(){
        if (isDone) {
            System.out.println("\t  [" + getTaskType() + "][X] " + getTaskDescription() + "(by: " + getDeadlinePrint() + ")");
        }
        else {
            System.out.println("\t  [" + getTaskType() + "][ ] " + getTaskDescription() + "(by: " + getDeadlinePrint() + ")");
        }
    }
    @Override
    public String toString() {
        String frontTxt = "[" + getTaskType() + "][ ] ";
        if (isDone){
            frontTxt = "[" + getTaskType() + "][X] ";
        }
        return (frontTxt + getTaskDescription() + "(by: " + getDeadlinePrint() + ")");
    }
}
