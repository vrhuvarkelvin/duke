package duke;

import command.*;
import error.InvalidInputException;
import error.CommandInvalidException;


public class Parser {

    /**
     * Parser to read user input message and create new commands.
     * Support Shorter aliases for user commands.
     * e.g.(t - todo, d - deadline, e - event, del - delete, l - list, b - bye, f - find, v - view).
     *
     * @param input user input message.
     * @return Different types of commands.
     * @throws InvalidInputException if input message have errors.
     * @throws CommandInvalidException if wrong command was given by users.
     */
    public static Command parse(String input) throws  InvalidInputException, CommandInvalidException {
        String taskType;
        String[] userInputArray;
        userInputArray = input.split(" ", 2);
        taskType = userInputArray[0].toLowerCase();
        assert userInputArray.length >= 1 : "Invalid Input";

        switch (taskType){
        case "todo":
        case "deadline":
        case "event":
        case "t":
        case "d":
        case "e":
            return new AddCommand(taskType, userInputArray[1]);
        case "delete":
        case "del":
            return new DeleteCommand(taskType, userInputArray[1]);
        case "done":
            return new DoneCommand(taskType, userInputArray[1]);
        case "undone":
            return new UndoneCommand(taskType, userInputArray[1]);
        case "find":
        case "f":
            return new FindCommand(userInputArray[1]);
        case "view":
        case "v":
            return new ViewCommand(userInputArray[1]);
        case "list":
        case "l":
            if (userInputArray.length >= 2){
                throw new InvalidInputException("LIST_COMMAND_ERROR");
            }
            return new ListCommand();
        case "bye":
        case "b":
            return new ExitCommand();
        default:
            throw new CommandInvalidException();
        }
    }
}
