package task;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TaskEvents extends Task{
    private final String START_TIME_PRINT_FORMAT = "MMM d yyyy HH:mm a";
    private final String END_TIME_PRINT_FORMAT = "HH:mm a";
    private final String START_TIME_SAVE_FORMAT = "yyyy-MM-dd HHmm";
    private final String END_TIME_SAVE_FORMAT = "HHmm";
    protected LocalDateTime startTime;
    protected LocalTime endTime;

    /**
     * Constructor for TaskEvents object
     *
     * @param taskDescription Task description of event object
     * @param startTime start date & time of event
     * @param endTime end time of event
     */
    public TaskEvents(String taskDescription, LocalDateTime startTime, LocalTime endTime){
        super(taskDescription);
        setTaskType();
        setStartTime(startTime);
        setEndTime(endTime);
        this.isDone = isDone;
    }

    /**
     * Constructor for TaskEvents object (activates when you load tasks from text file)
     *
     * @param taskDescription task description
     * @param isDone Done status of object
     * @param startTime start date & time of event
     * @param endTime end time of event
     */
    public TaskEvents(String taskDescription, LocalDateTime startTime, LocalTime endTime, Boolean isDone){
        super(taskDescription);
        setStartTime(startTime);
        setEndTime(endTime);
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
     * To print time period of event
     *
     * @return time period of event in String
     */
    public String getTimePeriodPrint(){
        return (startTime.format(DateTimeFormatter.ofPattern(START_TIME_PRINT_FORMAT)) + "~" +
                endTime.format(DateTimeFormatter.ofPattern(END_TIME_PRINT_FORMAT)));
    }

    /**
     * To get time period of event in Text file format
     *
     * @return time period of event in String
     */
    public String getTimePeriodSave(){
        return (startTime.format(DateTimeFormatter.ofPattern(START_TIME_SAVE_FORMAT)) + "~" +
                endTime.format(DateTimeFormatter.ofPattern(END_TIME_SAVE_FORMAT)));
    }

    /**
     * To get task type
     *
     * @return task type in String (e.g. "E")
     */
    public String getTaskType(){
        return TaskType.toStringTaskType(typeOfTask);
    }

    /**
     * To get start time of event
     *
     * @return  start time of event in LocalDateTime
     */
    @Override
    public LocalDateTime getDateTime() {
        return startTime;
    }

    /**
     * To get task info to be saved in text file format
     *
     * @return task info in String
     */
    public String getSave(){
        String save = getTaskType() + " | " +  getDone() + " | " + getTaskDescription() + " | " + getTimePeriodSave();
        return save;
    }

    /**
     * To mark task as done
     */
    public void setTaskDone(){
        this.isDone = true;
        System.out.println("\tNice! I've marked this task as done:\n" +
                "\t  [" + getTaskType() + "][X] " + getTaskDescription() + "(at: " + getTimePeriodPrint() + ")");
    }

    /**
     * To mark task as not done
     */
    public void setTaskUndone(){
        this.isDone = false;
        System.out.println("\tOkay! I've marked this task as not done:\n" +
                "\t  [" + getTaskType() + "][ ] " + getTaskDescription() + "(at: " + getTimePeriodPrint() + ")");
    }

    /**
     * Initiates start time of event object
     *
     * @param startTime start time of event in LocalDateTime
     */
    public void setStartTime(LocalDateTime startTime){
        this.startTime = startTime;
    }

    /**
     * Initiates end time of event object
     *
     * @param endTime start time of event in LocalTime
     */
    public void setEndTime(LocalTime endTime){
        this.endTime = endTime;
    }

    /**
     * Initiates task type of event object
     */
    public void setTaskType(){
        this.typeOfTask = TaskType.EVENT;
    }

    /**
     * To print task info
     */
    public void print(){
        if (isDone) {
            System.out.println("\t  [" + getTaskType() + "][X] " + getTaskDescription() + "(at: " + getTimePeriodPrint() + ")");
        }
        else {
            System.out.println("\t  [" + getTaskType() + "][ ] " + getTaskDescription() + "(at: " + getTimePeriodPrint() + ")");
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
        return (frontTxt + getTaskDescription() + "(at: " + getTimePeriodPrint() + ")");
    }
}
