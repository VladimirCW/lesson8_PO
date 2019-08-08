package test.java.Utils;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Screenshot {
    private WebDriver driver;

    public Screenshot(WebDriver driver) {
        this.driver = driver;
    }


    public String makeScreenShot(ITestResult result) {
        //getScreenshot();
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        Path currentRelativePath = Paths.get("");
        try {
            FileUtils.copyFile(src, new File(
                    currentRelativePath.toAbsolutePath().toString()
                            + "\\screenshots\\"
                            + result.getTestClass().getName().replace(".", "\\\\")
                            + "\\" + result.getMethod().getConstructorOrMethod().getName() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return src.toString();
    }

    @Attachment
    public byte[] getScreenshot() {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        return screenshot.getScreenshotAs(OutputType.BYTES);
    }
}