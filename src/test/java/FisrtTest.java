import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FisrtTest {

    static WebDriver driver;

    @BeforeAll
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Desktop\\Selenium IDE 2\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @AfterAll
    public static void tearUp(){
        driver.quit();
    }


    @Test
    public void sdaWebPageTesting(){

        driver.get("https://sdacademy.pl");

        System.out.println(driver.findElement(By.className("heading-1")).getText());
        Assertions.assertEquals("Odważ się. Dokonaj zmiany.",driver.findElement(By.className("heading-1")).getText());

    }
    /*
    1.Wejsc na strone google
    2.Wyszukac wpisujac fraze " software development academy "
    3.wejsc na strone sda
    4.spr tytul strony czy jest poprawny
     */

    @Test
    public void sdaFromGoogleTest(){
        driver.get("https://www.google.pl");
        driver.findElement(By.id("L2AGLb")).click();
        driver.findElement(By.name("q")).sendKeys("software development academy");
        driver.findElement(By.name("btnK")).submit();
        driver.findElement(By.xpath("//*[@id=\"tads\"]/div/div/div/div[1]/a")).click();
        System.out.println(driver.getTitle());
        Assertions.assertEquals("Wydarzenia - SDA Polska",driver.getTitle());


    }

    /*
            Napisz test:
        1. Wejdź na stronę logowania do poczty. poczta.wp.pl
        2. W polu 'Username' wpisz: login. -> sdatesting
        3. W polu 'Password' wpisz: hasło. -> SDAtesting123!
        4. Kliknij przycisk Login.
        5. Upewnij się, że użytkownik się zalogował.
     */

    @Test
    public void sdaFromPocztaWpTest() {
        driver.get("https://poczta.wp.pl");
        driver.findElement(By.id("login")).sendKeys("sdatesting");
        driver.findElement(By.id("password")).sendKeys("SDAtesting123!");
        driver.findElement(By.xpath("//*[@id=\"stgMain\"]/div/div/div[1]/form/button")).click();
        Assertions.assertEquals("Odebrane", driver.findElement(By.xpath("//*[@id=\"folder-1\"]/div[2]")));

    }

        /*
        Napisz test:
        1.Wejdź na sstronę: https//www.bbc.com.
        2.Wypisz w konsoli ilość dostępnych linków na stronie.
        3. Wypisz w konsoli ilość dostępnych obrazków na stronie.
            */

    @Test
    public void bbcTest(){
        driver.get("https//www.bbc.com");
        System.out.println(driver.findElements(By.tagName("a")).size());
        System.out.println(driver.findElements(By.tagName("img")).size());
    }

    }


