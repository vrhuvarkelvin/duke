package duke;

import task.TaskList;
import error.FileException;
import error.CommandInvalidException;
import error.InvalidInputException;
import command.*;

public class Duke {

    private UI ui;
    private Parser parser;
    private TaskList tasks;
    private Storage storage;
    private static String Path = "data/tasks.txt";;

    /**
     * Read and convert String in text (filepath) to a TaskList object.
     * Constructor for Duke Object.
     * Filepath was given in Main method to call this constructor.
     * Creates a UI, Parser, Storage object.
     * If encounter error to read the txt file, auto create a new empty Tasklist object.
     *
     * @param filePath Path of the text.file to be read/save.
     */
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

    /**
     * Brain of the Duke object - Execute the duke object until isQuit is True.
     */
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
            } catch (CommandInvalidException e){
                System.out.println("\tUnrecognized Command");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("\tPlease enter description after command/command format is incorrect.");
            } catch (InvalidInputException e) {
                ui.msgError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }

    }
    public static void main(String[] args) {
        new Duke(Path).runDuke();
    }

}
