package command;

import duke.Storage;
import duke.UI;
import task.TaskList;

public abstract class Command {
    protected String taskType;
    public Command(){

    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public boolean isQuit(){
        return false;
    }

    public abstract void execute(TaskList tasks, Storage storage, UI ui);
}
