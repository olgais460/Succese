package authorization;


import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v112.performance.Performance;
import org.openqa.selenium.devtools.v112.performance.model.Metric;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

@TestInstance(Lifecycle.PER_CLASS)
public class HelloGoogle {
    private RemoteWebDriver driver;
    private ApplicationConfig config;
    private WebDriverWait wait;

    @BeforeAll

    public void configInit() {
        config = new ApplicationConfig();
    }

    @BeforeEach

    public void init() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

ChromeDriver driver1=new ChromeDriver();                                 //Создала новый экземпляр, потому что у "driver" нет  метода ".getDevTools();  "
        DevTools devTools = driver1.getDevTools();                       //Здесь выпадает ошибка "error: cannot find symbol"
        devTools.createSession();
        devTools.send(Performance.enable(Optional.empty()));


        List<Metric> metrics = devTools.send(Performance.getMetrics());
        List<String> metricNames = metrics.stream()
                .map(o -> o.getName())
                .collect(Collectors.toList());

        devTools.send(Performance.disable());

        List<String> metricsToCheck = Arrays.asList(
                "Timestamp", "Documents", "Frames", "JSEventListeners",
                "LayoutObjects", "MediaKeySessions", "Nodes",
                "Resources", "DomContentLoaded", "NavigationStart");

        metricsToCheck.forEach(metric -> System.out.println(metric +
                " is : " + metrics.get(metricNames.indexOf(metric)).getValue()));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void openGoogle() {

            driver.get(config.baseUrl);
            WebElement loginInput = driver.findElement(By.cssSelector("input[name=email]"));

            WebElement passwordInput = driver.findElement(By.cssSelector("input[name=password]"));
            WebElement submitBtn = driver.findElement(By.cssSelector("button[type=submit]"));

            loginInput.sendKeys(config.username);
            passwordInput.sendKeys(config.userPassword);
            submitBtn.click();

//    String alertText = "";
            boolean exitFlag = false;

            String alertText = wait.until(driver -> {
                Alert alert = driver.switchTo().alert();
                String text = alert.getText();
                alert.dismiss();
                return text;
            });

            Assertions.assertTrue(alertText.contains("Successful"), "Alert text doesn't contains info about successful auth");

        }


    @Test


                public void loginTestUsingPo () {
                    driver.get(config.baseUrl);
                    LoginPage loginPage = new LoginPage(driver, wait);
                    loginPage.fillLoginInput(config.username);
                    loginPage.fillPasswordInput(config.userPassword);
                    loginPage.submitForm();
                    String alertText = loginPage.getAlertText();
                    Assertions.assertTrue(alertText.contains("Successful"), "Alert text doesn't contains info about successful auth");
                    loginPage.dismissAlert();

            }

   @Test
    public void SortTest(){
       int i=0;
        int num=i++;

        driver.get(config.baseUrl);
         SortPage sortPage=new SortPage(driver,wait);
         sortPage.ddUserClick();
       driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
         sortPage.ReadAllClick();
       driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
         sortPage.btnIDClick();
         sortPage.btnIDClick();

         List<Integer>OriginArrayId=sortPage.getIntId(num );
       System.out.println(OriginArrayId);
         List<Integer>CopyArrayId=sortPage.CopyGetIntId( num);
  Collections.sort(CopyArrayId);
       Assertions.assertTrue(OriginArrayId.equals(CopyArrayId),"Сортировка не удалась");
       System.out.println("Сортировка прошла успешно!");
   }
        }
// здесь у меня в массив поппадает только одно число, вместо всех id

