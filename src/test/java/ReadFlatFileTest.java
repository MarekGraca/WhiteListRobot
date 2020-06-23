import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class ReadFlatFileTest {



    @Test
    void readFiles() {
        ReadFlatFile readFlatFile = new ReadFlatFile();
        File file = readFlatFile.returnJsonFile();
        if (file!=null){
            System.out.println(file.getName());
        }
        else {
            System.out.println("Not found any file");
        }


    }

    @Test
    void deleteJSONFiles() {
        ReadFlatFile readFlatFile = new ReadFlatFile();
        readFlatFile.deleteJSONFiles();
    }
}