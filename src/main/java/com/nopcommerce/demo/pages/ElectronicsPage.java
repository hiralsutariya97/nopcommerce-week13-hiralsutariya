package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class ElectronicsPage extends Utility {

    By electronicsCategory = By.xpath("//a[text()='Electronics ']");
    By cellPhone = By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']");
    By welcomePageSignInText = By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]");
    By logOutButton = By.xpath("//a[contains(text(),'Log out')]");
    By welcomeOurStoreText = By.xpath("//h2[contains(text(),'Welcome to our store')]");
    By checkOutAsGuestButton = By.xpath("//button[contains(text(),'Checkout as Guest')]");

    public void hoverOnElectronics() {
        mouseHoverToElement(electronicsCategory);
    }

    public void hoverOnCellPhoneAndClick() {
        mouseHoverToElementAndClick(cellPhone);
    }

    public String getWelcomeOurStoreText() {
        return getTextFromElement(welcomeOurStoreText);
    }

    public void clickOnLogOutButton() {
        clickOnElement(logOutButton);
    }

    public String getWelcomePageSignInText() {
        return getTextFromElement(welcomePageSignInText);
    }

    public void clickOnCheckOutAsGuestButton() {
        clickOnElement(checkOutAsGuestButton);
    }
}
