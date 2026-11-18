package Test2;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CompletarCampos {

    private WebDriver driver;
    private JavascriptExecutor js;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        js = (JavascriptExecutor) driver;
        driver.get("https://demoqa.com/text-box");
    }

    private void pausa(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void miPrimeraPrueba() {

        pausa(2);

        driver.findElement(By.id("userName"))
                .sendKeys("Mauro Tester");

        pausa(2);

        driver.findElement(By.id("userEmail"))
                .sendKeys("mauro@test.com");

        pausa(2);

        driver.findElement(By.id("currentAddress"))
                .sendKeys("Mi dirección actual es Heredia");

        pausa(2);

        driver.findElement(By.id("permanentAddress"))
                .sendKeys("Mi dirección permanente");

        pausa(2);

        WebElement botonSubmit = driver.findElement(By.id("submit"));
        js.executeScript("arguments[0].scrollIntoView(true);", botonSubmit);

        pausa(2);

        js.executeScript("arguments[0].click();", botonSubmit);

        pausa(3);

        WebElement nameResult = driver.findElement(By.id("name"));
        assertTrue(nameResult.getText().contains("Mauro Tester"));

        System.out.println("Test ejecutado correctamente.");
    }

    @After
    public void tearDown() {
        pausa(5);
        if (driver != null) {
            driver.quit();
        }
    }
}
