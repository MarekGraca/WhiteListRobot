import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FlatFile {

    public static WebDriver driver;
    private static final String mainPage = "https://www.gov.pl/web/kas/plik-plaski";
    WebDriverWait wait;

    public void initializeDriver(){
        System.setProperty("webdriver.chrome.driver","/Users/marekgraca/Documents/Java-Learning/Projects/Selenium/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,5);
    }

    public void navigateToMainPage(){
        driver.navigate().to(mainPage);
//        driver.manage().window().fullscreen();
    }
    public void closeCookies(){
        WebElement webElement = driver.findElement(By.cssSelector("button[aria-label='Akceptuję politykę dotycząca wykorzystania plików cookies. Zamknij pop-up.']"));
        webElement.click();
    }

    public void downloadFlatFileJson(){
        List<WebElement> webElementList;
        WebElement webElement;

        webElementList = wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".extension"),3));
        webElement = webElementList.get(2);
        webElement.click();
    }

}
