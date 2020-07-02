import org.apache.commons.io.FileUtils;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;


public class GetFlatFile {

    public static final String downloadPath = "/Users/marekgraca/downloads/";
    public static final String [] arrayOfExtension = {"json"};


    public File returnJsonFile(){
        File myDir = new File(downloadPath);
        File file = null;
        LocalDateTime localDateTime = LocalDateTime.now();
        Date date = convertToDateViaSqlTimestamp(localDateTime);


        Collection<File> files = FileUtils.listFiles(myDir,arrayOfExtension, false);
        if (files.size()>1){
            System.out.println("More tham one file in dir. Possibly wrong file");
        }
        if (files.isEmpty()){
            return null;
        }
        for (File fileIt: files){
            file = fileIt;
            break;
        }
        return file;

    }

    public void deleteJSONFiles(){
        File myDir = new File(downloadPath);
        Collection<File> files = FileUtils.listFiles(myDir,arrayOfExtension, false);

        for (File fileIt : files){
            fileIt.delete();
        }
    }

    public void copyFile(){
        FileUtils fileUtils = new FileUtils();
    }

    public Date convertToDateViaSqlTimestamp(LocalDateTime dateToConvert) {
        return java.sql.Timestamp.valueOf(dateToConvert);
    }




}
