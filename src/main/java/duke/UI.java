package duke;

import java.util.Scanner;

public class UI {
    private final String DIVIDER_LINE = "_________________________________________________________________________________________";
    private final String LONGER_DIVIDER_LINE = "_____________________________________________________________________________________________________________";
    private static final String INPUT_FORMAT_ERROR = "Please do not use '|' as it breaks the program.";
    private static final String MISSING_EVENT_END_TIME = "Please specify the event end time.";
    private static final String TODO_MISSING_DESCRIPTION = "Please specify task description.";
    private static final String INVALID_DATE_TIME_FORMAT = "Please use correct date & time format: 2021-10-28 2100.";
    private static final String INVALID_DATE_FORMAT = "Please use correct date format: 2021-10-28.";
    private static final String DEADLINE_COMMAND_ERROR = "Please specify the deadline of the task and/or task description is missing.";
    private static final String DEADLINE_DESCRIPTION_ERROR = "Deadline command is incorrect or too many /by. Please try again.";
    private static final String EVENT_COMMAND_ERROR = "Please specify the time of the task and/or task description is missing.";
    private static final String EVENT_DESCRIPTION_ERROR = "Event command is incorrect or too many /at or /to. Please try again.";
    private static final String EVENT_INVALID_DATE_TIME_FORMAT_ERROR = "The date time format after /at is incorrect. Please use correct format: event project /at 2021-11-11 1300 /to 1500";
    private static final String LIST_COMMAND_ERROR = "Please do not type anything after 'list' or 'l' command.";
    private static final String WRONG_COMMAND_ERROR = "Wrong command is used. Deadline task should use /by meanwhile Event task should use /at and /to";


    public void msgWelcome() {
        showLongerLine();
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println(("Hello from\n" + logo));
        System.out.println("Hello! I'm Duke by Kelvin");
        System.out.println("What can I do for you?");
        msgAllCommands();
        showLongerLine();
    }

    public void msgAllCommands(){
        System.out.println("\tHere are the commands available:");
        System.out.println("\t1) Enter 'todo' OR 't' 'text'                             ----- To add a TODO task ");
        System.out.println("\t   e.g. todo buy tickets OR");
        System.out.println("\t   e.g. t buy tickets\n");
        System.out.println("\t2) Enter 'deadline' OR 'd' 'text' '/by' 'date & time'     ----- To add a DEADLINE task ");
        System.out.println("\t   e.g. deadline quiz /by 2021-10-10 2359 OR");
        System.out.println("\t   e.g. d quiz /by 2021-10-10 2359\n");
        System.out.println("\t3) Enter 'event' OR 'e' 'text' '/at' 'date & time' '/to' 'time'   ----- To add a EVENT task ");
        System.out.println("\t   e.g. event project meeting /at 2021-08-08 1400 /to 1600 OR");
        System.out.println("\t   e.g. e project meeting /at 2021-08-08 1400 /to 1600\n");
        System.out.println("\t4) Enter 'list' OR 'l'                      ----- To view all tasks in list ");
        System.out.println("\t   e.g. list OR l\n");
        System.out.println("\t5) Enter 'done' 'number'                    ----- To mark the task as done ");
        System.out.println("\t   e.g. done 3\n");
        System.out.println("\t6) Enter 'undone' 'number'                  ----- To mark the task as not done ");
        System.out.println("\t   e.g. undone 3\n");
        System.out.println("\t7) Enter 'delete' OR 'del' 'number'         ----- To delete the task ");
        System.out.println("\t   e.g. delete 3 OR del 3\n");
        System.out.println("\t8) Enter 'find' OR 'f' 'text'               ----- To find the tasks which contains the keyword ");
        System.out.println("\t   e.g. find project OR f project\n");
        System.out.println("\t9) Enter 'view' OR 'v' 'date'               ----- To view the tasks on specified date ");
        System.out.println("\t   e.g. view 2021-08-08 OR v 2021-08-08\n");
        System.out.println("\t10) Enter 'bye' OR 'b'                       ----- To exit the program ");
        System.out.println("\t   e.g. bye OR b\n");
    }

    public static void msgBye(){
        System.out.println("Bye. Hope to see you again soon!");
    }

    public static void msgInvalidTaskNum(){
        System.out.println("\t Invalid task number format! The correct format is e.g. delete/done/undone 3!");
    }

    public static void msgTaskNotFound(){
        System.out.println("\t Task cannot be found! Please enter again!");
    }

    /**
     * Activate scanner to read user command
     * @return user input message
     */
    public String readCommand(){
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public void showLine(){
        System.out.println(DIVIDER_LINE);
    }

    public void showLongerLine(){
        System.out.println(LONGER_DIVIDER_LINE);
    }

    /**
     * Show user different types of error msg
     * @param errorMsg Error message
     */
    public static void msgError(String errorMsg){
        System.out.print("\tError occurred: ");
        switch(errorMsg){
        case "INPUT_FORMAT_ERROR":
            System.out.println(INPUT_FORMAT_ERROR);
            break;
        case "TODO_MISSING_DESCRIPTION":
            System.out.println(TODO_MISSING_DESCRIPTION);
            break;
        case "MISSING_EVENT_END_TIME":
            System.out.println(MISSING_EVENT_END_TIME);
            break;
        case "INVALID_DATE_FORMAT":
            System.out.println(INVALID_DATE_FORMAT);
            break;
        case "INVALID_DATE_TIME_FORMAT":
            System.out.println(INVALID_DATE_TIME_FORMAT);
            break;
        case "DEADLINE_COMMAND_ERROR":
            System.out.println(DEADLINE_COMMAND_ERROR);
            break;
        case "DEADLINE_DESCRIPTION_ERROR":
            System.out.println(DEADLINE_DESCRIPTION_ERROR);
            break;
        case "EVENT_COMMAND_ERROR":
            System.out.println(EVENT_COMMAND_ERROR);
            break;
        case "EVENT_DESCRIPTION_ERROR":
            System.out.println(EVENT_DESCRIPTION_ERROR);
            break;
        case "EVENT_INVALID_DATE_TIME_FORMAT_ERROR":
            System.out.println(EVENT_INVALID_DATE_TIME_FORMAT_ERROR);
            break;
        case "LIST_COMMAND_ERROR":
            System.out.println(LIST_COMMAND_ERROR);
            break;
        case "WRONG_COMMAND_ERROR":
            System.out.println(WRONG_COMMAND_ERROR);
            break;
        default:
            System.out.println("Unrecognized error");

        }
    }

}
