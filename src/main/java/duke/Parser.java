package duke;

import command.*;
import error.*;


public class Parser {

    /**
     * Parser to read user input message and create new commands
     *
     * @param input user input message
     * @return Different types of commands
     * @throws InvalidInputException if input message have errors
     * @throws CommandInvalidException if wrong command was given by users
     */

    public static Command parse(String input) throws  InvalidInputException, CommandInvalidException {
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
            throw new CommandInvalidException();

        }
    }
}
