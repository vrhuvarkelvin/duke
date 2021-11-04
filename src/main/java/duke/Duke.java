package duke;

import task.TaskList;
import error.*;

import java.util.Scanner;

public class Duke {

    public static void main(String[] args) throws InvalidInputException, MissingDescException {
        BotMessage.msgWelcome();

        boolean toQuit = false;
        String line;
        Scanner in = new Scanner(System.in);

        TaskList myList = new TaskList();

        while (toQuit == false){
            line = in.nextLine();

            if (line.equals("list")){
                BotMessage.msgForList(myList);

            } else if (line.equals("bye")){
                toQuit = true;

            } else if (line.contains("done")){
                if(line.length()<= 5){
                    throw new MissingDescException("done");
                }
                Integer index = Integer.parseInt(line.substring(5)) -1;
                myList.setTaskDone(index);
                BotMessage.msgMarkDone(myList, index);

            }else if (line.contains("todo")) {
                if(line.length()<= 5){
                    throw new MissingDescException("todo");
                }
                myList.addItemToDo(line.substring(5));
                BotMessage.msgForToDo(myList, myList.getNumOfTotalItem() - 1);

            } else if (line.contains("deadline")) {
                if(line.length()<= 9){
                    throw new MissingDescException("deadline");
                }
                String taskDescription = line.substring(9, line.indexOf("/"));
                String deadlineDate = line.substring(line.indexOf("/") + 4);

                myList.addItemToDeadline(taskDescription, deadlineDate);
                BotMessage.msgForDeadline(myList, myList.getNumOfTotalItem() - 1);

            } else if (line.contains("event")){
                if(line.length()<= 6){
                    throw new MissingDescException("event");
                }
                String taskDescription = line.substring(6, line.indexOf("/"));
                String eventPeriod = line.substring(line.indexOf("/") + 4);

                myList.addItemToEvents(taskDescription, eventPeriod);
                BotMessage.msgForEvents(myList, myList.getNumOfTotalItem()-1);

            } else {
                throw new InvalidInputException();
            }
        }
        in.close();
        BotMessage.msgBye();
    }

}
