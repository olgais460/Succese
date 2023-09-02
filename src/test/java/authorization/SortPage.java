package authorization;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortPage extends AbstractPage {

    private static final int FIRST_NAME_COL = 1;
    private static final int LAST_NAME_COL = 2;
    private static final int ID_COL = 0;

    @FindBy(css = "#basic-nav-dropdown")
    private WebElement ddUsers;

//    @FindBy(css = ".dropdown-item")
    @FindBy(css =("[href='#/read/users']"))
    private WebElement readAll;
    @FindBy(xpath = "//div[@id=\"root\"]/div/section/div/div/button[3]")
    private WebElement btnId;
    @FindBy(css = "td")
    private WebElement td;
    @FindBy(css = "table tbody tr")
    private List<WebElement> userRows;

    public SortPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }




    List<WebElement> ids = driver.findElements(By.cssSelector("td"));
    @Step("Нажимаем на кнопку'Users'")
    public void ddUserClick() {
        ddUsers.click();
    }
    @Step("Нажимаем на кнопку'ReadAll'")
    public void ReadAllClick() {
        readAll.click();
    }
    @Step("Нажимаем на кнопку'Id'")
    public void btnIDClick() {
        btnId.click();
    }


    private List<WebElement> getUserRowCells(int num) {
      WebElement tableRow = userRows.get(num);
        return tableRow.findElements(By.cssSelector("td")); // выбрали ячейки тз таблицы
    }

    public String getUserIdColByRowNum(int num) {
    List<WebElement> tds = getUserRowCells(num);
    return tds.get(ID_COL).getText();
}

    public List<Integer> getIntId(int num) {
        List<String> StrId = Collections.singletonList(getUserIdColByRowNum(num));
        List<Integer> IntId = new ArrayList<>();
        for (String x : StrId) {
            int z = Integer.parseInt(x);
            IntId.add(z);
        }
        return IntId;

    }

    public List<Integer> CopyGetIntId(int num) {
        List<String> CopyStrId = Collections.singletonList(getUserIdColByRowNum(num));
        List<Integer> CopyIntId = new ArrayList<>();
        for (String x : CopyStrId) {
            int z = Integer.parseInt(x);
            CopyIntId.add(z);
        }
        return CopyIntId;

    }
}

