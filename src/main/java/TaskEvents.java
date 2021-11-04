public class TaskEvents extends Task{
    private String timePeriod;

    public TaskEvents(String taskDescription, String timePeriod){
        super(taskDescription);
        this.isDone = false;
        this.typeOfTask = TaskType.EVENT;
        this.timePeriod = timePeriod;
    }

    public String getTimePeriod(){
        return timePeriod;
    }
}
