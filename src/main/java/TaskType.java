public enum TaskType {
    TODOS, DEADLINE, EVENT;

    public static String toStringTaskType(TaskType typeOfTask){
        String taskType = "";
        switch (typeOfTask){
        case TODOS:
            taskType = "T";
            break;
        case DEADLINE:
            taskType = "D";
            break;
        case EVENT:
            taskType = "E";
            break;
        }
        return taskType;
    }
}
