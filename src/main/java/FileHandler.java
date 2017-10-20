import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileHandler {
    private static final int MAXIMUM_FILEPATH_LENGTH = 260;

    public String[] readStringFromFile(String filename) {
        String[] tokens = null;

        if (!isFilenameLengthValid(filename) || !isTotalFilenameLengthValid(filename)) {
            throw new IllegalArgumentException("Felaktig längd på filnamn");
        }
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();
            if (line == null) {
                throw new NullPointerException("Textfilen är tom");
            }
            tokens = line.split(",");
            br.close();
        } catch (IOException ioe) {
            tokens = new String[]{"-1"};
        }
        return tokens;
    }

    public int parseToInt(String str) {
        try {
            int i = Integer.parseInt(str);
            return i;

        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public Map createMapFromFile(String testfile) {

        String[] mapInfo = readStringFromFile(testfile);
        if (!isParametersEmpty(mapInfo)) {
            throw new IllegalArgumentException("Inkorrekta parametervärden");
        }
        int x = parseToInt(mapInfo[0]);
        int y = parseToInt(mapInfo[1]);
        int numberOfItems = parseToInt(mapInfo[2]);

        Map map = new Map(x, y, numberOfItems);
        return map;
    }

    public boolean isFilenameLengthValid(String filename) {
        return filename.length() >= 5;
    }

    public boolean isTotalFilenameLengthValid(String filename) {
        String path = this.getClass().getClassLoader().getResource("").getPath();
        int maxLength = MAXIMUM_FILEPATH_LENGTH - path.length();
        return filename.length() <= maxLength;
    }

    public boolean isParametersEmpty(String[] mapInfo) {

        if (mapInfo[0].length() < 1 || mapInfo[1].length() < 1 || mapInfo[2].length() < 1) {
            return false;
        }
        return true;
    }
}
