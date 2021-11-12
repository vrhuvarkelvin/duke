package command;

import duke.UI;
import duke.Storage;
import task.TaskList;
import error.InvalidInputException;

public class AddCommand extends Command{
    protected String input;

    /**
     * Constructor of AddCommand
     */
    public AddCommand(String taskType, String input){
        setTaskType(taskType);
        setAdd(input);
    }

    /**
     * Initiates user input
     *
     * @param input user input in String
     */
    public void setAdd(String input){
        this.input = input;
    }

    /**
     * To execute the command
     *
     * @param tasks tasklist of tasks
     * @param storage read/write to text file
     * @param ui user input
     */
    public void execute(TaskList tasks, Storage storage, UI ui) {
        try {
            tasks.addTask(taskType, input);
        } catch (InvalidInputException e) {
            UI.msgError(e.getMessage());
        }
    }
}
