import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileHandler {



    public String[] readStringFromFile(String filename) {
        String[] tokens = null;
        if(!checkFilenameLength(filename) || !checkTotalFilenameLength(filename)){
            throw new IllegalArgumentException("Felaktig längd på filnamn");
        }
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();
            if(line == null){
                throw new NullPointerException("Textfilen är tom");
            }
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

    public boolean checkFilenameLength(String filename){
        return filename.length() >= 5;
    }


    public boolean checkTotalFilenameLength(String filename){
        String path = this.getClass().getClassLoader().getResource("").getPath();
        int maxLength = 260 - path.length();
        return filename.length() <= maxLength;
    }

}
