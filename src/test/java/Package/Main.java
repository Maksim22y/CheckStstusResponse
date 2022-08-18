package Package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Main {
    public static WebDriver driver;
    @BeforeClass
    void chromeDriver() {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "\"C:\\chromedriver.exe\"");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test(dataProvider = "LoginPass",dataProviderClass = DataProviderClass.class)
        public static void main(String url) throws
            MalformedURLException, IOException {
              try {
                  HttpURLConnection c=
                (HttpURLConnection)new
                        URL(url)
                        .openConnection();
            c.setRequestMethod("HEAD");
            c.connect();
            int r = c.getResponseCode();
            System.out.println("Http response code: " + r);
        } catch (IOException e) {
            System.out.println("Http response code: " + "not 200");
        }
    }
    @BeforeClass
    void closeDriver(){
        driver.close();
    }
}