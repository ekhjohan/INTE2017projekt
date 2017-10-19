import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileHandler {



    public String[] readStringFromFile(String filename) {
        String[] tokens = null;

        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();
            tokens = line.split(",");
            br.close();
        } catch (IOException ioe) {

        }
        return tokens;
    }

    public Map createMapFromFile(String testfile){

        String[] mapInfo = readStringFromFile(testfile);
        int x = Integer.parseInt(mapInfo[0]);
        int y = Integer.parseInt(mapInfo[1]);
        int numberOfItems = Integer.parseInt(mapInfo[2]);

        Map map = new Map(x, y, numberOfItems);
        return map;
    }


}
