package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends PageBase{
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public By btnProfile = By.xpath("(//button[@type='button'])[2]");
    public By btnRewards = By.xpath("//li[contains(@data-menu-id,'rewards')]");

    public boolean isDashboardDisplayed(){
        waitElement(btnProfile);
        return action(btnProfile).isDisplayed();
    }

    public void clickRewards(){
        waitElement(btnRewards);
        click(btnRewards);
    }
}