import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        ArrayList<String> lines = getFileData("src/Input");

//        InputMaker i = new InputMaker();
//        i.getInput();

        Cookies c = new Cookies(lines);

        System.out.println("Part one answer: " + c.mostCookie() + "\n");
        System.out.println("Part two answer: " + c.clusteredMostCookie());
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}