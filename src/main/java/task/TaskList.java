package task;

import error.FileException;
import error.InvalidInputException;
import error.TaskNotFoundException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> list;
    private ArrayList<String> taskSave;
    public Task recentDelete;
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");

    /**
     * Constructor of TaskList.
     */
    public TaskList() {
        list = new ArrayList<Task>();
        taskSave = new ArrayList<>();
    }

    /**
     * Takes in input of String from loaded file (txt file) and creates a new list with Tasks.
     *
     * @param loadFile String from text file.
     * @throws FileException If file is not found.
     */
    public TaskList(ArrayList<String> loadFile) throws FileException{
        list = new ArrayList<>();
        taskSave = new ArrayList<>();
        String[] taskArray;
        loadFile.listIterator();

        for(String task : loadFile){
            taskArray = task.split(" \\| ");
            String taskType, taskStatus, taskDescription;
            LocalDateTime date;
            Boolean isDone = false;
            taskType = taskArray[0];
            taskStatus = taskArray[1];
            taskDescription = taskArray[2];

            if(taskStatus.equals("1")){
                isDone = true;
            }
            switch (taskType){
            case "T":
                list.add(new TaskToDo(taskDescription, isDone));
                break;
            case "D":
                try{
                    date = LocalDateTime.parse(taskArray[3], DATE_TIME_FORMATTER);
                    list.add(new TaskDeadline(taskDescription, date, isDone));
                } catch (Exception e){
                    throw new FileException();
                }
                break;
            case "E":
                try{
                    date = LocalDateTime.parse(taskArray[3], DATE_TIME_FORMATTER);
                    list.add(new TaskEvents(taskDescription, date, isDone));
                } catch (Exception e){
                    throw new FileException();
                }
                break;
            }
        }
    }

    /**
     * add new TODO object into TaskList.
     *
     * @param taskDescription Task description e.g. Project Meeting.
     */
    public void addItemToDo(String taskDescription) {
        list.add(new TaskToDo(taskDescription));
        msgForAdd();
    }

    /**
     * add new DEADLINE object into Tasklist.
     *
     * @param msgInput UserCommand (Task Description + /by + date & time).
     * @throws InvalidInputException If input is not correct (Too short or too long).
     */

    public void addItemToDeadline(String msgInput) throws InvalidInputException{
        String[] input = msgInput.split("/by ");
        LocalDateTime date;

        if (input.length < 2){
            throw new InvalidInputException("MISSING_DEADLINE_ERROR");
        } else if (input.length > 2){
            throw new InvalidInputException("DEADLINE_DESCRIPTION_ERROR");
        }

        try {
            date = LocalDateTime.parse(input[1],DATE_TIME_FORMATTER);
        } catch (Exception e) {
            throw new InvalidInputException("INVALID_DATE_FORMAT");
        }
        assert input.length == 2 : "Invalid Input";
        list.add(new TaskDeadline(input[0], date));
        msgForAdd();
    }

    /**
     * add new EVENTS object into TaskList.
     *
     * @param msgInput UserCommand (Task Description + /at + date & time).
     * @throws InvalidInputException If input is not correct (Too short or too long).
     */
    public void addItemToEvents(String msgInput) throws InvalidInputException{
        String[] input = msgInput.split("/at ");
        LocalDateTime date;

        if (input.length < 2){
            throw new InvalidInputException("MISSING_EVENT_ERROR");
        } else if (input.length > 2){
            throw new InvalidInputException("EVENT_DESCRIPTION_ERROR");
        }

        try {
            date = LocalDateTime.parse(input[1],DATE_TIME_FORMATTER);
        } catch (Exception e){
            throw new InvalidInputException("INVALID_DATE_FORMAT_ERROR");
        }
        assert input.length == 2 : "Invalid Input";
        list.add(new TaskEvents(input[0], date));
        msgForAdd();

    }

    /**
     * Set the task to Done status.
     *
     * @param index index of the task in TaskList.
     * @throws TaskNotFoundException If task index is not found in TaskList.
     */
    public void setTaskDone(String index) throws TaskNotFoundException {
        Integer taskNumber = Integer.parseInt(index);
        if (list.size() < taskNumber){
            throw new TaskNotFoundException();
        }
        list.get(taskNumber-1).setTaskDone();
    }

    /**
     * Delete the task
     *
     * @param index index of the task in TaskList.
     * @throws TaskNotFoundException If task index is not found in TaskList.
     */
    public void deleteTask(String index) throws TaskNotFoundException {
        Integer taskNumber = Integer.parseInt(index);
        if (list.size() < taskNumber){
            throw new TaskNotFoundException();
        }
        recentDelete = list.get(taskNumber-1);
        list.remove(taskNumber-1);
        msgForDelete();
    }

    /**
     * To determine the type of task.
     * Called by AddCommand.
     *
     * @param taskType The type of task (TODO, DEADLINE, EVENT).
     * @param input Task description.
     * @throws InvalidInputException If input is not correct.
     */
    public void addTask(String taskType, String input) throws InvalidInputException {
        assert taskType.equals("todo") || taskType.equals("t") || taskType.equals("deadline")
                || taskType.equals("d") || taskType.equals("event") || taskType.equals("e") : "Invalid TaskType";

        switch (taskType) {
        case "todo":
        case "t":
            addItemToDo(input);
            break;
        case "deadline":
        case "d":
            addItemToDeadline(input);
            break;
        case "event":
        case "e":
            addItemToEvents(input);
            break;
        }
    }

    /**
     * Get the String format of each task and put them in an ArrayList of String.
     */
    public void saveList(){
        for(Task task : list){
            taskSave.add(task.getSave());
        }
    }

    /**
     * To consolidate all tasks into String.
     *
     * @return ArrayList of String to be stored in Text File.
     */
    public ArrayList<String> getSave(){
        return taskSave;
    }


    /**
     * Message to user when a task is added.
     */
    public void msgForAdd(){
        System.out.println("Got it, I've added this task:");
        list.get(list.size()-1).print();
        System.out.println("Now you have " + list.size() + " tasks in the list.");
    }

    /**
     * Print out all tasks in TaskList.
     */
    public void msgForList(){
        System.out.println("\tHere are the tasks in your list:");
        if(list.size() == 0){
            System.out.println("\t List is empty!");
        } else {
            int index = 1;
            for(Task task : list){
                System.out.println("\t" + index + "." + task);
                index++;
            }
        }
    }

    /**
     * Message to user when a task is deleted.
     */
    public void msgForDelete(){
        System.out.println("\tNoted. I have removed the task: ");
        recentDelete.print();
        System.out.println("\tNow you have " + (list.size()) +" task(s) in the list");
    }

    /**
     * Message to user when find for matching/non matching tasks in List.
     *
     * @param input User input to search for which keyword in List.
     */
    public void msgForFind(String input){
        int matchedTaskIndex = 1;

        System.out.println("\tHere are the matching tasks in your list:");
        for (Task task : list){
            if (task.getTaskDescription().toLowerCase().contains(input.toLowerCase())){
                System.out.println("\t" + matchedTaskIndex + "." + task);
                matchedTaskIndex++;
            }
        }
        if (matchedTaskIndex == 1){
            System.out.println("\t No matched task in your list!");
        }
    }

}
