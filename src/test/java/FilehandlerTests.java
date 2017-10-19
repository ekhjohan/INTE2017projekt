import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;


public class FilehandlerTests {

    @Test
    public void readFromFile() {
        FileHandler fileHandler = new FileHandler();
        String content = "100,50,10,";
        String[] textLista = fileHandler.readStringFromFile("testfile.txt");
        String fileContent = "";
        for(String str : textLista){
            fileContent += str + ",";
        }
        assertEquals(content, fileContent);
    }

    @Test
    public void createMapFromFile(){
        FileHandler fileHandler = new FileHandler();
        Map newMap = fileHandler.createMapFromFile("testfile.txt");
        Map tempMap = new Map(100,50,10);
        assertEquals(newMap, tempMap);
    }

    @Test
    public void fileExists(){
        File file = new File("testfile.txt");
        assertTrue(file.exists());

    }
    @Test
    public void fileNotExist(){
        File file = new File("fileNotExist.txt");
        assertFalse(file.exists());
    }
    @Test(expected = IllegalArgumentException.class)
    public void filenameIsTooLong(){
        //+216 tecken
        FileHandler fileHandler = new FileHandler();
        fileHandler.readStringFromFile("asadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasdasadasdasdasd");

    }
    @Test(expected = IllegalArgumentException.class)
    public void filenameTooShort(){
        //färre än 5 tecken, ink filndelse.
        FileHandler fileHandler = new FileHandler();
        fileHandler.readStringFromFile("a");
    }
    @Test(expected = NullPointerException.class)
    public void fileContentEmpty(){
        FileHandler fileHandler = new FileHandler();
        String[] fileContent = fileHandler.readStringFromFile("emptyFile.txt");
    }
    @Test(expected = NumberFormatException .class)
    public void invalidParameterFormat(){
        FileHandler fileHandler = new FileHandler();
        String[] fileContent = fileHandler.readStringFromFile("fileWithIncorrectParameters.txt");
        Integer.parseInt(fileContent[0]);

    }

}
