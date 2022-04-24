package com.starwars.tests.ui;

import com.starwars.tests.TestInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomeTests extends TestInit {
    @Test
    public void checkElementsOnPageTest(){
        Assert.assertEquals(driver.getCurrentUrl(), "https://starwarsarts.com/");
        Assert.assertEquals(driver.getTitle(), "Star Wars Wallpapers | Backgrounds Images - StarWarsArts");
        WebElement title = driver.findElement(By.cssSelector(".sc-bdvvaa.eRQARU"));
        Assert.assertEquals(title.getText(), "HD And 4K Wallpapers And Arts\n" +
                                                    "Search your favorite Star Wars characters...");
    }

    @Test
    public void checkFilterTest(){
        List<WebElement> listImages = driver.findElements(By.cssSelector("img.sc-dkPtyc.gnliEL"));
        String urlImage = listImages.get(0).getAttribute("src");
        Assert.assertEquals(urlImage, "https://starwarsarts.com/media/CACHE/images/images/others/swtor_sith_exyda_by_lakonstudio_df2izi3/026a2005a7b767b4377ad8975a15e924.jpeg");

        WebElement filter = driver.findElement(By.cssSelector("#darth\\ vader"));
        filter.click();
        List<WebElement> updatedListImages = driver.findElements(By.cssSelector("img.sc-dkPtyc.gnliEL"));
        String newUrlImage = updatedListImages.get(0).getAttribute("src");
        Assert.assertEquals(newUrlImage, "https://starwarsarts.com/media/CACHE/images/images/darth%20vader/darth_vader_by_6kart_d6v8x3c/54d19db3aa7b849e53180833f4823601.jpg");
    }

    @Test
    public void checkSearchTest(){
       driver.findElement(By.cssSelector(".input-search")).sendKeys("Yoda");
       driver.findElement(By.cssSelector(".fa.fa-search")).click();
       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        List<WebElement> updatedListImages = driver.findElements(By.cssSelector("img.sc-dkPtyc.gnliEL"));
        Assert.assertEquals(updatedListImages.get(0).getAttribute("src"), "https://starwarsarts.com/media/CACHE/images/images/yoda/jedi_master_by_lukemandieart_d6f8py1/9bcb62c06f9cdb8c96929d6c5f0799f8.jpeg");
    }
}
