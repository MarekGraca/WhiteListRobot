public class Main {

    public static void main(String[] args) {
        String nipNumber = "9222834354";


        WhiteList whiteList = new WhiteList();
        whiteList.initializeDriver();
        whiteList.navigateToMainPage();
        whiteList.clickNipCheckbox();
        whiteList.typeNipNumber(nipNumber);
        whiteList.clickSearchButton();




        whiteList.quitDriver();

    }
}
