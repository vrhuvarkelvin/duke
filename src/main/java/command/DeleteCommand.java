package command;

import duke.Storage;
import duke.UI;
import error.*;
import task.TaskList;

public class DeleteCommand extends Command{
    protected String input;

    public DeleteCommand(String taskType, String input){
        setTaskType(taskType);
        setDelete(input);
    }

    public void setDelete(String input){
        this.input = input;
    }

    public void execute(TaskList tasks, Storage storage, UI ui) {
        try {
            tasks.setTaskDone(input);
        } catch (NumberFormatException e) {
            UI.msgInvalidTaskNum();
        } catch (TaskNotFoundException e){
            UI.msgTaskNotFound();
        }
    }
}
