package filereader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileReader {
    Scanner sc;
    public FileReader(String pathToFile) throws FileNotFoundException {
        File file = new File(pathToFile);

        sc = new Scanner(file);
    }

    List<String> readListOfRucksackContents() {
        List<String> rucksackContents = new ArrayList<>();
        while (sc.hasNext()){
            rucksackContents.add(sc.nextLine());
        }
        return rucksackContents;
    }

}
