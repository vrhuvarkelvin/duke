public class BotMessage {
    public static void msgWelcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println(("Hello from\n" + logo));
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
    }

    public static void msgBye(){
        System.out.println("Bye. Hope to see you again soon!");
    }

    public static void msgResponse(String s){
        System.out.println("added: " + s);
    }

    public static void msgInvalidInput(){
        System.out.println("Invalid input. Please try again. Thank you!");
    }

    public static void msgForList(TaskList myList){
        System.out.println("Here are the tasks in your list:");

        for (int i = 0; i < myList.getNumOfTotalItem(); i++) {
            TaskType typeOfTask = myList.getTypeOfTask(i);
            boolean isDone = myList.getTaskStatus(i);

            String taskTypeStringMsg = TaskType.toStringTaskType(typeOfTask);
            String isDoneStringMsg = (isDone ? "X" : "");
            String taskDescriptionMsg = myList.getTaskDescription(i);

            switch (typeOfTask){
            case TODOS:
                System.out.println(Integer.toString(i + 1) + ".[" + taskTypeStringMsg + "][" + isDoneStringMsg +
                        "] " + taskDescriptionMsg);
                break;
            case DEADLINE:
                String taskDeadlineInStringMsg = myList.getTaskDeadlineInString(i);
                System.out.println(Integer.toString(i + 1) + ".[" + taskTypeStringMsg + "][" + isDoneStringMsg +
                        "] " + taskDescriptionMsg + "(by: " + taskDeadlineInStringMsg + ")" );
                break;
            case EVENT:
                String taskEventPeriod = myList.getTaskEventTimePeriodInString(i);
                System.out.println(Integer.toString(i + 1) + ".[" + taskTypeStringMsg + "][" + isDoneStringMsg +
                        "] " + taskDescriptionMsg + "(at: " + taskEventPeriod + ")" );
                break;
            }
        }
    }

    public static void msgMarkDone(TaskList myList, int index){
        String taskDescriptionMsg = myList.getTaskDescription(index);

        System.out.println("Nice! I've marked this task as done:");
        System.out.println("    " + "[X] " + taskDescriptionMsg);
    }

    public static void msgForToDo(TaskList myList, int index){
        TaskType typeOfTask = myList.getTypeOfTask(index);
        boolean isDone = myList.getTaskStatus(index);

        String taskTypeStringMsg = TaskType.toStringTaskType(typeOfTask);
        String isDoneStringMsg = (isDone ? "X" : "");
        String taskDescriptionMsg = myList.getTaskDescription(index);

        System.out.println("Got it, I've added this task:");
        System.out.println("   [" + taskTypeStringMsg + "][" + isDoneStringMsg + "] " + taskDescriptionMsg);
        System.out.println("Now you have " + myList.getNumOfTotalItem() + " tasks in the list.");
    }

    public static void msgForDeadline(TaskList myList, int index){
        TaskType typeOfTask = myList.getTypeOfTask(index);
        boolean isDone = myList.getTaskStatus(index);

        String taskTypeStringMsg = TaskType.toStringTaskType(typeOfTask);
        String isDoneStringMsg = (isDone ? "X" : "");
        String taskDescriptionMsg = myList.getTaskDescription(index);
        String taskDeadlineInStringMsg = myList.getTaskDeadlineInString(index);

        System.out.println("Got it, I've added this task:");
        System.out.println("   [" + taskTypeStringMsg + "][" + isDoneStringMsg + "] " + taskDescriptionMsg + "(by: " + taskDeadlineInStringMsg + ")");
        System.out.println("Now you have " + myList.getNumOfTotalItem() + " tasks in the list.");
    }

    public static void msgForEvents(TaskList myList, int index){
        TaskType typeOfTask = myList.getTypeOfTask(index);
        boolean isDone = myList.getTaskStatus(index);

        String taskTypeStringMsg = TaskType.toStringTaskType(typeOfTask);
        String isDoneStringMsg = (isDone ? "X" : "");
        String taskDescriptionMsg = myList.getTaskDescription(index);
        String taskEventPeriod = myList.getTaskEventTimePeriodInString(index);

        System.out.println("Got it, I've added this task:");
        System.out.println("   [" + taskTypeStringMsg + "][" + isDoneStringMsg + "] " + taskDescriptionMsg + "(at: " + taskEventPeriod + ")");
        System.out.println("Now you have " + myList.getNumOfTotalItem() + " tasks in the list.");
    }
}
