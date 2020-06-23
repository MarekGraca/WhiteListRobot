public class Main {

    public static void main(String[] args) {
        String nipNumber = "9222834354";
        Contractor contractor = null;
        FlatFile flatFile = new FlatFile();



        WhiteList whiteList = new WhiteList();
        whiteList.initializeDriver();
        whiteList.navigateToMainPage();

        whiteList.clickNipCheckbox();
        whiteList.typeNipNumber(nipNumber);
        whiteList.clickSearchButton();
        contractor = whiteList.getContractor();
        System.out.println("contractor name = " + contractor.getName() + ", status: "  + contractor.getStatus() + ", accountNumber: " + contractor.getAccountNumber());
        whiteList.navigateToMainPage();





//        whiteList.quitDriver();

    }
}
