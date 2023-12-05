package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ElectronicsTest extends BaseTest {

    ElectronicsPage electronics = new ElectronicsPage();
    ElectronicsPage login = new ElectronicsPage();
    CellPhonePage cellPhones = new CellPhonePage();
    NokiaLumiaPage nokiaLumia = new NokiaLumiaPage();
    ShoppingCartPage shoppingCart = new ShoppingCartPage();
    RegisterPage register = new RegisterPage();
    CheckOutPage checkout = new CheckOutPage();

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        // 1.1 Mouse Hover on "Electronics" tab
        electronics.hoverOnElectronics();

        // 1.2 Mouse Hover on "Cell Phone" and click
        electronics.hoverOnCellPhoneAndClick();

        // 1.3 verify the text "Cell Phone"
        String actualText = cellPhones.getCellPhoneText();
        Assert.assertEquals(actualText, "Cell phones", "Text not Displayed");

    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {

        //2.1 Mouse Hover on “Electronics” Tab
        electronics.hoverOnElectronics();

        //2.2 Mouse Hover on “Cell phones” and click
        electronics.hoverOnCellPhoneAndClick();

        //2.3 Verify the text “Cell phones”
        String actualText = cellPhones.getCellPhoneText();
        Assert.assertEquals(actualText, "Cell phones", "Text not Displayed");

        //2.4 Click on List View Tab
        cellPhones.clickOnListViewTab();

        //2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(1000);
        cellPhones.clickOnNokiaLumia1020();

        //2.6 Verify the text “Nokia Lumia 1020”
        String actualNokiaLumiaText = nokiaLumia.getNokiaLumiaText();
        Assert.assertEquals(actualNokiaLumiaText, "Nokia Lumia 1020", "Text not Displayed");

        //2.7 Verify the price “$349.00”
        String actualNokiaPriceText = nokiaLumia.getNokiaPriceText();
        Assert.assertEquals(actualNokiaPriceText, "$349.00", "Text not Displayed");

        //2.8 Change quantity to 2
        nokiaLumia.changeQuantity();

        //2.9 Click on “ADD TO CART” tab
        nokiaLumia.clickOnAddToCartButton();

        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar  After that close the bar clicking on the cross button.
        String actualTextShoppingCart = nokiaLumia.getTextFromProductAddedToCart();
        Assert.assertEquals(actualTextShoppingCart, "The product has been added to your shopping cart", "Text not Displayed");
        nokiaLumia.closeTheBarByClickingOnTheCrossButton();

        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        nokiaLumia.mouseHoverOnShoppingCart();
        nokiaLumia.clickOnShoppingCart();

        //2.12 Verify the message "Shopping cart"
        String actualShoppingCartMessage = shoppingCart.getShoppingCartText();
        Assert.assertEquals(actualShoppingCartMessage, "Shopping cart", "error");
        Thread.sleep(2000);

        //2.13 Verify the quantity is 2
        String actualQuantity = shoppingCart.getVerifyQuantity();
        Assert.assertEquals(actualQuantity, "(2)", "Error");

        //2.14 Verify the Total $698.00
        String actualTotal = shoppingCart.getVerifyTotal();
        Assert.assertEquals(actualTotal, "$698.00", "Error");

        //2.15 click on checkbox "I agree with the terms of  service"
        shoppingCart.clickOnTermsOfServiceCheckBox();

        // 2.16 click on "CHECKOUT"
        shoppingCart.clickOnCheckOutButton();

        //2.17 Verify the Text “Welcome, Please Sign In!”
        String actualWelcomeText = electronics.getWelcomePageSignInText();
        Assert.assertEquals(actualWelcomeText, "Welcome, Please Sign In!", "Error");

        /* //2.18 Click on “REGISTER” tab
        register.clickOnRegisterButton1();

        //2.19 Verify the text “Register”
        String actualRegisterText=register.getRegisterText();
        Assert.assertEquals(actualRegisterText,"Register","Error");

        //2.20 Fill the mandatory fields
        register.inputFirstname("Cristina");
        register.inputLastname("Rusu");
        register.inputEmail("cristinarusu0@gmail.com");
        register.inputPassword("cristina123");
        register.inputConfirmPassword("cristina123");

        //2.21 Click on “REGISTER” Button
        register.clickOnRegisterButton();

        //2.22 Verify the message “Your registration completed”
        String actualRegisterSuccessMessage = register.getRegisterSuccessText();
        Assert.assertEquals(actualRegisterSuccessMessage,"Your registration completed","error");

        //2.23 Click on “CONTINUE” tab
        register.clickOnContinueButton(); */

        sendTextToElement(By.xpath("//input[@id='Email']"), "cristinarusu0@gmail.com");
        sendTextToElement(By.xpath("//input[@id='Password']"), "cristina123");
        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));

        //2.24 verify the text "Shopping card"
        String expectedText1 = "Shopping cart";
        String actualText1 = shoppingCart.getShoppingCartText();
        Assert.assertEquals(actualText1, expectedText1);

        //2.25 click on checkbox "I agree with the terms of service"
        shoppingCart.clickOnTermsOfServiceCheckBox();

        //2.26 click on "CHECKOUT"
        shoppingCart.clickOnCheckOutButton();

        //2.27 fill the mandatory fields
        checkout.inputFirstname("Cristina");
        checkout.inputLastname("Rusu");
        // checkout.inputEmail("cristinarusu0@gmail.com");
        checkout.selectCountry("United Kingdom");
        checkout.inputCity("London");
        checkout.inputAddress1("Coral Street");
        checkout.inputPostalCode("HA6 2QN");
        checkout.inputPhoneNumber("1234567");

        //2.28 click on "CONTINUE"
        Thread.sleep(3000);
        checkout.clickOnContinueButton();

        //2.29 click on radio button “2nd Day Air ($0.00)”
        checkout.clickONRadioButton2ndDayAir();

        //2.30 click on "CONTINUE"
        checkout.clickOnContinueButton();

        //2.31 select radio button "Credit Card"
        checkout.clickOnCreditCard();
        checkout.clickOnPaymentContinueButton();

        //2.32 select "Visa" from select credit card dropdown
        checkout.selectCreditCard("Visa");

        //2.33 fill all the details
        checkout.inputCardHolderName("Hiral Sutariya");
        checkout.inputCardNumber("5356 6548 1418 5420");
        checkout.selectExpireMonth("02");
        checkout.selectExpireYear("2027");
        checkout.inputCardCode("123");

        //2.34 click on CONTINUE CHECKOUT
        checkout.clickOnContinueButton2();

        //2.35 verify "Payment Method" is "Credit Card"
        String actualCreditCardMessage = checkout.getCreditCardText();
        Assert.assertEquals(actualCreditCardMessage, "Credit Card", "error");

        // 2.36 Verify “Shipping Method” is “2nd Day Air”
        String actual02DayMessage = checkout.get02ndDayText();
        Assert.assertEquals(actual02DayMessage, "2nd Day Air", "error");

        // 2.37 Verify Total is “$698.00”
        String actualTotalAmountNokiaMessage = checkout.getTotalAmountNokiaText();
        Assert.assertEquals(actualTotalAmountNokiaMessage, "$698.00", "error");

        //2.38 click on "CONFIRM"
        checkout.clickOnConfirmButton();

        //2.39 Verify the Text “Thank You”
        String actualThankYouMessage = checkout.getThankYouText();
        Assert.assertEquals(actualThankYouMessage, "Thank you", "error");

        //2.40 Verify the message “Your order has been successfully processed!”
        String actualOrderSuccessProcessedMessage = checkout.getOrderSuccessProcessText();
        Assert.assertEquals(actualOrderSuccessProcessedMessage, "Your order has been successfully processed!", "error");

        // 2.41 Click on “CONTINUE”
        checkout.clickOnContinueButton3();

        // 2.42 Verify the text “Welcome to our store”
        String actualWelcomeOurStoreMessage = electronics.getWelcomeOurStoreText();
        Assert.assertEquals(actualWelcomeOurStoreMessage, "Welcome to our store", "error");

        // 2.43 Click on “Logout” link
        electronics.clickOnLogOutButton();

        // 2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, "https://demo.nopcommerce.com/", "error");
    }
}
