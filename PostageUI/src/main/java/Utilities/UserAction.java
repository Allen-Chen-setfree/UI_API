package Utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class UserAction {
    private final WebDriver driver;

    public UserAction(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver () {
        return this.driver;
    }

    public UserAction navToURL (String url) {
        driver.navigate().to(url);
        return this;
    }

    public UserAction input (By locator, String value) {
        driver.findElement(locator).sendKeys(value);
        return this;
    }

    public UserAction click (By locator) {
        driver.findElement(locator).click();
        return this;
    }

    public void hoverOn(By locator) {
        Actions actionBuilder = new Actions(driver);
        actionBuilder.moveToElement(driver.findElement(locator)).build().perform();
    }

    public String getText(By locator) {
       return driver.findElement(locator).getText();
    }

    public void scrollToElementView(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

    }

    public UserAction waitTillVisibility(By locator,int sec) {
        new WebDriverWait(driver,sec).until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this;
    }

    public void waitTillValueFilled(By locator,int sec) {

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(sec)).pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);

        wait.until((Function<WebDriver, Object>) webDriver -> !driver.findElement(locator).getText().trim().equals(""));

    }

    public void select(By locator, int index) {
        List<WebElement>  postcodes = driver.findElements(locator);
        postcodes.get(index-1).click();
    }
}
