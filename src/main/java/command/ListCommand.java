package command;

import duke.Storage;
import duke.UI;
import task.TaskList;

public class ListCommand extends Command{

    /**
     * Constructor of ListCommand
     */
    public ListCommand(){

    }

    /**
     * To execute the command
     *
     * @param tasks tasklist of tasks
     * @param storage read/write to text file
     * @param ui user input
     */
    public void execute(TaskList tasks, Storage storage, UI ui){
        tasks.msgForList();
    }
}
