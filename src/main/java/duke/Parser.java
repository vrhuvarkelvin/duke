package duke;

import command.*;
import error.*;


public class Parser {

    public static Command parse(String input) throws  InvalidInputException, FileException {
        String taskType;
        String[] userInputArray;
        userInputArray = input.split(" ", 2);
        taskType = userInputArray[0].toLowerCase();

        switch (taskType){
        case "todo":
        case "deadline":
        case "event":
            return new AddCommand(taskType, userInputArray[1]);
        case "delete":
            return new DeleteCommand(taskType, userInputArray[1]);
        case "done":
            return new DoneCommand(taskType, userInputArray[1]);
        case "list":
            return new ListCommand();
        case "bye":
            return new ExitCommand();
        default:
            throw new FileException();

        }
    }
}
