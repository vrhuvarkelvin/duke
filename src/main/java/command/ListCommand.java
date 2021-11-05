package command;

import duke.Storage;
import duke.UI;
import task.TaskList;

public class ListCommand extends Command{
    public ListCommand(){

    }

    public void execute(TaskList tasks, Storage storage, UI ui){
        tasks.msgForList();
    }
}
