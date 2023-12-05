package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.ComputerPage;
import com.nopcommerce.demo.pages.TopMenuPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComputerTest extends BaseTest {

    TopMenuPage topMenuPage = new TopMenuPage();
    ComputerPage computerPage = new ComputerPage();

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        // 1.1 click on computer menu
        topMenuPage.selectMenu("Computer");

        // 1.2 click on desktop
        computerPage.clickOnDesktops();

        // get list before filter the name
        List<WebElement> beforeFilterNameZtoAList = driver.findElements(By.xpath("item-grid"));
        List<Double> beforeFileNameZtoAList = new ArrayList<>();
        for (WebElement nameZtoA : beforeFilterNameZtoAList) {
            beforeFileNameZtoAList.add(Double.valueOf(nameZtoA.getText().replace("$", "")));
        }

        // 1.3 select sort by position "Name: Z to A"
        computerPage.sortByPosition("Name: Z to A");

        // get list after filter name
        List<WebElement> afterFilterNameZtoAList = driver.findElements(By.xpath("item-grid"));
        List<Double> afterFileNameZtoAList = new ArrayList<>();
        for (WebElement nameZtoA : afterFilterNameZtoAList) {
            afterFileNameZtoAList.add(Double.valueOf(nameZtoA.getText().replace("$", "")));
        }
        // 1.4 verify the product will arrange in Descending order
        Collections.sort(beforeFileNameZtoAList);
        Assert.assertEquals(beforeFileNameZtoAList, afterFileNameZtoAList);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

        // 2.1 click on computer menu
        topMenuPage.selectMenu("Computer");

        // 2.2 click on desktop
        computerPage.clickOnDesktops();

        // 2.3 select sort by position "Name : A to Z"
        computerPage.sortByPosition("Name: A to Z");

        // 2.4 click on "Add to Cart"
        Thread.sleep(2000);
        computerPage.addToCart();

        //2.5 verify the text "Build your own computer"
        String expectedText = "Build your own computer";
        String actualText = computerPage.verifyBuildYourOwnText();
        Assert.assertEquals(expectedText, actualText);

        // 2.6 select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        computerPage.selectProcessor("2.2 GHz Intel Pentium Dual-Core E2200");

        // 2.7 select "8GB  [+$60.00]" using Select class
        computerPage.selectRam("8GB [+$60.00]");

        // 2.8 select HDD radio "400 GB [+$100.00]
        computerPage.selectHDD();

        // 2.9 select OS radio "Vista Premium [+$60.00]"
        computerPage.selectOS();

        // 2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander   [+$5.00]"
        computerPage.clickCheckBox1();

        /*//2.11 Verify the price "$1,475.00"
        String expectedText1="$1,475.00";
        String actualText1 = computerPage.verifyPrice();
        Assert.assertEquals(actualText,expectedText);*/

        // 2.12 click on "ADD TO CART" button
        computerPage.addToCart2();

        // 2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar , After that close the bar clicking on the cross button
        String expectedText2 = "The product has been added to your shopping cart";
        String actualText2 = computerPage.VerifyProductAdded();
        Assert.assertEquals(expectedText2, actualText2);
        computerPage.clickClose();

        // 2.14 then MouseHover on "Shopping cart" and Click on "GO TO CART" button
        computerPage.moveToShoppingCart();
        computerPage.clickOnGoToCart();

        // 2.15 verify the message "Shopping cart"
        String expectedText3 = "Shopping cart";
        String actualText3 = computerPage.verifyShoppingCartText();
        Assert.assertEquals(expectedText3, actualText3);

        // 2.16 change the Qty to "2" and Click on "Update shopping cart"
        computerPage.changeQuantity();
        computerPage.clickOnUpdateCartButton();

        // 2.17 verify the Total"$2,950.00
        String actualTotalMessage = computerPage.getTotalText();
        Assert.assertEquals(actualTotalMessage, "$2,950.00", "error");

        // 2.18 click on checkbox “I agree with the terms of service”
        computerPage.clickOnTermsOfServiceCheckBox();

        // 2.19 click on "CHECKOUT"
        computerPage.clickOnCheckOutButton();

        // 2.20 verify the Text “Welcome, Please Sign In!”
        String actualWelcomeSignInText = computerPage.getWelcomePageSignInText();
        Assert.assertEquals(actualWelcomeSignInText, "Welcome, Please Sign In!", "error");

        // 2.21 click on "CHECKOUT AS GUEST" tab
        computerPage.clickOnCheckoutAsGuestButton();

        // 2.22 fill the all mandatoryField
        computerPage.inputFirstname("Cristina");
        computerPage.inputLastname("Rusu");
        computerPage.inputEmail("cristinarusu0@gmail.com");
        computerPage.selectCountry("United Kingdom");
        computerPage.inputCity("London");
        computerPage.inputAddress1("Coral street");
        computerPage.inputPostalCode("HA6 2QN");
        computerPage.inputPhoneNumber("1234567");

        // 2.23 click on "CONTINUE"
        computerPage.clickOnContinueButton();

        // 2.24 click on radio button "Next Day Air($0.00)”
        computerPage.clickOnNextDayAirRadioButton();

        // 2.25 click on "CONTINUE"
        computerPage.clickOnContinueButton1();

        // 2.26 select radio button "Credit Card"
        computerPage.clickOnCreditCard();
        computerPage.clickOnPaymentContinueButton();

        // 2.27 select “Master card” From Select credit card dropdown
        computerPage.selectCreditCard("Master card");

        // 2.28 fill all the details
        computerPage.inputCardHolderName("Hiral Sutariya");
        computerPage.inputCardNumber("5356 6548 1418 5420");
        computerPage.selectExpireMonth("12");
        computerPage.selectExpireYear("2027");
        computerPage.inputCardCode("123");

        // 2.29 click on "CONTINUE"
        computerPage.clickOnContinueButton2();

        // 2.30 verify "Payment Method" is "Credit Card"
        String actualCardMessage = computerPage.getCreditCardText();
        Assert.assertEquals(actualCardMessage, "Credit Card", "error");

        // 2.32 verify “Shipping Method” is “Next Day Air”
        String actualShippingMessage = computerPage.getNextDayAirText();
        Assert.assertEquals(actualShippingMessage, "Next Day Air", "error");

        // 2.33 verify total is  “$2,950.00”
        String actualTotalAmountMessage = computerPage.getTotalAmountText();
        Assert.assertEquals(actualTotalMessage, "$2,950.00", "error");

        // 2.34 click on "CONFIRM"
        computerPage.clickOnConfirmButton();

        // 2.35 verify the text "Thank You"
        String actualThankYouText = computerPage.getThankYouText();
        Assert.assertEquals(actualThankYouText, "Thank you", "error");

        // 2.36 verify the message “Your order has been successfully processed!”
        String actualOrderSuccessText = computerPage.getOrderSuccessProcessText();
        Assert.assertEquals(actualOrderSuccessText, "Your order has been successfully processed!", "error");

        // 2.37 Click on “CONTINUE”
        computerPage.clickOnContinueButton3();

        // 2.38 Verify the text “Welcome to our store”
        String actualWelcomeStoreText = computerPage.getWelcomeOurStoreText();
        Assert.assertEquals(actualWelcomeStoreText, "Welcome to our store", "error");

    }
}
