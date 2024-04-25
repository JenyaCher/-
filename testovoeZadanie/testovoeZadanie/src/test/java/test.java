import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {

    @Before
    public void before() {
        driver = new ChromeDriver();
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

    WebDriver driver;

    String testName = "Test Name";
    String testEmail = "TestEmail@test.com";
    String testAdressCurr = "Test Address 1";
    String testAdressPer = "Test Address 2";

    String nameResult = "//div//p[@id='name']";
    String emailResult = "//div//p[@id='email']";
    String currAdressResult = "//div//p[@id='currentAddress']";
    String perAdressResult = "//div//p[@id='permanentAddress']";

    String perAdressResuldt = "//div//p[@id='permanentAddress']";

    public void scroll(int pixiles) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("scroll(0, "+pixiles+");");
    }


    @Test
    public void Case() {

        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        scroll(50);
        driver.findElement(By.xpath("//div//h5[contains(text(),'Elements')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Text Box')]")).click();
        driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(testName);
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(testEmail);
        driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys(testAdressCurr);
        driver.findElement(By.xpath("//textarea[@id='permanentAddress']")).sendKeys(testAdressPer);
        scroll(100);
        driver.findElement(By.xpath("//button[@id='submit']")).click();

        Assert.assertTrue(driver.findElement(By.xpath(nameResult)).getText().contains(testName));
        Assert.assertTrue(driver.findElement(By.xpath(emailResult)).getText().contains(testEmail));
        Assert.assertTrue(driver.findElement(By.xpath(currAdressResult)).getText().contains(testAdressCurr));
        Assert.assertTrue(driver.findElement(By.xpath(perAdressResult)).getText().contains(testAdressPer));


    }
}
