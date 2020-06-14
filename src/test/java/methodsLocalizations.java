import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class methodsLocalizations {

    WebDriver driver;

    @BeforeEach
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver","/Users/marekgraca/Documents/Java-Learning/Projects/Selenium/chromedriver");

        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
    }
    @AfterEach
     public void driverQuit(){
        driver.quit();
    }

    @Test

    public void NavigateToWebpage() {

        driver.navigate().to("google.pl");
    }

//    @Test
//    public void getElements(){
//        driver.navigate().to("https://pl.wikipedia.org/wiki/Wikipedia:Strona_g%C5%82%C3%B3wna");
//        driver.findElement(By.id("searchInput"));
//        driver.findElement(By.className("searchButton"));
//        driver.findElement(By.name("search"));
//
//        List<WebElement> webElements = driver.findElements(By.className("external"));
//        System.out.println("Found "+webElements.size()+" elements with class");
//
//        WebElement webelementsWithTwoClasses = null;
//
//        for (WebElement webelement: webElements){
//            String classNameElement = webelement.getAttribute("class");
//            System.out.println(classNameElement);
//            if (classNameElement.equals("external text")){
//                webelementsWithTwoClasses=webelement;
//            }
//        }
//
//        Assertions.assertTrue(webelementsWithTwoClasses==null, "Not found element");
//
//    }
//
//    @Test
//    public void findElementByLink(){
//        driver.navigate().to("https://pl.wikipedia.org/wiki/Wikipedia:Strona_g%C5%82%C3%B3wna");
//        driver.findElement(By.linkText("Pomniki przyrody w Raciborzu"));
//        driver.findElement(By.partialLinkText("Pomniki przyrody"));
//    }







}
