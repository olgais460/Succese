
package authorization;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage {

    @FindBy(css = "input[name=email]")
    private WebElement loginInput;

    @FindBy(css = "input[name=password]")
    private WebElement passwordInput;

    @FindBy(css = "button[type=submit]")
    private WebElement submitBtn;



    public LoginPage(WebDriver driver, WebDriverWait wait) {
//    loginInput = driver.findElement(By.cssSelector("input[name=email]"));
//    passwordInput = driver.findElement(By.cssSelector("input[name=password]"));
//    submitBtn = driver.findElement(By.cssSelector("button[type=submit]"));
        super(driver, wait);
    }
    @Step ("find Alert")
    private Alert findAlert() {
        return wait.until(drv -> drv.switchTo().alert());
    }
    @Step("fill login")
    public void fillLoginInput(String text) {
        loginInput.clear();
        loginInput.sendKeys(text);
    }
    @Step("fill password")

    public void fillPasswordInput(String text) {
        passwordInput.clear();
        passwordInput.sendKeys(text);
    }

    public void submitForm() {
        submitBtn.click();
    }

    public String getAlertText() {
        return findAlert().getText();
    }

    public void dismissAlert() {
        findAlert().dismiss();
    }

    @Deprecated
    public String getAlertTextThenDismiss() {
        return wait.until(drv -> {
            Alert alert = drv.switchTo().alert();
            String text = alert.getText();
            alert.dismiss();
            return text;
        });
    }
}

