package command;

import duke.Storage;
import duke.UI;

import task.TaskList;

public class FindCommand extends Command{
    protected String input;

    public FindCommand(String input){
        setTaskType(taskType);
        setFind(input);
    }

    public void setFind(String input){
        this.input = input;
    }

    public void execute(TaskList tasks, Storage storage, UI ui) {
        tasks.msgForFind(input);
    }
}
