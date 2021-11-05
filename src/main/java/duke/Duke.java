package duke;

import task.TaskList;
import error.*;
import command.*;

public class Duke {

    private UI ui;
    private Parser parser;
    private TaskList tasks;
    private Storage storage;
    private static String Path = "data/tasks.txt";;

    public Duke (String filePath) {
        ui = new UI();
        parser = new Parser();
        storage = new Storage(filePath);
        try{
            tasks = new TaskList(storage.load());
            System.out.println("File loaded successfully.");
        } catch (FileException e) {
            System.out.println("\tFile format is corrupted. Creating new file.");
            tasks = new TaskList();
        } catch (Exception e){
            System.out.println("Error reading file or does not exist. Creating new file.");
            tasks = new TaskList();
        }
    }

    public void runDuke(){
        ui.msgWelcome();
        boolean isQuit = false;
        while (!isQuit){
            try {
                String userInput = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(userInput);
                c.execute(tasks, storage, ui);
                isQuit = c.isQuit();
            } catch (InvalidInputException e){
                System.out.println("\tUnrecognized Command");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("\tPlease enter description after command");
            } catch (FileException e) {
                e.printStackTrace();
            } finally {
                ui.showLine();
            }
        }

    }
    public static void main(String[] args) {
        new Duke(Path).runDuke();
    }

}
