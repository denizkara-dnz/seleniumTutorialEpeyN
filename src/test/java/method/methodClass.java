package method;

import objectrepo.objectRepo;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import testAutomation.test;

import java.util.List;

public class methodClass extends test {
    public methodClass(WebDriver driver) {
        this.driver = driver;
    }


    @BeforeMethod
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "C:\\seleniumTutorialEpeyN\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }

    public methodClass openPage() {
        driver.get("https://epey.com");
        return this;
    }

    public methodClass clickLoginButton() {
        click(objectRepo.loginButton);
        return this;
    }

    public methodClass click(By cl) {
        driver.findElement(cl).click();
        return this;
    }

    public methodClass sendKeys(By send, String value) {
        driver.findElement(send).sendKeys(value);
        return this;
    }

    public methodClass sleep(int value) throws InterruptedException {
        Thread.sleep(value);
        return this;
    }

    public methodClass loginDemo() throws InterruptedException {
        sendKeys(objectRepo.loginEmail, "cgty.dk@gmail.com");
        sendKeys(objectRepo.loginPassword, "123456789a");
        click(objectRepo.loginUser);
        sleep(5000);
        return this;
    }

    public methodClass controlUser(String value) throws InterruptedException {
        controlMethod(value, objectRepo.controlUser);
        return this;
    }

    public methodClass controlMethod(String value, By elementName) {
        boolean durum = false;
        WebElement element = driver.findElement(elementName);
        element.getText();
        /*if (element.getText().contains(value)) {
            durum = true;
        }
        Assert.assertTrue(durum);*/
        Assert.assertEquals(element.getText(), value);
        info("Değer dogru dönmüştür: " + element.getText() + " iki değerde doğrulanmıştır...");
        return this;
    }

    public methodClass info(String value) {
        System.out.println(value);
        return this;
    }

    public methodClass search(String value) throws InterruptedException {
        sendKeys(objectRepo.search, value);
        click(objectRepo.searchTo);
        List<WebElement> elementList = driver.findElements(By.cssSelector("[class='metin row']"));
        for (int i = 0; i < elementList.size(); i++) {
            if (elementList.get(i).getText().contains(value)) {
                String id = elementList.get(i).getAttribute("id");
                sleep(2000);
                click(By.cssSelector("[class='kiyasla kiyasla" + id + "']"));
                break;
            }
        }
        sleep(2000);
        return this;
    }

    public methodClass comparison(String value) throws InterruptedException {
        List<WebElement> elementList = driver.findElements(By.cssSelector("[class='button']"));
        for (int i = 0; i < elementList.size(); i++) {
            if (elementList.get(i).getText().contains(value)) {
                elementList.get(i).click();
                break;
            }
        }
        return this;
    }

    public void wdown(int x, int y) throws InterruptedException {
        sleep(2000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy('" + x + "','" + y + "')", "");
    }

    public String getPuan(int i) {
        List<WebElement> elementList = driver.findElements(By.cssSelector("[class='circle-text']"));
        return elementList.get(i).getText();
    }

    public methodClass round(String value) {
        List<WebElement> elementList = driver.findElements(By.cssSelector("[class='rounded-list'] li"));
        for (int i = 0; i < elementList.size(); i++) {
            if (elementList.get(i).getText().contains(value)) {
                elementList.get(i).click();
                break;
            }
        }
        return this;
    }

    public methodClass compare(String name1, String phone1, String name2, String phone2) {
        int a = Integer.parseInt(name1);
        int b = Integer.parseInt(name2);
        if (a > b) {
            info(phone1 + " büyüktür " + phone2);
        } else {
            info(phone2 + " büyüktür " + phone1);
        }
        return this;
    }

    public methodClass moveToElement(WebElement value) {
        Actions actions = new Actions(driver);
        actions.moveToElement(value);
        actions.release().perform();
        return this;
    }

    public methodClass hoverMenu(String value) throws InterruptedException {
        List<WebElement> elementList = driver.findElements(By.cssSelector("[class='s1']"));
        for (int i = 0; i < elementList.size(); i++) {
            if (elementList.get(i).getText().contains(value)) {
                moveToElement(elementList.get(i));
                break;
            }
        }
        return this;
    }

    public methodClass clickMenuOption(String value) {
        WebElement element = driver.findElement(By.cssSelector("[title='" + value + "']"));
        element.click();
        //click(By.cssSelector("[title='"+value+"']"));
        return this;
    }

    public methodClass timeLineBarDrag(String value, int x, int y) {
        if (value == "1") {
            WebElement element = driver.findElement(By.cssSelector("[class='irs js-irs-" + value + "'] [class='irs-slider to type_last']"));
            moveToElement(element);
            dragAndDrop(element, x, y);
        } else {
            WebElement element = driver.findElement(By.cssSelector("[class='irs js-irs-" + value + "'] [class='irs-slider to']"));
            moveToElement(element);
            dragAndDrop(element, x, y);
        }
        return this;
    }

    public methodClass dragAndDrop(WebElement From, int x, int y) {
        Actions act = new Actions(driver);
        act.dragAndDropBy(From, x, y).build().perform();
        return this;
    }
}