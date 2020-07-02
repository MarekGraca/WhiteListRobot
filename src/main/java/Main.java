import java.io.File;

public class Main {

    public static void main(String[] args) {

        String nipNumber = "9222834354";
        Contractor contractor = null;//

        WhiteList whiteList = new WhiteList();
        whiteList.initializeDriver();
        whiteList.navigateToMainPage();

        whiteList.clickNipCheckbox();
        whiteList.typeNipNumber(nipNumber);
        whiteList.clickSearchButton();
        contractor = whiteList.getContractor();
        System.out.println("contractor name = " + contractor.getName() + ", status: "  + contractor.getStatus() + ", accountNumber: " + contractor.getAccountNumber());
        whiteList.navigateToMainPage();
        whiteList.quitDriver();

        GetFlatFile getFlatFile = new GetFlatFile();
        getFlatFile.deleteJSONFiles();

        FlatFile flatFile = new FlatFile();
        flatFile.initializeDriver();
        flatFile.navigateToMainPage();
        flatFile.closeCookies();
        flatFile.downloadFlatFileJson();


        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }


        File jsonFile = getFlatFile.returnJsonFile();

        if (jsonFile!=null){
            System.out.println(jsonFile.getAbsolutePath());
        }
        else {
            System.out.println("No files in directory");
        }

        flatFile.quitDriver();

    }
}
