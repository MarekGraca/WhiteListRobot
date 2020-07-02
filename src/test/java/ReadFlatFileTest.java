import org.junit.jupiter.api.Test;

import java.io.File;

class ReadFlatFileTest {



    @Test
    void readFiles() {
        GetFlatFile getFlatFile = new GetFlatFile();
        File file = getFlatFile.returnJsonFile();
        if (file!=null){
            System.out.println(file.getName());
        }
        else {
            System.out.println("Not found any file");
        }


    }

    @Test
    void deleteJSONFiles() {
        GetFlatFile getFlatFile = new GetFlatFile();
        getFlatFile.deleteJSONFiles();
    }
}