package ExecutionEngine;

import Utilities.ActionKeywords;
import Utilities.ExcelUtils;
import Utilities.Log;
import org.junit.Test;
import utils.ExtentTestManager;


public class StepsLoginPage {
    @Test
    public void Excute_TestCaseDangNhap() throws Exception {
            //Làm việc với file excel đã import
            String   sPath = System.getProperty("user.dir") + "//src//main//java//DataEngine//DataDATN1.xlsx";
            //làm việc với sheet LoginPage trong file excel
            ExcelUtils.setExcelFile(sPath, "LoginPage");
            int CasePass=0;
            int CaseFail=0;
            int CaseSkip=0;
            int row = ExcelUtils.getRowCount("LoginPage");
//        for (int iRow=1;iRow<=19;iRow++)
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
                    case "dismissAlert":
                        ActionKeywords.skipQC();
                        break;
                    case "click":
                        ActionKeywords.clickElement(locatorType, locatorValue);
                        break;
                    case "verifyUrl":
                        if (ActionKeywords.getUrl(testData)) {
                            Log.info("Same result ---> pass");
                            CasePass++;
                            ExtentTestManager.logMessage(CasePass,testData);
                        } else {
                            Log.error("Different result ---> Fail");
                            CaseFail++;
                            //ExtentTestManager.logMessage(CaseFail,testData);
                        }
                        break;
                    case "AlertofEmail":
                        if (ActionKeywords.verifyAlertEmailofLoginPage(testData))
                        {
                            Log.info("Same result ---> pass");
                            CasePass++;
                           // ExtentTestManager.logMessage(CasePass,testData);
                        }
                        else
                        {
                            Log.error("Different result ---> Fail");
                            CaseFail++;
                         //   ExtentTestManager.logMessage(CaseFail,testData);
                        }
                        break;
                    case "AlertofPassword":
                       if (ActionKeywords.verifyAlertPasswordofLoginPage(testData))
                       {
                           Log.info("Same result ---> pass");
                           CasePass++;
                          // ExtentTestManager.logMessage(CasePass,testData);
                       }
                       else
                       {
                           Log.error("Different result ---> Fail");
                           CaseFail++;
                          // ExtentTestManager.logMessage(CaseFail,testData);
                       }
                        break;
                    case "verifyelementtext":
                        if (ActionKeywords.verifyText(locatorType, locatorValue, testData)) {
                            Log.info("Same result ---> pass");
                            CasePass++;
                             //ExtentTestManager.logMessage(CasePass,testData);
                        } else {
                            Log.error("Different result ---> Fail");
                            CaseFail++;
                          //   ExtentTestManager.logMessage(CaseFail,testData);
                        }
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

