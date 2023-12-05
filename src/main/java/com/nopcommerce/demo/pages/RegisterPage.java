package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class RegisterPage extends Utility {
    By registerText = By.xpath("//h1[contains(text(),'Register')]");
    By firstNameTextBox = By.id("FirstName");
    By lastnameTextBox = By.id("LastName");
    By emailTextBox = By.id("Email");
    By passwordTextBox = By.id("Password");
    By confirmPasswordTextBox = By.id("ConfirmPassword");
    By registerButton = By.id("register-button");
    By registerSuccessText = By.xpath("//div[contains(text(),'Your registration completed')]");
    By continueButton = By.xpath("//a[contains(text(),'Continue')]");
    By registerButton1 = By.xpath("//button[contains(text(),'Register')]");

    public String getRegisterText() {
        return getTextFromElement(registerText);
    }

    public void inputFirstName(String firstname) {
        sendTextToElement(firstNameTextBox, firstname);
    }

    public void inputLastName(String lastname) {
        sendTextToElement(lastnameTextBox, lastname);
    }

    public void inputEmail(String email) {
        sendTextToElement(emailTextBox, email);
    }

    public void inputPassword(String password) {
        sendTextToElement(passwordTextBox, password);
    }

    public void inputConfirmPassword(String confirmPassword) {
        sendTextToElement(confirmPasswordTextBox, confirmPassword);
    }

    public void clickOnRegisterButton() {
        clickOnElement(registerButton);
    }

    public String getRegisterSuccessText() {
        return getTextFromElement(registerSuccessText);
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
    }

    public void clickOnRegisterButton1() {
        clickOnElement(registerButton1);
    }

}
