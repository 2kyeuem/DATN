package ExecutionEngine;

import Utilities.ActionKeywords;
import Utilities.ExcelUtils;
import org.junit.Test;

public class StepsCartPage {
    @Test
    public void excute_TestCaseCart() throws Exception {

        java.lang.String sPath = System.getProperty("user.dir") + "//src//main//java//DataEngine//DataDATN1.xlsx";
        ExcelUtils.setExcelFile(sPath, "CartPage");

        for (int iRow = 1; iRow <= 54; iRow++) {
            System.out.println(iRow);
            String sActionKeyword = ExcelUtils.getCellData(iRow, 2);
            String locatorType = ExcelUtils.getCellData(iRow, 3);
            String locatorValue = ExcelUtils.getCellData(iRow, 4);
            String testData = ExcelUtils.getCellData(iRow, 5);
            switch (sActionKeyword) {
                case "openBrowser":
                    ActionKeywords.openBrowser(testData);
                    break;
                case "navigate":
                    ActionKeywords.navigate(testData);
                    break;
                case "refresh":
                    ActionKeywords.Refresh();
                    break;
                case "setText":
                    ActionKeywords.setText(locatorType, locatorValue, testData);
                    break;
                case "ScrollDownAndClick":
                    ActionKeywords.clickElementWithJs(locatorType, locatorValue);
                    break;
                case "click":
                    ActionKeywords.clickElement(locatorType, locatorValue);
                    break;
                case "verifyLabel":
                    ActionKeywords.verifyText(locatorType, locatorValue, testData);
                    break;
                case "quitBrowser":
                    ActionKeywords.quitDriver();
                    break;
                default:
                    System.out.println("[>>ERROR<<]: |Keyword Not Found " + sActionKeyword);
            }
        }
    }
}
