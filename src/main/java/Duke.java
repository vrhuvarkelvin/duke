import java.util.Scanner;

public class Duke {
    public static void msgGreet() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println(("Hello from\n" + logo));
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
    }

    public static void msgBye(){
        System.out.println("Bye. Hope to see you again soon!");
    }

    public static void echo(String s){
        System.out.println("added: " + s);
    }

    public static void main(String[] args){
        msgGreet();

        boolean bye = false;
        String line;
        Scanner in = new Scanner(System.in);

        List myList = new List();

        while (bye == false){
            line = in.nextLine();
            if (line.equals("list")){
                for (int i = 0; i <myList.getNumOfItem(); i++){
                    System.out.println(Integer.toString(i+1) + ": " + myList.getItem(i));
                }
            }
            else if (line.equals("bye")){
                msgBye();
                bye = true;
            }
            else {
                myList.addItem(line);
                echo(line);
            }
        }
    }
}
