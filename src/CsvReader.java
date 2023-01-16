import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CsvReader {


    List<String> warriors = readWarriors("./src/characters.csv");
    Random rand = new Random();
    int randomIndex1 = rand.nextInt(warriors.size());
    int randomIndex2 = rand.nextInt(warriors.size());

    //import characters from CSV and creates an arrayList
    public static List<String> readWarriors(String fileName) {
        List<String> warriors = new ArrayList<String>();

        try {
            Scanner scanner = new Scanner(new File(fileName));
            scanner.nextLine(); // Skip the first line (column headers)
            while (scanner.hasNextLine()) {
                String[] warrior = scanner.nextLine().split(",");
                warriors.add(warrior[0]);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return warriors;
    }
    public static List<String> readWizards(String fileName) {
        List<String> wizards = new ArrayList<String>();

        try {
            Scanner scanner = new Scanner(new File(fileName));
            scanner.nextLine(); // Skip the first line (column headers)
            while (scanner.hasNextLine()) {
                String[] wizard = scanner.nextLine().split(",");
                wizards.add(wizard[0]);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return wizards;
    }
}
