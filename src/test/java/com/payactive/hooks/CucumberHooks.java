package com.payactive.hooks;

import com.payactive.common.DataCommon;
import com.payactive.constants.ConstantGlobal;
import com.payactive.driver.DriverManager;
import com.payactive.helpers.ExcelHelpers;
import com.payactive.helpers.PropertiesHelpers;
import com.payactive.models.Credentials;
import io.cucumber.java.*;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.List;

import static com.payactive.common.BaseTest.closeDriver;

public class CucumberHooks {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("================ beforeAll ================");
        PropertiesHelpers.loadAllFiles();
        loadUser();
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("================ afterAll ================");
//        DriverManager.quit();
        closeDriver();
    }

    @Before
    public void beforeScenario() {
        System.out.println("================ beforeScenario ================");
        //BaseTest.createDriver();
        //Record video
    }

    @After
    public void afterScenario(Scenario scenario) {
        System.out.println("================ afterScenario ================");
        DriverManager.quit();
    }

    @BeforeStep
    public void beforeStep(Scenario scenario) {
        System.out.println("================ beforeStep ================");
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        System.out.println("================ afterStep ================");
        //validate if scenario has failed then Screenshot
//        if (scenario.isFailed()) {
//            CaptureHelpers.takeScreenshot(scenario.getName());
//        }

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot Failed");
        }
    }


    private static void loadUser() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile(ConstantGlobal.TEST_DATA, "Login");
        Credentials credentials = new Credentials();
        credentials.setUsername(excelHelpers.getCellData("USERNAME", 1));
        credentials.setPassword(excelHelpers.getCellData("PASSWORD", 1));
        DataCommon.credentialsList.add(credentials);
    }
}
