import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileHandler {
    private static final int MAXIMUM_FILEPATH_LENGTH = 260;
    private static final int MINIMUM_FILENAME_LENGTH = 5;

    public String[] readStringFromFile(String filename) {
        String[] parameters = null;

        if (!isFilenameLengthValid(filename) || !isTotalFilepathLengthValid(filename)) {
            throw new IllegalArgumentException("Felaktig längd på filnamn");
        }
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            if (line == null) {
                throw new NullPointerException("Textfilen är tom");
            }
            parameters = line.split(",");
            bufferedReader.close();
        } catch (IOException ioe) {
            parameters = new String[]{"-1"};
        }
        return parameters;
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

    private boolean isFilenameLengthValid(String filename) {
        return filename.length() >= MINIMUM_FILENAME_LENGTH;
    }

    public boolean isTotalFilepathLengthValid(String filename) {
        String path = this.getClass().getClassLoader().getResource("").getPath();
        int maxLength = MAXIMUM_FILEPATH_LENGTH - path.length();
        return filename.length() <= maxLength;
    }

    private boolean isParametersEmpty(String[] mapInfo) {

        if (mapInfo[0].length() < 1 || mapInfo[1].length() < 1 || mapInfo[2].length() < 1) {
            return false;
        }
        return true;
    }
}