package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RewardsPage extends PageBase {
    public RewardsPage(WebDriver driver) {
        super(driver);
    }

    public By lblMerchantName = By.xpath("//label[@title='Merchant Name']");
    public By lblStatus = By.xpath("//label[@title='Status']");
    public By btnRewardTitle = By.xpath("(//div[@class='ant-row'])[1]");
    public By btnRewardActiveTitle = By.xpath("//div[contains(@class,'_cashbackDetailsContainer')]");
    public By lblLogo = By.xpath("(//div[contains(@class,'ant-col _rewardDetailsHeaders')])[1]");
    public By lblMerchantID = By.xpath("(//div[contains(@class,'ant-col _rewardDetailsHeaders')])[2]");
    public By lblPercentage = By.xpath("(//div[contains(@class,'ant-col _rewardDetailsHeaders')])[3]");
    public By lblMaxAmount = By.xpath("(//div[contains(@class,'ant-col _rewardDetailsHeaders')])[4]");
    public By lblExpiryDate = By.xpath("(//div[contains(@class,'ant-col _rewardDetailsHeaders')])[5]");
    public By lblDescription = By.xpath("(//div[contains(@class,'ant-col _rewardDetailsHeaders')])[6]");
    public By txtMerchantName = By.id("merchantName");
    public By ddlStatus = By.xpath("(//div[@class='ant-form-item-control-input-content'])[2]");
    public By btnShowResults = By.xpath("//strong[contains(.,'Show Results')]");
    public By lblTitle = By.xpath("(//div[contains(@direction,'ltr')])[2]");
    public By lblActive = By.xpath("//span[@class='ant-tag ant-tag-success']");
    public By btnvalueActive = By.xpath("//div[@title='Active']");
    public By btnCreateNewCashback = By.xpath("//a[contains(@class,'_addNewButton')]");

    public boolean isMerchantFilterDisplayed() {
        waitElement(lblMerchantName);
        return action(lblMerchantName).isDisplayed();
    }

    public boolean isStatusDisplayed() {
        waitElement(lblStatus);
        return action(lblStatus).isDisplayed();
    }

    public void clickRewardTitle() {
        waitElement(btnRewardTitle);
        click(btnRewardTitle);
    }

    public void clickRewardActiveTitle() {
        waitElement(btnRewardActiveTitle);
        click(btnRewardActiveTitle);
    }

    public boolean isLogoDisplayed() {
        waitElement(lblLogo);
        return action(lblLogo).isDisplayed();
    }

    public boolean isMerchantIDDisplayed() {
        waitElement(lblMerchantID);
        return action(lblMerchantID).isDisplayed();
    }

    public boolean isPercentageDisplayed() {
        waitElement(lblPercentage);
        return action(lblPercentage).isDisplayed();
    }

    public boolean isMaxAmountDisplayed() {
        waitElement(lblMaxAmount);
        return action(lblMaxAmount).isDisplayed();
    }

    public boolean isExpiryDateDisplayed() {
        waitElement(lblExpiryDate);
        return action(lblExpiryDate).isDisplayed();
    }

    public boolean isDescriptionDisplayed() {
        waitElement(lblDescription);
        return action(lblDescription).isDisplayed();
    }

    public void setMerchantName(String merchantName) {
        setText(txtMerchantName, merchantName);
    }

    public void clickShowResults() {
        click(btnShowResults);
        waitElement(btnShowResults);
    }

    public String getTitleText() {
        return getContent(lblTitle);
    }

    public String getStatusText() {
        return getContent(lblActive);
    }

    public void clickStatusFilter() {
        click(ddlStatus);
    }

    public void clickActive() {
        click(btnvalueActive);
    }

    public void clickCreateNewCashback() {
        click(btnCreateNewCashback);
    }

    public void clickCreate(){
        click(btnCreateNewCashback);
    }
}

