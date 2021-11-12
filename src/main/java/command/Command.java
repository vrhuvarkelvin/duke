package command;

import duke.Storage;
import duke.UI;
import task.TaskList;

public abstract class Command {
    protected String taskType;

    /**
     * Constructor of command
     */
    public Command(){

    }

    /**
     * Initiates task type of task
     *
     * @param taskType task type of task object
     */
    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    /**
     * To check if user want to quit program
     *
     * @return boolean of true or false
     */
    public boolean isQuit(){
        return false;
    }

    /**
     * To execute the command
     *
     * @param tasks tasklist of tasks
     * @param storage read/write to text file
     * @param ui user input
     */
    public abstract void execute(TaskList tasks, Storage storage, UI ui);
}
