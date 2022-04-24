package com.starwars.tests.ui;

import com.starwars.tests.TestInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AboutTests  extends TestInit {
    @Test
    public void checkElementsOnPageTest(){
        driver.findElement(By.xpath("(//a[text()=\"About\"])[1]")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://starwarsarts.com/about");
        Assert.assertEquals(driver.getTitle(), "Star Wars Wallpapers | About");
    }
}
