package command;

import duke.Storage;
import duke.UI;
import task.TaskList;

public class ExitCommand extends Command{

    /**
     * Constructor of ExitCommand
     */
    public ExitCommand(){

    }

    /**
     * To execute the command
     *
     * @param tasks tasklist of tasks
     * @param storage read/write to text file
     * @param ui user input
     */
    public void execute(TaskList tasks, Storage storage, UI ui) {
        tasks.saveList();
        UI.msgBye();
        storage.saveFile(tasks.getSave());
    }

    /**
     * Override if user input to quit program
     *
     * @return boolean of true
     */
    @Override
    public boolean isQuit() {
        return true;
    }
}
