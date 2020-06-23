import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WhiteList {

    public static WebDriver driver;
    private static final String mainPage = "https://www.podatki.gov.pl/wykaz-podatnikow-vat-wyszukiwarka";
    WebDriverWait wait;

    public void initializeDriver(){
        System.setProperty("webdriver.chrome.driver","/Users/marekgraca/Documents/Java-Learning/Projects/Selenium/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,5);
    }

    public void navigateToMainPage(){
        driver.navigate().to(mainPage);
        driver.manage().window().fullscreen();
    }


    public void quitDriver(){
        driver.close();
        driver.quit();
    }

    public List<WebElement> getElementsByCssSelector(String cssSelector){
        List<WebElement> webElements = driver.findElements(By.cssSelector(cssSelector));
        System.out.println("Found "+webElements.size()+" elements");

        for (WebElement webelement: webElements){
            System.out.println(webelement.getClass());
        }
        return  webElements;
    }

    public void typeNipNumber(String nipNumber){
        WebElement webElement;
        try {
            webElement = driver.findElement(By.cssSelector("input#inputType.input-form"));
            wait.until(ExpectedConditions.attributeToBe(webElement, "placeholder", "Wpisz numer nip"));
            webElement.sendKeys(nipNumber);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void clickNipCheckbox(){
        List<WebElement> webElementList;
        WebElement webElement;

        try {
            webElementList = driver.findElements(By.cssSelector("span.control-label"));
            webElement = webElementList.get(1);
            webElement.click();
            Thread.sleep(500);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void clickSearchButton(){
        WebElement webElement;

        try {
            webElement = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("[id='sendTwo']"))));
            webElement.click();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Contractor getContractor(){
        List<WebElement> contractorAttributes;
        String attribute;
        Contractor contractor =null;

        contractorAttributes = wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".twosecond"),16));
        System.out.println("contractorAttributes size: " + contractorAttributes.size());
        contractor = new Contractor(contractorAttributes.get(0).getAttribute("innerText"),contractorAttributes.get(3).getAttribute("innerText"),(contractorAttributes.get(11).getAttribute("innerText").replace(" ","")));

        return contractor;
    }




}
