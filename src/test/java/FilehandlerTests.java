import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;


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



}
