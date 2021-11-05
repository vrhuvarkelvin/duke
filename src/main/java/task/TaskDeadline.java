package task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TaskDeadline extends Task {
    private final String DATE_FORMAT = "yyyy-MM-dd";
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
        this.isDone = isDone;
    }
    public LocalDateTime getDateTime(){
        return deadline;
    }

    public String getTaskDescription(){
        return taskDescription;
    }

    public String getDeadlineDate(){
        return deadline.format(DateTimeFormatter.ofPattern(DATE_FORMAT));
    }

    public String getDeadlinePrint(){
        return deadline.format(DateTimeFormatter.ofPattern(PRINT_FORMAT));
    }

    public String getDeadlineSave(){
        return deadline.format(DateTimeFormatter.ofPattern(SAVE_FORMAT));
    }

    public String getTaskType(){
        return "D";
    }
    public String getSave(){
        String save = getTaskType() + " | " + getDone() + " | " + getTaskDescription() + " | " + getDeadlineSave();
        return save;
    }

    public void setDeadline(LocalDateTime deadline){
        this.deadline = deadline;
    }

    public void setDone(){
        this.isDone = true;
        System.out.println("\tNice! I've marked this task as done:\n" +
                "\t  [D][X] " + getTaskDescription() + "(by: " + getDeadlinePrint() + ")");
    }

    public void print(){
        if (isDone) {
            System.out.println("\t  [D][X] " + getTaskDescription() + "(by: " + getDeadlinePrint() + ")");
        }
        else {
            System.out.println("\t  [D][ ] " + getTaskDescription() + "(by: " + getDeadlinePrint() + ")");
        }
    }
    @Override
    public String toString() {
        String frontTxt = "[D][ ] ";
        if (isDone){
            frontTxt = "[D][X] ";
        }
        return (frontTxt + getTaskDescription() + "(at: " + getDeadlinePrint() + ")");
    }
}
