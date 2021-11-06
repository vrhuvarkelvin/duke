package duke;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private static String filePath;
    private ArrayList<String> loadFile;
    public Storage(String filePath){
        this.filePath = filePath;
        loadFile = new ArrayList<>();
    }

    /**
     * Creates a new file with parent directory OR/
     * Load existing file.
     */
    public void newFile(){
        try {
            File f = new File(filePath);
            f.getParentFile().mkdirs();
            if (f.createNewFile()) {
                System.out.println("File created");
            } else {
                System.out.println("Loading existing file");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /**
     * Save all tasks into a text file.
     * Activate when ExitCommand is called.
     *
     * @param TaskDetailsString array of strings to save into the txt file.
     */
    public void saveFile(ArrayList<String> TaskDetailsString){
        try {
            writeToFile(TaskDetailsString);
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    /**
     * Create a new loaded file object (Consists of ArrayList<String>).
     *
     * @return loaded file with all tasks in ArrayList<String> format.
     */
    public ArrayList<String> load(){
        try {
            readFile(filePath);
        } catch (FileNotFoundException e) {
            newFile();
            System.out.println("File not found");
        }
        return loadFile;
    }

    private void writeToFile(ArrayList<String> saveFileList) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        for(String saveFile : saveFileList) {
            fw.write(saveFile + System.lineSeparator());
        }
        fw.close();
    }

    private void readFile(String filePath) throws FileNotFoundException  {
        File f = new File(filePath);
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            String read = s.nextLine();
            loadFile.add(read);
        }
    }

}

