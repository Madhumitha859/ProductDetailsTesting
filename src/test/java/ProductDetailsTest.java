import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProductDetailsTest {

    @Test
    public void verifyBackpackDetails() {

        WebDriver driver = new ChromeDriver();

        try {
            WebDriverWait wait = new WebDriverWait(
                    driver, Duration.ofSeconds(15)
            );

            // Open SauceDemo website
            driver.get("https://www.saucedemo.com/");

            // Login
            driver.findElement(By.id("user-name"))
                    .sendKeys("standard_user");

            driver.findElement(By.id("password"))
                    .sendKeys("secret_sauce");

            driver.findElement(By.id("login-button")).click();

            // Wait for the Backpack product link
            WebElement backpack = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.id("item_4_title_link")
                    )
            );

            // Open Backpack details
            backpack.click();

            // Verify product name
            String name = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.className("inventory_details_name")
                    )
            ).getText();

            Assert.assertEquals(name, "Sauce Labs Backpack");

            // Verify price
            String price = driver.findElement(
                    By.className("inventory_details_price")
            ).getText();

            Assert.assertEquals(price, "$29.99");

            // Verify description
            String description = driver.findElement(
                    By.className("inventory_details_desc")
            ).getText();

            Assert.assertFalse(
                    description.isEmpty(),
                    "Backpack description should not be empty"
            );

            // Verify image
            WebElement image = driver.findElement(
                    By.className("inventory_details_img")
            );

            Assert.assertTrue(
                    image.isDisplayed(),
                    "Backpack image should be displayed"
            );

            // Verify Add to Cart button
            WebElement button = driver.findElement(
                    By.id("add-to-cart")
            );

            Assert.assertTrue(button.isDisplayed());
            Assert.assertTrue(button.isEnabled());

            System.out.println(
                    "Backpack details verified successfully!"
            );

        } finally {
            driver.quit();
        }
    }

    @Test
    public void verifyBikeLightDetails() {

        WebDriver driver = new ChromeDriver();

        try {
            WebDriverWait wait = new WebDriverWait(
                    driver, Duration.ofSeconds(15)
            );

            // Open SauceDemo website
            driver.get("https://www.saucedemo.com/");

            // Login
            driver.findElement(By.id("user-name"))
                    .sendKeys("standard_user");

            driver.findElement(By.id("password"))
                    .sendKeys("secret_sauce");

            driver.findElement(By.id("login-button")).click();

            // Wait for the Bike Light product link
            WebElement bikeLight = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.id("item_0_title_link")
                    )
            );

            // Open Bike Light details
            bikeLight.click();

            // Verify product name
            String name = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.className("inventory_details_name")
                    )
            ).getText();

            Assert.assertEquals(name, "Sauce Labs Bike Light");

            // Verify price
            String price = driver.findElement(
                    By.className("inventory_details_price")
            ).getText();

            Assert.assertEquals(price, "$9.99");

            // Verify description
            String description = driver.findElement(
                    By.className("inventory_details_desc")
            ).getText();

            Assert.assertFalse(
                    description.isEmpty(),
                    "Bike Light description should not be empty"
            );

            // Verify image
            WebElement image = driver.findElement(
                    By.className("inventory_details_img")
            );

            Assert.assertTrue(
                    image.isDisplayed(),
                    "Bike Light image should be displayed"
            );

            // Verify Add to Cart button
            WebElement button = driver.findElement(
                    By.id("add-to-cart")
            );

            Assert.assertTrue(button.isDisplayed());
            Assert.assertTrue(button.isEnabled());

            System.out.println(
                    "Bike Light details verified successfully!"
            );

        } finally {
            driver.quit();
        }
    }
}