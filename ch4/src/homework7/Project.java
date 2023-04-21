package Ch10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

// Hints for the Final Project
public class Project {
    public static void main(String[] args) throws FileNotFoundException {
        // How to read in a file in Java
        // This will print out the current directory -- where IntelliJ will read your file
        String curDir = new File(".").getAbsolutePath();
        System.out.println("Current sys dir: " + curDir);

        Scanner text_file = new Scanner(new File("Malala2013.txt"));

        // Or you can use the full path for the file
        File file =
                new File("C:\\ISU\\Classes\\Data_Struct_Alg\\Malala2013.txt");
        Scanner full_path_file = new Scanner(file);

        // Note that you can't pass the file string directly -- or it only reads
        // that string (ie the name of the file)
        System.out.println(full_path_file.nextLine());
        System.out.println(text_file.nextLine());

        while (text_file.hasNextLine()) {
            System.out.println(text_file.nextLine());
        }

        // Use a delimiter to clean the words as you scan them in
        Scanner delim_file = new Scanner(file).useDelimiter("[^a-zA-Z]+");
        for (int i=0; i<10; i++) {
            System.out.println(delim_file.next());
        }
        // This delimiter uses RegEx (regular expressions) and reads
        // NOT a-z or A-Z, repeated once or more
        // [abc] is only a or b or c
        // [^abc] is NOT (a or b or c)
        // [a-z] is characters a thru z
        // + is one or more repetitions


        // Using HashMaps
        // HashMap<Key type, Value type>
        HashMap<String, String> capitalCities = new HashMap<String, String>();
        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("USA", "Washington DC");
        System.out.println(capitalCities);
        System.out.println(capitalCities.keySet());
        for (var str : capitalCities.keySet()) {
            System.out.println(str);
        }
    }
}
