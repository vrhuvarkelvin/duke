package duke;

import java.util.Scanner;

public class UI {
    private static final String DIVIDER_LINE = "__________________________________________";
    private static final String INPUT_FORMAT_ERROR = "Please do not use '|' as it breaks the program.";


    public static void msgWelcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println(("Hello from\n" + logo));
        System.out.println("Hello! I'm Duke.Duke");
        System.out.println("What can I do for you?");
    }

    public static void msgBye(){
        System.out.println("Bye. Hope to see you again soon!");
    }

    public static void msgInvalidTaskNum(){
        System.out.println("\t Invalid task number! Please enter again!");
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
        default:
            System.out.println("Unrecognized error");

        }
    }

}
