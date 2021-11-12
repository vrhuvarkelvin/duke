package command;

import duke.Storage;
import duke.UI;
import error.InvalidInputException;
import task.TaskList;

public class ViewCommand extends Command{
    protected String input;

    /**
     * Constructor of ViewCommand
     */
    public ViewCommand(String input){
        setTaskType(taskType);
        setView(input);
    }

    /**
     * Initiates user input
     *
     * @param input user input in String
     */
    public void setView(String input){
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
        try{
            tasks.msgForView(input);
        } catch (InvalidInputException e){
            ui.msgError(e.getMessage());
        }

    }
}
