import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WhiteListTest {
    public static final String whiteListPage = "https://www.podatki.gov.pl/wykaz-podatnikow-vat-wyszukiwarka";
    public static WebDriver driver;
    WhiteList bialaLista;

    @BeforeEach
    public void driverSetup() {
        bialaLista = new WhiteList();
        bialaLista.initializeDriver();
        bialaLista.navigateToMainPage();
    }
    @AfterEach
    public void driverQuit(){
        bialaLista.quitDriver();
    }

    @Test
    public void NavigateToWebpage() {
        String validateURL;
        String pageSource;
        driver.navigate().to(whiteListPage);
        validateURL = driver.getCurrentUrl();
        Assertions.assertEquals(whiteListPage,validateURL,"Url : " + whiteListPage + " than: " + validateURL);
        pageSource = getPageSource(driver);
        System.out.println(pageSource);
    }


    public String getPageSource(WebDriver driver){
        String pageSource;
        pageSource = driver.getPageSource();
        return pageSource;

    }

    @Test
    public void findElement(){
        String validateURL;
        String pageSource;
        driver.navigate().to(whiteListPage);
        WebElement webElement = driver.findElement(By.id("sendTwo"));
        System.out.println(webElement);
        System.out.println(webElement.getAttribute("class"));
    }

    @Test
     public void testTypeNip(){
        System.out.println("Now called test method");
            bialaLista.typeNipNumber("44456");
            try
            {Thread.sleep(3000);}
            catch (Exception e){
                e.printStackTrace();
            }
     }
     @Test
     public void testElements(){
         bialaLista.getElementsByCssSelector("input#inputType.input-form");
         try {
             Thread.sleep(3000);
         }catch (Exception e){
             e.printStackTrace();
         }
     }
     @Test
    public void testClickNipELement(){
        bialaLista.clickNipCheckbox();
         try {
             Thread.sleep(3000);
         }catch (Exception e){
             e.printStackTrace();
         }
     }
     @Test
    public void testClickSearchButton(){
        bialaLista.clickSearchButton();
     }


}




