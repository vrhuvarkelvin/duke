package command;

import duke.Storage;
import duke.UI;
import error.InvalidInputException;
import task.TaskList;

public class ViewCommand extends Command{
    protected String input;

    public ViewCommand(String input){
        setTaskType(taskType);
        setFind(input);
    }

    public void setFind(String input){
        this.input = input;
    }

    public void execute(TaskList tasks, Storage storage, UI ui) {
        try{
            tasks.msgForView(input);
        } catch (InvalidInputException e){
            ui.msgError(e.getMessage());
        }

    }
}
