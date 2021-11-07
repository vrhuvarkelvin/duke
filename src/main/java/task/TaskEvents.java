package task;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TaskEvents extends Task{
    private final String START_TIME_PRINT_FORMAT = "MMM d yyyy HH:mm a";
    private final String END_TIME_PRINT_FORMAT = "HH:mm a";
    private final String START_TIME_SAVE_FORMAT = "yyyy-MM-dd HHmm";
    private final String END_TIME_SAVE_FORMAT = "HHmm";
    private LocalDateTime startTime;
    private LocalTime endTime;

    public TaskEvents(String taskDescription, LocalDateTime startTime, LocalTime endTime){
        super(taskDescription);
        setTaskType();
        setStartTime(startTime);
        setEndTime(endTime);
        this.isDone = isDone;
    }

    public TaskEvents(String taskDescription, LocalDateTime startTime, LocalTime endTime, Boolean isDone){
        super(taskDescription);
        setStartTime(startTime);
        setEndTime(endTime);
        setTaskType();
        this.isDone = isDone;
    }

    public String getTaskDescription(){
        return taskDescription;
    }

    public String getTimePeriodPrint(){
        return (startTime.format(DateTimeFormatter.ofPattern(START_TIME_PRINT_FORMAT)) + "~" +
                endTime.format(DateTimeFormatter.ofPattern(END_TIME_PRINT_FORMAT)));
    }

    public String getTimePeriodSave(){
        return (startTime.format(DateTimeFormatter.ofPattern(START_TIME_SAVE_FORMAT)) + "~" +
                endTime.format(DateTimeFormatter.ofPattern(END_TIME_SAVE_FORMAT)));
    }

    public String getTaskType(){
        return TaskType.toStringTaskType(typeOfTask);
    }

    @Override
    public LocalDateTime getDateTime() {
        return startTime;
    }

    public String getSave(){
        String save = getTaskType() + " | " +  getDone() + " | " + getTaskDescription() + " | " + getTimePeriodSave();
        return save;
    }

    public void setTaskDone(){
        this.isDone = true;
        System.out.println("\tNice! I've marked this task as done:\n" +
                "\t  [" + getTaskType() + "][X] " + getTaskDescription() + "(at: " + getTimePeriodPrint() + ")");
    }

    public void setTaskUndone(){
        this.isDone = false;
        System.out.println("\tOkay! I've marked this task as not done:\n" +
                "\t  [" + getTaskType() + "][ ] " + getTaskDescription() + "(at: " + getTimePeriodPrint() + ")");
    }

    public void setStartTime(LocalDateTime startTime){
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime){
        this.endTime = endTime;
    }

    public void setTaskType(){
        this.typeOfTask = TaskType.EVENT;
    }

    public void print(){
        if (isDone) {
            System.out.println("\t  [" + getTaskType() + "][X] " + getTaskDescription() + "(at: " + getTimePeriodPrint() + ")");
        }
        else {
            System.out.println("\t  [" + getTaskType() + "][ ] " + getTaskDescription() + "(at: " + getTimePeriodPrint() + ")");
        }
    }

    @Override
    public String toString() {
        String frontTxt = "[" + getTaskType() + "][ ] ";
        if (isDone){
            frontTxt = "[" + getTaskType() + "][X] ";
        }
        return (frontTxt + getTaskDescription() + "(at: " + getTimePeriodPrint() + ")");
    }
}
