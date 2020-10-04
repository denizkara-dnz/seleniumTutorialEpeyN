package testAutomation;


import method.methodClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class test {

    public WebDriver driver;


    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ILBER ORTAYLI\\Desktop\\drivers\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }


//   @AfterSuite
//    public void quit (){
//        driver.quit();
//   }

    @Test
    public void test1() throws InterruptedException {
        methodClass methodClass = new methodClass(driver);
        String huawei = "Huawei P40 Pro";
        String xiaomi = "Xiaomi Mi 10";
        methodClass
                .openPage()
                .clickLoginButton()
                .loginDemo()
                .controlUser("Çağatay D.")
                .search(xiaomi)
                .search(huawei)
                .comparison("Seçilenleri Karşılaştır");
        //.wdown(0,1200)
        String name1 = methodClass.getPuan(0);
        String name2 = methodClass.getPuan(1);
        methodClass
                .compare(name1, huawei, name2, xiaomi)
                .hoverMenu("TELEFON")
                .clickMenuOption("Samsung Telefon Fiyatları")
                .comparison("Temizle")
                .timeLineBarDrag("1",-25,0)

        ;
    }

    @Test
    public void test2() throws InstantiationException {
        methodClass methodClass = new methodClass(driver);
        methodClass
                .openPage()
                .round("Fırsat Ürünler")


        ;

    }

}
