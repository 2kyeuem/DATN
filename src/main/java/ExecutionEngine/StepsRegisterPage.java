package ExecutionEngine;
import Utilities.ActionKeywords;
import Utilities.ExcelUtils;
import Utilities.Log;
import org.junit.Test;

public class StepsRegisterPage{
    @Test
    public void excute_TestCaseDangNhap() throws Exception {
        //Làm việc với file excel đã import
        String   sPath = System.getProperty("user.dir") + "//src//main//java//DataEngine//DataDATN1.xlsx";
        //làm việc với sheet LoginPage trong file excel
        ExcelUtils.setExcelFile(sPath, "RegisterPage");
        int CasePass=0;
        int CaseFail=0;
        int CaseSkip=0;
        int row = ExcelUtils.getRowCount("RegisterPage");
//        for (int iRow=120;iRow<=188;iRow++)
//        {
//            String Description = ExcelUtils.getCellData(iRow, 1);
//            String sActionKeyword = ExcelUtils.getCellData(iRow, 2);
//            String locatorType = ExcelUtils.getCellData(iRow, 3);
//            String locatorValue = ExcelUtils.getCellData(iRow, 4);
//            String testData = ExcelUtils.getCellData(iRow, 5);
//            String CaseName = ExcelUtils.getCellData(iRow, 0);

        for (int i = 1; i < row; i++) {
            System.out.println("Line:" + i);
            String Description = ExcelUtils.getCellData(i, 1);
            String sActionKeyword = ExcelUtils.getCellData(i, 2);
            String locatorType = ExcelUtils.getCellData(i, 3);
            String locatorValue = ExcelUtils.getCellData(i, 4);
            String testData = ExcelUtils.getCellData(i, 5);
            String CaseName = ExcelUtils.getCellData(i, 0);
            switch (sActionKeyword) {
                case "openBrowser":
                    if (CaseName != null) {
                        Log.info("--------------Thực thi Test Case ID: " + CaseName + "--------------");
                    }
                    ActionKeywords.openBrowser(testData);
                    break;
                case "move":
                    ActionKeywords.ElementPerfom(locatorValue);
                    break;
                case "navigate":
                    ActionKeywords.navigate(testData);
                    break;
                case "setText":
                    ActionKeywords.setText(locatorType, locatorValue, testData);
                    break;
                case "click":
                    ActionKeywords.clickElement(locatorType, locatorValue);
                    break;
                case "verifyAlertfistname":
                    if (ActionKeywords.verifyAlertfistname(testData)) {
                        Log.info("Same result ---> pass");
                        CasePass++;
                    } else {
                        Log.error("Different result ---> Fail");
                        CaseFail++;
                    }
                    break;
                case "verifyAlertemail":
                    if (ActionKeywords.verifyAlertemail(testData)) {
                        Log.info("Same result ---> pass");
                        CasePass++;
                    } else {
                        Log.error("Different result ---> Fail");
                        CaseFail++;
                    }
                    break;
                case "verifyAlertlastname":
                    if (ActionKeywords.verifyAlertlastname(testData)) {
                        Log.info("Same result ---> pass");
                        CasePass++;
                    } else {
                        Log.error("Different result ---> Fail");
                        CaseFail++;
                    }
                    break;
                case "verifyAlertsdt":
                    if (ActionKeywords.verifyAlertsdt(testData)) {
                        Log.info("Same result ---> pass");
                        CasePass++;
                    } else {
                        Log.error("Different result ---> Fail");
                        CaseFail++;
                    }
                    break;
                case "verifyAlertPasswordofRegisterpage":
                    if (ActionKeywords.verifyAlertPasswordofRegisterpage(testData)) {
                        Log.info("Same result ---> pass");
                        CasePass++;
                    } else {
                        Log.error("Different result ---> Fail");
                        CaseFail++;
                    }
                    break;
                case "verifyAlertdatefield":
                    if (ActionKeywords.verifyAlertdatefield(testData)) {
                        Log.info("Same result ---> pass");
                        CasePass++;
                    } else {
                        Log.error("Different result ---> Fail");
                        CaseFail++;
                    }
                    break;
                case "verifyAlertcheckbox":
                    if (ActionKeywords.verifyAlertcheckbox(testData)) {
                        Log.info("Same result ---> pass");
                        CasePass++;
                    } else {
                        Log.error("Different result ---> Fail");
                        CaseFail++;
                    }
                    break;
                case "verifyelementtext":
                    if (ActionKeywords.verifyText(locatorType, locatorValue, testData)) {
                        Log.info("Same result ---> pass");
                        CasePass++;
                    } else {
                        Log.error("Different result ---> Fail");
                        CaseFail++;
                    }
                    break;
                case "selectOptionByValue":
                    ActionKeywords.selectOptionByValue(locatorType, locatorValue, testData);
                    break;
                case "ScrollDownAndClick":
                    ActionKeywords.clickElementWithJs(locatorType, locatorValue);
                    break;
                case "Sceenshot":
                    ActionKeywords.screenshot(CaseName);
                    break;
                case "quitBrowser":
                    ActionKeywords.quitDriver();
                    break;
            }
        }

        java.util.Date date=new java.util.Date();
        System.out.println("==========================================================");
        System.out.println("-----------"+date+"--------------");
        System.out.println("Total number of Testcases run: "+(CasePass+CaseFail+CaseSkip));
        System.out.println("Total number of passed Testcases: "+CasePass);
        System.out.println("Total number of failed Testcases: "+CaseFail);
        System.out.println("Total number of skip Testcases: "+CaseSkip);
        System.out.println("==========================================================");
    }
}

