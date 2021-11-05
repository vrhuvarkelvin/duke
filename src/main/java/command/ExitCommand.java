package command;

import duke.Storage;
import duke.UI;
import task.TaskList;

public class ExitCommand extends Command{
    public ExitCommand(){

    }

    public void execute(TaskList tasks, Storage storage, UI ui) {
        tasks.saveList();
        UI.msgBye();
        storage.saveFile(tasks.getSave());
    }

    @Override
    public boolean isQuit() {
        return true;
    }
}
