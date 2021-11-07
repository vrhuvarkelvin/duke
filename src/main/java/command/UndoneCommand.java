package command;

import duke.Storage;
import duke.UI;
import error.TaskNotFoundException;
import task.TaskList;

public class UndoneCommand extends Command{
    protected String input;

    public UndoneCommand(String taskType, String input){
        setTaskType(taskType);
        setDone(input);
    }

    public void setDone(String input){
        this.input = input;
    }

    public void execute(TaskList tasks, Storage storage, UI ui) {
        try {
            tasks.setTaskUndone(input);
        } catch (NumberFormatException e) {
            UI.msgInvalidTaskNum();
        } catch (TaskNotFoundException e){
            UI.msgTaskNotFound();
        }
    }
}
