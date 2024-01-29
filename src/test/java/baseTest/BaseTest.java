package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import pages.LoginPage;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    protected WebDriver webdriver;
    protected LoginPage loginPage;


    @Before
    public void setUp(){
        webdriver = initDriver();
        webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webdriver.manage().window().maximize();
        loginPage = new LoginPage(webdriver);

    }

    @After
    public void tearDown(){
        webdriver.quit();
        WebDriverManager.chromedriver().setup();
    }

    private WebDriver initDriver(){
        String browser = System.getProperty("browser");
        String location = System.getProperty("user.dir")+"/DownloadFiles";

        Map<String, Object> chromeprefs = new HashMap<String, Object>();
        chromeprefs.put("profile.default_content_settings.popups", 0);
        chromeprefs.put("download.default_directory", location);

        if ((browser == null) || "chrome".equalsIgnoreCase(browser)) {
            ChromeOptions ops = new ChromeOptions();
            ops.addArguments("--remote-allow-origins=*");
            ops.setExperimentalOption("prefs", chromeprefs);
            WebDriverManager.chromedriver().setup();
            webdriver = new ChromeDriver(ops);
        } else if ("firefox".equalsIgnoreCase(browser)) {
            WebDriverManager.firefoxdriver().setup();
            webdriver = new FirefoxDriver();
        } else if ("safari".equalsIgnoreCase(browser)) {
            WebDriverManager.safaridriver().setup();
            webdriver = new SafariDriver();
        } else if ("ie".equalsIgnoreCase(browser)) {
            WebDriverManager.iedriver().arch32().setup();
            return new InternetExplorerDriver();
        } else if ("edge".equalsIgnoreCase(browser)) {
            WebDriverManager.edgedriver().setup();
            webdriver = new EdgeDriver();
        }

        return webdriver;
    }

}
