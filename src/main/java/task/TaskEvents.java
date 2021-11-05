package task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TaskEvents extends Task{
    private final String DATE_FORMAT = "yyyy-MM-dd";
    private final String PRINT_FORMAT = "MMM d yyyy HH:mm a";
    private final String SAVE_FORMAT = "yyyy-MM-dd HHmm";
    private LocalDateTime timePeriod;

    public TaskEvents(String taskDescription, LocalDateTime timePeriod){
        super(taskDescription);
        this.isDone = false;
        this.typeOfTask = TaskType.EVENT;
        this.timePeriod = timePeriod;
    }

    public TaskEvents(String taskDescription, LocalDateTime timePeriod, Boolean isDone){
        super(taskDescription);
        setTimePeriod(timePeriod);
        this.isDone = isDone;
    }

    public LocalDateTime getDateTime(){
        return timePeriod;
    }

    public String getTaskDescription(){
        return taskDescription;
    }

    public String getTimePeriodDate(){
        return timePeriod.format(DateTimeFormatter.ofPattern(DATE_FORMAT));
    }
    public String getTimePeriodPrint(){
        return timePeriod.format(DateTimeFormatter.ofPattern(PRINT_FORMAT));
    }

    public String getTimePeriodSave(){
        return timePeriod.format(DateTimeFormatter.ofPattern(SAVE_FORMAT));
    }

    public String getTaskType(){
        return "E";
    }

    public String getSave(){
        String save = getTaskType() + " | " +  getDone() + " | " + getTaskDescription() + " | " + getTimePeriodSave();
        return save;
    }

    public void setDone(){
        this.isDone = true;
        System.out.println("\tNice! I've marked this task as done:\n" +
                "\t  [E][X] " + getTaskDescription() + "(at: " + getTimePeriodPrint() + ")");
    }

    public void setTimePeriod(LocalDateTime timePeriod){
        this.timePeriod = timePeriod;
    }

    public void print(){
        if (isDone) {
            System.out.println("\t  [E][X] " + getTaskDescription() + "(at: " + getTimePeriodPrint() + ")");
        }
        else {
            System.out.println("\t  [E][ ] " + getTaskDescription() + "(at: " + getTimePeriodPrint() + ")");
        }
    }

    @Override
    public String toString() {
        String frontTxt = "[E][ ] ";
        if (isDone){
            frontTxt = "[E][X] ";
        }
        return (frontTxt + getTaskDescription() + "(at: " + getTimePeriodPrint() + ")");
    }

}
