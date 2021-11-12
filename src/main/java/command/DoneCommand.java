package command;

import duke.Storage;
import duke.UI;
import error.TaskNotFoundException;
import task.TaskList;

public class DoneCommand extends Command{
    protected String input;

    /**
     * Constructor of DoneCommand
     */
    public DoneCommand(String taskType, String input){
        setTaskType(taskType);
        setDone(input);
    }

    /**
     * Initiates user input
     *
     * @param input user input in String
     */
    public void setDone(String input){
        this.input = input;
    }

    /**
     * To execute the command
     *
     * @param tasks tasklist of tasks
     * @param storage read/write to text file
     * @param ui user input
     */
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
