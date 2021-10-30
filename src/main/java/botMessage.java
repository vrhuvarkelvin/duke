public class botMessage {
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

    public static void msgForList(TaskList myList){
        for (int i = 0; i < myList.getNumOfTotalItem(); i++){
            if(!myList.getTaskStatus(i)){
                System.out.println(Integer.toString(i+1) + ".[ ] " + myList.getTaskDetails(i));
            }
            else {
                System.out.println(Integer.toString(i+1) + ".[X] " + myList.getTaskDetails(i));
            }
        }
    }

    public static void msgMarkDone(TaskList myList, int index){
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("    " + "[X] " + myList.getTaskDetails(index));
    }
}
