package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.ChromeDriverManager;


public class Tester {

    public static void main(String[] args) {
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "\"D:\\User\\Tiedostot\\GitHub\\OhTu\\Viikko4\\WebLogin\\chromedriver.exe\""); 


        driver.get("http://localhost:4567");
        
        sleep(2);
        
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka22");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep2");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("akkep2");
        element = driver.findElement(By.name("signup"));

        sleep(2);
        element.submit();
        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        sleep(1);
        element = driver.findElement(By.linkText("logout"));
        element.click();

        sleep(3);
        
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
