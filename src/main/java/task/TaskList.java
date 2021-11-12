package task;

import error.FileException;
import error.InvalidInputException;
import error.TaskNotFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TaskList {
    private static ArrayList<Task> list;
    private static ArrayList<String> taskSave;
    public static Task recentDelete;
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
    private static final DateTimeFormatter TIME_FORMATTER_EVENT_END_TIME = DateTimeFormatter.ofPattern("HHmm");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

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
                LocalDateTime startTime;
                LocalTime endTime;

                String[] time = taskArray[3].split("~");
                try{
                    startTime = LocalDateTime.parse(time[0], DATE_TIME_FORMATTER);
                    endTime = LocalTime.parse(time[1], TIME_FORMATTER_EVENT_END_TIME);
                    list.add(new TaskEvents(taskDescription, startTime, endTime, isDone));
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
    public void addItemToDo(String taskDescription) throws InvalidInputException{
        if(taskDescription.isEmpty()){
            throw new InvalidInputException("TODO_MISSING_DESCRIPTION");
        }
        list.add(new TaskToDo(taskDescription));
        msgForAdd();
    }

    /**
     * add new DEADLINE object into Tasklist.
     *
     * @param msgInput UserCommand (Task Description + /by + date & time).
     * @throws InvalidInputException If input is not correct (Too short or too long) or format is incorrect.
     */

    public void addItemToDeadline(String msgInput) throws InvalidInputException{
        if (msgInput.contains("/at")){
            throw new InvalidInputException("WRONG_COMMAND_ERROR");
        }
        String[] input = msgInput.split("/by ");
        LocalDateTime date;

        if (input.length < 2 || input[0].equals("")){
            throw new InvalidInputException("DEADLINE_COMMAND_ERROR");
        } else if (input.length > 2){
            throw new InvalidInputException("DEADLINE_DESCRIPTION_ERROR");
        }

        try {
            date = LocalDateTime.parse(input[1],DATE_TIME_FORMATTER);
        } catch (Exception e) {
            throw new InvalidInputException("INVALID_DATE_TIME_FORMAT");
        }
        assert input.length == 2 : "Invalid Input";
        list.add(new TaskDeadline(input[0], date));
        msgForAdd();
    }

    /**
     * add new EVENTS object into TaskList.
     *
     * @param msgInput UserCommand (Task Description + /at + date & time + /to time).
     * @throws InvalidInputException If input is not correct (Too short or too long) or format is incorrect.
     */
    public void addItemToEvents(String msgInput) throws InvalidInputException{
        if (msgInput.contains("/by")){
            throw new InvalidInputException("WRONG_COMMAND_ERROR");
        }
        String[] input = msgInput.split("/at ");

        if (input[1].equals(" ")){
            throw new InvalidInputException("EVENT_COMMAND_ERROR");
        }

        String[] time = input[1].split(" /to ");

        LocalDateTime startTime;
        LocalTime endTime;

        if(time.length == 1){
            throw new InvalidInputException("MISSING_EVENT_END_TIME");
        } else if (input.length < 2 || input[0].equals("")){
            throw new InvalidInputException("EVENT_COMMAND_ERROR");
        } else if (input.length > 2){
            throw new InvalidInputException("EVENT_DESCRIPTION_ERROR");
        }

        try {
            startTime = LocalDateTime.parse(time[0], DATE_TIME_FORMATTER);
            endTime = LocalTime.parse(time[1], TIME_FORMATTER_EVENT_END_TIME);
        } catch (Exception e){
            throw new InvalidInputException("EVENT_INVALID_DATE_TIME_FORMAT_ERROR");
        }
        assert input.length == 2 : "Invalid Input";
        assert time.length == 2 : "Invalid Input";
        list.add(new TaskEvents(input[0], startTime, endTime));
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

    public void setTaskUndone(String index) throws TaskNotFoundException {
        Integer taskNumber = Integer.parseInt(index);
        if (list.size() < taskNumber){
            throw new TaskNotFoundException();
        }
        list.get(taskNumber-1).setTaskUndone();
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

    /**
     * Message to user when user wants to search all tasks on the specified date
     *
     * @param inputDate User specified date
     * @throws InvalidInputException If user give wrong format of date
     */
    public void msgForView(String inputDate) throws InvalidInputException{
        int matchedDateIndex = 1;

        System.out.println("\tHere are the matching tasks on the specified date in your list:");
        try{
            LocalDate date = LocalDate.parse(inputDate, DATE_FORMATTER);
            for (Task task : list){
                if(task.getDateTime() != null){
                    if(task.getDateTime().toLocalDate().equals(date)){
                        System.out.println("\t" + matchedDateIndex + "." + task);
                        matchedDateIndex++;
                    }
                }
            }
            if (matchedDateIndex == 1){
                System.out.println("\t No matched task with the specified date in your list!");
            }
        } catch (Exception e){
            throw new InvalidInputException("INVALID_DATE_FORMAT");
        }
    }

    /**
     * To get size of the TaskList
     *
     * @return size of ArrayList<Task> list;
     */
    public int getSize(){
        return list.size();
    }

    /**
     * To get taskList
     *
     * @return tasks in ArrayList<Task>
     */
    public ArrayList<Task> getList(){
        return list;
    }

}
