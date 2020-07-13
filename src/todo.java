import javax.imageio.IIOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class todo {

    public static void main(String[] arg) throws Exception {
        if (arg.length == 0) {

            System.out.println("Command Line Todo application");
            System.out.println("=============================");
            System.out.println();
            System.out.println("Command line arguments:");
            System.out.println("-l   Lists all the tasks");
            System.out.println("-a   Adds a new task");
            System.out.println("-r   Removes an task");
            System.out.println("-c   Completes an task");

            //-l
        } else if (arg[0].equals("-l")) {     
            try {
                Path file_path = Paths.get("todo.txt");
                List<String> lines = Files.readAllLines(file_path);
                if (lines.size() == 0) {
                    System.out.println("No todos for today! :)");
                } else {
                    int i = 0;
                    for (String line : lines) {
                        i += 1;
                        //System.out.println(i + " - " + "["+line.charAt(0)+"] " + line.substring(1));
                        System.out.printf("%d - [%c] %s\n", i, line.charAt(0), line.substring(1));
                    }
                }
            } catch (IIOException e) {
                System.out.println("trebaZeExceptionaBylaNalezena");
            }
            //-a
        } else if (arg[0].equals("-a")) {
            if (arg.length == 1) {
                System.out.println("Unable to add: no task provided");
            } else {
                Path file_path = Paths.get("todo.txt");
                List<String> lines = new ArrayList<>();
                lines.add(" " + arg[1]);            //zapise do souboru
                Files.write(file_path, lines, StandardOpenOption.APPEND);
            }
            //-r
        } else if (arg[0].equals("-r")) {
            // Path file_path = Paths.get("todo.txt");
            // List<String> lines = Files.readAllLines(file_path);
            //for (String line : lines)

            if (arg.length == 1) {                     //pokud neni zadany task, je jen index
                System.out.println("Unable to remove: no index provided");

                /*} else if (arg[0] != lines.equals(Integer)) {
                    System.out.println("Unable to remove: index is not a number");

                } else if (arg.length <= lines.size()) {
                    System.out.println("Unable to remove: index is out of bound");*/
            } else {
                Path file_path = Paths.get("todo.txt");
                List<String> lines = Files.readAllLines(file_path);
                try {
                    lines.remove(Integer.valueOf(arg[1])/*funkce vytvorila Integer, ted jeste vytvorit int .inValuem a odecist index, ktery se pocita od 0*/.intValue() - 1);
                    Files.write(file_path, lines);
                } catch (NumberFormatException e) {       //pokud na druhe pozici není number
                    System.out.println("Unable to remove: index is not a number");
                } catch (IndexOutOfBoundsException e) {   //pokud index je vetsi nez pocet tasku
                    System.out.println("Unable to remove: index is out of bound");
                }
            }
            //-c
        } else if (arg[0].equals("-c")) {
            Path file_path = Paths.get("todo.txt");
            List<String> lines = Files.readAllLines(file_path);
            try {
                int index = Integer.valueOf(arg[1])/*funkce vytvorila Integer,jeste vytvorit int .inValuem a odecist index=poocita se od 0*/.intValue() - 1;
                String task = lines.get(index);
                lines.set(index, "x" + task.substring(1));
                Files.write(file_path, lines);
            /*for (String line : lines) {
                int i += 1;
                if (arg[1] == i) {
                    System.out.println(i + " - " + "[x] " + line);
                }else{
                System.out.println(i + " - " + "[] " + line);}
                Files.write(file_path, lines);
            } */
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Unable to check: no index provided");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Unable to check: index is out of bound");
            } catch (NumberFormatException e) {
                System.out.println("Unable to check: index is not a number");
            }

        } else {
            System.out.println("Unsupported argument");
            System.out.println("Command Line Todo application");
            System.out.println("=============================");
            System.out.println();
            System.out.println("Command line arguments:");
            System.out.println("-l   Lists all the tasks");
            System.out.println("-a   Adds a new task");
            System.out.println("-r   Removes an task");
            System.out.println("-c   Completes an task");
        }
    }
}

//ArrayList<String> newLines = new ArrayList<>();
// newLines.add("Walk the dog");
//  for (int i = 0; i <newLines.size() ; i++) {
//  list.add("Walk the dog");
//        list.add("Buy milk");
//        list.add("Do homework");}


      /*  public static String(String x) {
            if (x = "-l") {
                System.out.println("Lists all the tasks");
            } else if (x = "-a") {
                System.out.println("Adds a new task");
            } else if (x = "-r") {
                System.out.println("Removes an task");
            } else if (x = "-c") {
                System.out.println("Completes an task");
            }
        } */


