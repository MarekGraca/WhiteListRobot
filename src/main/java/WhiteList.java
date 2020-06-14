import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WhiteList {

    public static final String whiteListPage = "https://www.podatki.gov.pl/wykaz-podatnikow-vat-wyszukiwarka";
    public static WebDriver driver;
    private String mainPage = "https://www.podatki.gov.pl/wykaz-podatnikow-vat-wyszukiwarka";

    public void initializeDriver(){
        System.setProperty("webdriver.chrome.driver","/Users/marekgraca/Documents/Java-Learning/Projects/Selenium/chromedriver");
        driver = new ChromeDriver();
    }

    public void navigateToMainPage(){
       driver.manage().window().maximize();
       driver.navigate().to(mainPage);
    }

    public void quitDriver(){
        driver.close();
        driver.quit();
    }

    public String findElementById(String id, String attribute){
        String Attribute;
        driver.navigate().to(whiteListPage);
        WebElement webElement = driver.findElement(By.id(id));
        Attribute = webElement.getAttribute(attribute);
        return Attribute;
    }

    public List<WebElement> getElementsByClassName(String classname){
        List<WebElement> webElements = driver.findElements(By.className(classname));
        System.out.println("Found "+webElements.size()+" elements with class " + classname);

        WebElement webelementsWithTwoClasses = null;

        for (WebElement webelement: webElements){
            System.out.println(webelement.getClass());
        }
        return  webElements;
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
            webElement.sendKeys(nipNumber);
            Thread.sleep(500);
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
            webElement = driver.findElement(By.cssSelector("[id='sendTwo']"));
            webElement.click();
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }

    }




}
