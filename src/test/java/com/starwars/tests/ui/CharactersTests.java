package com.starwars.tests.ui;

import com.starwars.tests.TestInit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CharactersTests extends TestInit {
    @Test
    public void checkElementsOnPageTest(){
        driver.findElement(By.xpath("(//a[text()=\"Characters\"])[1]")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://starwarsarts.com/characters");
        Assert.assertEquals(driver.getTitle(), "Star Wars Wallpapers | Characters");
    }
}
