package command;

import duke.UI;
import duke.Storage;
import task.TaskList;
import error.*;

public class AddCommand extends Command{
    protected String input;

    public AddCommand(String taskType, String input){
        setTaskType(taskType);
        setAdd(input);
    }

    public void setAdd(String input){
        this.input = input;
    }

    public void execute(TaskList tasks, Storage storage, UI ui) {
        try {
            tasks.addTask(taskType, input);
        } catch (InvalidInputException e) {
            UI.msgError(e.getMessage());
        }
    }
}
