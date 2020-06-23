import org.junit.jupiter.api.Test;

class FlatFileTest {

    @Test
    void navigateToMainPage() {
        FlatFile flatFile = new FlatFile();
        flatFile.initializeDriver();
        flatFile.navigateToMainPage();
        flatFile.closeCookies();

    }

    @Test
    void downloadFlatFileJson() {
        FlatFile flatFile = new FlatFile();
        flatFile.initializeDriver();
        flatFile.navigateToMainPage();
        flatFile.closeCookies();
        flatFile.downloadFlatFileJson();

    }


}