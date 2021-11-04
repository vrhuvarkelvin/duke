public class TaskDeadline extends Task {
    private String dateInString;

    public TaskDeadline(String TaskDescription, String dateInString){
        super(TaskDescription);
        this.isDone = false;
        this.typeOfTask = TaskType.DEADLINE;
        this.dateInString = dateInString;
    }

    public String getDateInString(){
        return dateInString;
    }
}
