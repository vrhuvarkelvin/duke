package task;

import error.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> list;
    private ArrayList<String> taskSave;
    public Task recentDelete;
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public TaskList() {
        list = new ArrayList<Task>();
        taskSave = new ArrayList<>();
    }

    public TaskList(ArrayList<String> loadFile) throws FileException{
        list = new ArrayList<>();
        taskSave = new ArrayList<>();
        String[] taskArray;
        loadFile.listIterator();
        for(String task : loadFile){
            taskArray = task.split(" \\|");
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

    public void addItemToDo(String taskDescription) {
        list.add(new TaskToDo(taskDescription));
        msgForAdd();
    }

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

        list.add(new TaskDeadline(input[0], date));
        msgForAdd();
    }

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
        list.add(new TaskEvents(input[0], date));
        msgForAdd();

    }

    public void setTaskDone(String index) throws TaskNotFoundException {
        Integer taskNumber = Integer.parseInt(index);
        if (list.size() < taskNumber){
            throw new TaskNotFoundException();
        }
        list.get(taskNumber-1).setDone();
    }

    public void deleteTask(String index) throws TaskNotFoundException {
        Integer taskNumber = Integer.parseInt(index);
        if (list.size() < taskNumber){
            throw new TaskNotFoundException();
        }
        recentDelete = list.get(taskNumber-1);
        list.remove(taskNumber-1);
        msgForDelete();
    }

    public void addTask(String taskType, String input) throws InvalidInputException {
        switch (taskType) {
        case "todo":
            addItemToDo(input);
            break;
        case "deadline":
            addItemToDeadline(input);
            break;
        case "event":
            addItemToEvents(input);
            break;
        }
    }

    public void saveList(){
        for(Task task : list){
            taskSave.add(task.getSave());
        }
    }

    public ArrayList<String> getSave(){
        return taskSave;
    }

    public void msgForAdd(){
        System.out.println("Got it, I've added this task:");
        list.get(list.size()-1).print();
        System.out.println("Now you have " + list.size() + " tasks in the list.");
    }

    public void msgForList(){
        System.out.println("Here are the tasks in your list:");
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

    public void msgForDelete(){
        System.out.println("\tNoted. I have removed the task: ");
        recentDelete.print();
        System.out.println("\tNow you have " + (list.size()) +" task(s) in the list");
    }

}
