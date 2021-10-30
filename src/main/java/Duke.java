import java.util.Scanner;

public class Duke {

    public static void main(String[] args){
        botMessage.msgWelcome();

        boolean toQuit = false;
        String line;
        Scanner in = new Scanner(System.in);

        TaskList myList = new TaskList();

        while (toQuit == false){
            line = in.nextLine();
            if (line.equals("list")){
                botMessage.msgForList(myList);
            }
            else if (line.equals("bye")){
                toQuit = true;
            }
            else if (line.contains("done")){
                Integer index = Integer.parseInt(line.substring(5)) -1;
                myList.setTaskDone(index);
                botMessage.msgMarkDone(myList, index);
            }
            else {
                myList.addItem(line);
                botMessage.msgResponse(line);
            }
        }
        in.close();
        botMessage.msgBye();
    }
}
