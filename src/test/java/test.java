import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class test {
    Date date = new Date();
    LocalDateTime localDateTime = LocalDateTime.now();
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Date convertToDateViaSqlTimestamp(LocalDateTime dateToConvert) {
        return java.sql.Timestamp.valueOf(dateToConvert);
    }

    @Test
    public void printTime(){

        System.out.println(localDateTime.format(dateTimeFormatter));
        date = convertToDateViaSqlTimestamp(localDateTime);
        System.out.println(date);
    }

    @Test
    public void CreateWorkbook(){

        File file = new File("/Users/marekgraca/Documents/Java-Learning/workbook.xlsx");
        FileInputStream fIP=null;

        try{
            fIP = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fIP);
            if(file.isFile() && file.exists()) {
                System.out.println("openworkbook.xlsx file open successfully.");
            } else {
                System.out.println("Error to open openworkbook.xlsx file.");
            }
        }catch (Exception e){
            e.printStackTrace();
        }





    }
}
