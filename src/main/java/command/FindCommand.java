package command;

import duke.Storage;
import duke.UI;

import task.TaskList;

public class FindCommand extends Command{
    protected String input;

    /**
     * Constructor of FindCommand
     */
    public FindCommand(String input){
        setFind(input);
    }

    /**
     * Initiates user input
     *
     * @param input user input in String
     */
    public void setFind(String input){
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
        tasks.msgForFind(input);
    }
}
