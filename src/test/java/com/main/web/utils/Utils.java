package com.main.web.utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Utils {
    public static WebDriver getDriver(String browser) {
        
    /* options.addArguments(
        "--headless=new",
        "--disable-gpu",
        "--no-sandbox",
        "--disable-dev-shm-usage",
        "--window-size=1920,1080"
    ); */

        switch (browser) {
            case Constant.CHROME -> {
                ChromeOptions options = new ChromeOptions();
                options.addArguments(
                        "--no-sandbox",
                        "--window-size=1920,1080"
                );
                return new ChromeDriver(options);
            }
            case Constant.FIREFOX -> {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments(
                        "--no-sandbox",
                        "--window-size=1920,1080"
                );
                return new FirefoxDriver(options);
            }
            default -> throw new IllegalArgumentException(Constant.BROWSER_NOT_SUPPORTED + browser);
        }
    }

    public static void openUrlChrome(String url) {
        WebDriver driver = getDriver(Constant.CHROME);
        driver.get(url);
    }

    public static void openUrlFirefox(String url) {
        WebDriver driver = getDriver(Constant.FIREFOX);
        driver.get(url);
    }

    public static void closeDriver(WebDriver driver) {
        if (driver != null) {
            driver.quit();
        }
    }
}
