package command;

import duke.Storage;
import duke.UI;
import error.*;
import task.TaskList;

public class DoneCommand extends Command{
    protected String input;

    public DoneCommand(String taskType, String input){
        setTaskType(taskType);
        setDone(input);
    }

    public void setDone(String input){
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
