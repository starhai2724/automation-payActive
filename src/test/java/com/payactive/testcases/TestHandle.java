package com.payactive.testcases;

import com.payactive.common.BaseTest;
import com.payactive.constants.ConstantGlobal;
import com.payactive.helpers.ExcelHelpers;
import com.payactive.helpers.PropertiesHelpers;
import com.payactive.utils.LogUtils;
import org.testng.annotations.Test;

public class TestHandle extends BaseTest {
    @Test
    public void testReadPropertiesFile() {
        PropertiesHelpers.loadAllFiles();
        System.out.println(PropertiesHelpers.getValue("browser"));
    }

    @Test
    public void testReadExcelData() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile(ConstantGlobal.TEST_DATA, "Login");
        System.out.println(excelHelpers.getCellData("EMAIL", 1));
        System.out.println(excelHelpers.getCellData("PASSWORD", 1));
    }

    @Test
    public void testLog4j2() {
        LogUtils.info("Cucumber TestNG");
    }

}
