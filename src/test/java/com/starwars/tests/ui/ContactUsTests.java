package com.starwars.tests.ui;

import com.starwars.tests.TestInit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsTests extends TestInit {
    @Test
    public void checkElementsOnPageTest(){
        driver.findElement(By.xpath("(//a[text()=\"Contact Us\"])[1]")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://starwarsarts.com/contact-us");
        Assert.assertEquals(driver.getTitle(), "Star Wars Wallpapers | Contact-Us");
    }

    @Test
    public void checkContactUsFormTest(){
        driver.findElement(By.xpath("(//a[text()=\"Contact Us\"])[1]")).click();
        driver.findElement(By.xpath("//input[@name=\"full_name\"]")).sendKeys("Name Test");
        driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("email@email.com");
        driver.findElement(By.xpath("//input[@name=\"message\"]")).sendKeys("message");
        driver.findElement(By.cssSelector(".submit-button")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//input[@name=\"full_name\"]")).getText(), "");
    }
}
