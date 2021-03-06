
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

    public class teamWork {





    public class Books {

   /* Class Books
    url = https://demo.nopcommerce.com/"

    Test 1 : Click on the books Page
    Navigate to books page successfully
    verify the Text Books

    Test 2 : Books Page (sort by)
    Select position (A-Z)
    arrange the books list in ascending order and verify
    Test 3 : Add book Fahrenheit 451 by Ray Bradbury to the wish list
    And verify the message "The product has been added to your wishlist"
            */

        WebDriver driver;

        @Before
        public void openBrowser() {
            String baseUrl = "https://demo.nopcommerce.com/";
            System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
            driver = new ChromeDriver();
            driver.get(baseUrl);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

        }

        @Test
        public void verifyUserShouldNavigateToBooksPage() throws InterruptedException {
            Thread.sleep(6000);

            WebElement books = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Books')]"));
            books.click();

            WebElement books1 = driver.findElement(By.xpath("//div[@class='page-title']//h1[contains(text(),'Books')]"));
            books1.getText();


        }

        @Test
        public void shortyByAToZ() throws InterruptedException {

            Thread.sleep(6000);

            WebElement books1 = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Books')]"));
            books1.click();

            WebElement position = driver.findElement(By.xpath("//select[@id='products-orderby']"));
            position.click();

            WebElement aToz = driver.findElement(By.xpath("//select[@id='products-orderby']//option[contains(text(),'Name: A to Z')]"));
            aToz.getText();

            ArrayList<String> obtainedList = new ArrayList<>();  // creating the array list for obtain the elements from webpage
            List<WebElement> elementList =driver.findElements(By.tagName("h2"));// finding the elements by tag
            for (WebElement Links :elementList){
                obtainedList.add(Links.getText());
            }
            System.out.println("Obtained Product List :" + obtainedList);
            ArrayList<String> sortedList = new ArrayList<>();
            sortedList.addAll(obtainedList);
            Collections.sort(sortedList);
            Assert.assertTrue(obtainedList.equals(sortedList));
            System.out.println("Sorted Product List :" + sortedList);

        }


        @Test
        public void wistList() throws InterruptedException {
            Thread.sleep(6000);

            WebElement books1 = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Books')]"));
            books1.click();

            WebElement position = driver.findElement(By.xpath("//select[@id='products-orderby']"));
            position.click();

            WebElement aToz = driver.findElement(By.xpath("//select[@id='products-orderby']//option[contains(text(),'Name: A to Z')]"));
            aToz.getText();

            WebElement wishList = driver.findElement(By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//input[3]"));
            wishList.click();

            WebElement added = driver.findElement(By.xpath("//p[@class='content']"));
            String expectedResult = "The product has been added to your wishlist";
            String actualResult = added.getText();
            Assert.assertEquals(expectedResult, actualResult);

        }

        @After
        public void browserClosing() {
            driver.close();
        }


    }

}
