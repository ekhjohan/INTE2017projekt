import org.junit.Test;

import static org.junit.Assert.*;


public class FilehandlerTests {

    @Test
    public void readFromFile() {
        FileHandler fileHandler = new FileHandler();
        String content = "1005010";
        String[] textLista = fileHandler.readStringFromFile("testfile.txt");

        String fileContent = "";
        for (String str : textLista) {
            fileContent += str;
        }
        assertEquals(content, fileContent);
    }

    @Test
    public void createMapFromFile() {
        FileHandler fileHandler = new FileHandler();
        Map newMap = fileHandler.createMapFromFile("testfile.txt");
        Map tempMap = new Map(100, 50, 10);
        assertEquals(newMap, tempMap);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createMapFromFileHeightAndWithTooLow() {
        FileHandler fileHandler = new FileHandler();
        Map newMap = fileHandler.createMapFromFile("widthAndHeightTooLow.txt");
    }

    @Test(expected = IllegalArgumentException.class)
    public void createMapFromFileTotalItemsOnMapTooLow() {
        FileHandler fileHandler = new FileHandler();
        Map newMap = fileHandler.createMapFromFile("totalNumberOfItemsTooLow.txt");
    }

    @Test
    public void fileNotExist() {
        FileHandler fileHandler = new FileHandler();
        String[] fileNotFound = fileHandler.readStringFromFile("fileNotExists.txt");
        assertEquals("-1", fileNotFound[0]);
    }

    @Test
    public void methodTotalFilenameIsTooLong() {
        //+216 tecken, inkl. filändelse .txt.
        FileHandler fileHandler = new FileHandler();
        boolean isValid = fileHandler.isTotalFilepathLengthValid("asadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdaasdasdsadasdasdasd");
        assertFalse(isValid);
    }

    @Test(expected = IllegalArgumentException.class)
    public void totalFilenameIsTooLong() {
        //+216 tecken, inkl. filändelse .txt.
        FileHandler fileHandler = new FileHandler();
        fileHandler.readStringFromFile("asadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdaasdasdsadasdasdasd");
    }

    @Test(expected = IllegalArgumentException.class)
    public void filenameIsTooLong() {
        //+216 tecken, inkl. filändelse .txt.
        FileHandler fileHandler = new FileHandler();
        fileHandler.readStringFromFile("asadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdaasdasdsadasdasdasd");
    }

    @Test(expected = IllegalArgumentException.class)
    public void filenameTooShort() {
        //färre än 5 tecken, inkl filändelse .txt.
        FileHandler fileHandler = new FileHandler();
        fileHandler.readStringFromFile("a");
    }

    @Test(expected = NullPointerException.class)
    public void fileContentEmpty() {
        FileHandler fileHandler = new FileHandler();
        fileHandler.readStringFromFile("emptyFile.txt");
    }

    @Test
    public void invalidParameterFormat() {
        FileHandler fileHandler = new FileHandler();
        String[] fileContent = fileHandler.readStringFromFile("fileWithIncorrectParameters.txt");
        int value = fileHandler.parseToInt(fileContent[0]);
        assertEquals(-1, value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyParameterFileReader() {
        String filename = "emptyParameter.txt";
        FileHandler fileHandler = new FileHandler();
        fileHandler.createMapFromFile(filename);
    }
}