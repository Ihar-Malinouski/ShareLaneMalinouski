package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ShareLaneTests {

    @Test
    public void fillInZipCodeFieldTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.xpath("//*[@value='Continue']")).click();
        driver.findElement(By.xpath("//*[@value='Register']")).click();
        driver.quit();
    }

    /*Как неавторизованый пользователь можно заполнить все обязательные поля на странице регистрации*/
    @Test
    public void fillInAllMandatoryFieldsOfTheRegistrationPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");                            // открываем страницу в браузере
        driver.findElement(By.name("zip_code")).sendKeys("12345");                 // вводим 12345 в поле zip_code
        driver.findElement(By.xpath("//*[@value='Continue']")).click();                         // нажимаем кнопку Continue
        driver.findElement(By.name("first_name")).sendKeys("Ihar");                // в поле First Name вводим Ihar
        driver.findElement(By.name("email")).sendKeys("Malinouski@gmail.com");     // в поле Email вводим Malinouski@gmail.com
        driver.findElement(By.name("password1")).sendKeys("445566");               // в поле Password вводим 445566
        driver.findElement(By.name("password2")).sendKeys("445566");               // в поле Confirm Password вводим 445566
        driver.findElement(By.xpath("//*[@value='Register']")).click();                         // нажимаем кнопку Register
        driver.manage().deleteAllCookies();                                                     /* так как на этом ресурсе наблюдается проблема с cookies,
                                                                                                   то после каждой проверки решил чистить cookies,
                                                                                                   что немного сократит риски появления ошибок из-за
                                                                                                   конфликтов в cookies*/
        driver.quit();                                                                          // закрываем браузер
    }

    /*Как неавторизованый пользователь можно изменить невалидное значение в поле Email после неуспешной попытки регистрации*/
    @Test
    public void changingTheInvalidValueInTheEmailField() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");                            // открываем страницу в браузере
        driver.findElement(By.name("zip_code")).sendKeys("12345");                 // вводим 12345 в поле zip_code
        driver.findElement(By.xpath("//*[@value='Continue']")).click();                         // нажимаем кнопку Continue
        driver.findElement(By.name("first_name")).sendKeys("Ihar");                // в поле First Name вводим Ihar
        driver.findElement(By.name("email")).sendKeys("kkkkkk");                   // в поле Email вводим невалидное значение "kkkkkk"
        driver.findElement(By.name("password1")).sendKeys("445566");               // в поле Password вводим 445566
        driver.findElement(By.name("password2")).sendKeys("445566");               // в поле Confirm Password вводим 445566
        driver.findElement(By.xpath("//*[@value='Register']")).click();                         // нажимаем кнопку Register
        driver.findElement(By.name("email")).sendKeys("Malinouski222@gmail.com");  // в поле Email вводим Malinouski222@gmail.com
        driver.findElement(By.name("password1")).sendKeys("445566");               // в поле Password вводим 445566 (после неуспешной регистрации поле очистилось)
        driver.findElement(By.name("password2")).sendKeys("445566");               // в поле Confirm Password вводим 445566
        driver.findElement(By.xpath("//*[@value='Register']")).click();                         // нажимаем кнопку Register
        driver.manage().deleteAllCookies();                                                     /* так как на этом ресурсе наблюдается проблема с cookies,
                                                                                                   то после каждой проверки решил чистить cookies,
                                                                                                   что немного сократит риски появления ошибок из-за
                                                                                                   конфликтов в cookies*/
        driver.quit();                                                                          // закрываем браузер
    }

    /*Как неавторизованый пользователь можно найти книгу в строке поиска*/
    @Test
    public void searchForABookInTheSearchBar() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");                             // открываем страницу в браузере
        driver.findElement(By.name("keyword")).sendKeys("Mark Twain");              // в поле поиска вводим наименование "Mark Twain"
        driver.findElement(By.xpath("//*[@value='Search']")).click();                            // нажимаем кнопку Search
        driver.findElement(By.xpath("//a[@href='./main.py']")).click();                          // нажимаем на иконку ShareLane
        driver.manage().deleteAllCookies();                                                      /* так как на этом ресурсе наблюдается проблема с cookies,
                                                                                                    то после каждой проверки решил чистить cookies,
                                                                                                    что немного сократит риски появления ошибок из-за
                                                                                                    конфликтов в cookies*/
        driver.quit();                                                                            // закрываем браузер
    }

    /*Как неавторизованый пользователь есть возможность зарегестрироваться и войти под новыми учетными данными*/
    @Test
    public void registrationAndAuthorizationOfANewUser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");                            // открываем страницу в браузере
        driver.findElement(By.name("zip_code")).sendKeys("12345");                 // вводим 12345 в поле zip_code
        driver.findElement(By.xpath("//*[@value='Continue']")).click();                         // нажимаем кнопку Continue
        driver.findElement(By.name("first_name")).sendKeys("Ihar");                // в поле First Name вводим Ihar
        driver.findElement(By.name("email")).sendKeys("Malinouski@gmail.com");     // в поле Email вводим Malinouski@gmail.com
        driver.findElement(By.name("password1")).sendKeys("445566");               // в поле Password вводим 445566
        driver.findElement(By.name("password2")).sendKeys("445566");               // в поле Confirm Password вводим 445566
        driver.findElement(By.xpath("//*[@value='Register']")).click();                         // нажимаем кнопку Register
        String Email = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td" +
                "/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();                  // сохраняем полученный Email в переменную Email
        String Password = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td" +
                "/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]")).getText();                    // сохраняем полученный Password в переменную Password
        driver.findElement(By.xpath("/html/body/center/table/tbody/tr[1]/td/table/tbody" +
                "/tr/td[1]/a/img")).click();                                                    // нажимаем на иконку ShareLane
        driver.findElement(By.name("email")).sendKeys(Email);                                   // в поле Email ложим значение из переменной Email
        driver.findElement(By.name("password")).sendKeys(Password);                             // в поле Password ложим значение из переменной Password
        driver.findElement(By.xpath("/html/body/center/table/tbody/tr[3]" +
                "/td/table/tbody/tr/td[4]/a")).click();                                         // нажимаем кнопку Login
        driver.manage().deleteAllCookies();                                                     /* так как на этом ресурсе наблюдается проблема с cookies,
                                                                                                   то после каждой проверки решил чистить cookies,
                                                                                                   что немного сократит риски появления ошибок из-за
                                                                                                   конфликтов в cookies*/
        driver.quit();                                                                          // закрываем браузер

    }
}
