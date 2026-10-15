import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductDetailsTest {

    @Test
    public void verifyBackpackDetails() {

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.saucedemo.com/");

            // Login
            driver.findElement(By.id("user-name"))
                    .sendKeys("standard_user");

            driver.findElement(By.id("password"))
                    .sendKeys("secret_sauce");

            driver.findElement(By.id("login-button")).click();

            // Open Backpack details
            driver.findElement(By.id("item_4_title_link")).click();

            // Verify product name
            String name = driver.findElement(
                    By.className("inventory_details_name")
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

            Assert.assertFalse(description.isEmpty());

            // Verify image
            WebElement image = driver.findElement(
                    By.className("inventory_details_img")
            );

            Assert.assertTrue(image.isDisplayed());

            // Verify Add to Cart button
            WebElement button = driver.findElement(
                    By.id("add-to-cart")
            );

            Assert.assertTrue(button.isDisplayed());
            Assert.assertTrue(button.isEnabled());

            System.out.println("Backpack details verified successfully!");

        } finally {
            driver.quit();
        }
    }

    @Test
    public void verifyBikeLightDetails() {

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.saucedemo.com/");

            // Login
            driver.findElement(By.id("user-name"))
                    .sendKeys("standard_user");

            driver.findElement(By.id("password"))
                    .sendKeys("secret_sauce");

            driver.findElement(By.id("login-button")).click();

            // Open Bike Light details
            driver.findElement(By.id("item_0_title_link")).click();

            // Verify product name
            String name = driver.findElement(
                    By.className("inventory_details_name")
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

            Assert.assertFalse(description.isEmpty());

            // Verify image
            WebElement image = driver.findElement(
                    By.className("inventory_details_img")
            );

            Assert.assertTrue(image.isDisplayed());

            // Verify Add to Cart button
            WebElement button = driver.findElement(
                    By.id("add-to-cart")
            );

            Assert.assertTrue(button.isDisplayed());
            Assert.assertTrue(button.isEnabled());

            System.out.println("Bike Light details verified successfully!");

        } finally {
            driver.quit();
        }
    }
}