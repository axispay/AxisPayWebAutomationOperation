package Tests;

import Pages.CreateNewRewardPage;
import Utils.ExcelFileManager;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class Rewards extends TestBase {
    @Description("Checking that Rewards Module is opening fine")
    @Test(priority=0)
    public void OpenRewardsModule() throws IOException {
        loginPage.setUsername(ExcelFileManager.setDataFromExcelFile(0, 1));
        loginPage.setPassword(ExcelFileManager.setDataFromExcelFile(1, 1));
        loginPage.clickSignIn();
        loginPage.setOTP(ExcelFileManager.setDataFromExcelFile(2, 1));
        loginPage.clickVerifyOTP();
        Assert.assertTrue(dashboardPage.isDashboardDisplayed());
        dashboardPage.scrollToElement();
        dashboardPage.clickRewards();
        Assert.assertTrue(rewardsPage.isMerchantFilterDisplayed());
        Assert.assertTrue(rewardsPage.isStatusDisplayed());
    }

    @Description("Checking That reward details appears correctly")
    @Test(priority=1,enabled = true)
    public void CheckRewardsDetails() throws IOException {
        OpenRewardsModule();
        rewardsPage.clickRewardTitle();
        Assert.assertTrue(rewardsPage.isLogoDisplayed());
        Assert.assertTrue(rewardsPage.isMerchantIDDisplayed());
        Assert.assertTrue(rewardsPage.isPercentageDisplayed());
        Assert.assertTrue(rewardsPage.isMaxAmountDisplayed());
        Assert.assertTrue(rewardsPage.isExpiryDateDisplayed());
        Assert.assertTrue(rewardsPage.isDescriptionDisplayed());
    }

    @Description("Checking that filter by Merchant name is working correctly")
    @Test(priority=2,enabled = true)
    public void CheckMerchantNameFilter() throws IOException {
        OpenRewardsModule();
        rewardsPage.setMerchantName(ExcelFileManager.setDataFromExcelFile(4,1));
        rewardsPage.clickShowResults();
        rewardsPage.clickRewardTitle();
        Assert.assertEquals(rewardsPage.getTitleText(),"Uber2");
    }

    @Description("Checking Status Filter is working correctly")
    @Test(priority=3,enabled = true)
    public void CheckStatusFilters() throws IOException {
        OpenRewardsModule();
        rewardsPage.clickStatusFilter();
        rewardsPage.clickActive();
        rewardsPage.clickShowResults();
        rewardsPage.clickRewardActiveTitle();
        Assert.assertEquals(rewardsPage.getStatusText(),"Active");
    }

    @Description("Check Creation of New cashback is working correctly")
    @Test(priority=4,enabled = true)
    public void CreateNewCashback() throws IOException, AWTException {
        OpenRewardsModule();
        rewardsPage.clickCreateNewCashback();
        createNewRewardPage.setMerchantEngName(ExcelFileManager.setDataFromExcelFile(5,1));
        createNewRewardPage.setMerchantArName(ExcelFileManager.setDataFromExcelFile(5,2));
        createNewRewardPage.setMerchantIDs(ExcelFileManager.setDataFromExcelFile(5,3));
        createNewRewardPage.setUpLogo(ExcelFileManager.setDataFromExcelFile(5,4));
        createNewRewardPage.setPercentage(ExcelFileManager.setDataFromExcelFile(5,5));
        createNewRewardPage.setMaxAmount(ExcelFileManager.setDataFromExcelFile(5,6));
        //createNewRewardPage.setDateExpiryDate(ExcelFileManager.setDataFromExcelFile(5,7));
        createNewRewardPage.setDescription(ExcelFileManager.setDataFromExcelFile(5,8));
        createNewRewardPage.clickCreate();
        //createNewRewardPage.clickConfirm();
    }
}
