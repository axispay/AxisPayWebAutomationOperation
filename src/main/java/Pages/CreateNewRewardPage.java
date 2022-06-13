package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class CreateNewRewardPage extends PageBase {
    public CreateNewRewardPage(WebDriver driver) {
        super(driver);
    }

    public By txtMerchantEngName = By.id("merchantNameEn");
    public By txtMerchantArName = By.id("merchantNameAr");
    public By txtMerchantIDs = By.id("merchantIds");
    public By upLogo = By.xpath("//div[contains(@class,'_uploadInput_bw83m_5')]");
    public By txtPercentage = By.id("percentage");
    public By txtMaxAmount = By.id("maxAmount");
    public By dpExpiryDate = By.id("expiryDate");
    public By txtDescription = By.id("description");
    public By btnCreate = By.xpath("//button[@type='submit']");
    public By btnConfirm = By.xpath("//span[.='Confirm']");

    public void setMerchantEngName(String merchantEngName) {
        setText(txtMerchantEngName, merchantEngName);
    }

    public void setMerchantArName(String merchantArName) {
        setText(txtMerchantArName, merchantArName);
    }

    public void setMerchantIDs(String merchantIDs) {
        setText(txtMerchantIDs, merchantIDs);
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("document.getElementById('pass').value;");
    }

    public void setUpLogo(String url) throws AWTException {
        click(upLogo);
        Robot rb = new Robot();

        // copying File path to Clipboard
        StringSelection str = new StringSelection(url);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

        // press Contol+V for pasting
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);

        // release Contol+V for pasting
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);

        // for pressing and releasing Enter
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
    }

    public void setPercentage(String percentage) {
        setText(txtPercentage, percentage);
    }

    public void setMaxAmount(String maxAmount) {
        setText(txtMaxAmount, maxAmount);
    }

    public void setDateExpiryDate(String expiryDate) {
        setText(dpExpiryDate, expiryDate);
    }


    public void setDescription(String description) {
        setText(txtDescription, description);
    }

    public void clickCreate() {
        click(btnCreate);
    }

    public void clickConfirm() {
        click(btnConfirm);
    }
}
