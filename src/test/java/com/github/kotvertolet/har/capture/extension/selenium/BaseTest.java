package com.github.kotvertolet.har.capture.extension.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    public ChromeDriver driver;
    private static final ChromeOptions chromeOptions;
    static {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
    }

    @RegisterExtension
    static HarCaptureExtension harCaptureExtension = HarCaptureExtension.builder()
            .addCapabilities(chromeOptions).build();

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver(chromeOptions);
    }

    @AfterEach
    public void dispose() {
        driver.quit();
    }
}
