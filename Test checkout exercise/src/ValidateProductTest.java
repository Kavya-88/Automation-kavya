//SCRIPT TO TEST CHECKOUT
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 import org.testng.Assert;



public class ValidateProductTest {


    static String getProduct;
	static String getpricelist;

    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://bstackdemo.com/");


        Thread.sleep(1000);
		
		
		List<WebElement> productlist = driver.findElements(By.xpath("//*[@class='shelf-container']/div/p"));
		List<WebElement> pricelist = driver.findElements(By.xpath("//*[@class='shelf-container']/div/div[3]/div[1]/b"));
		int countproductlist = productlist.size();
		System.out.println("Products size : "+ countproductlist);
		
		int countpricelist = pricelist.size();
		System.out.println("Price size : "+ countpricelist);
		
		for(int i=0;i<=countproductlist;i++) {
			
			getpricelist = pricelist.get(i).getText();
			System.out.println("getpricelist : "+ getpricelist);
			Thread.sleep(1000);
			
			if(productlist.get(i).getText().contains("iPhone 12")) {
				getProduct = productlist.get(i).getText();
				System.out.println("getProduct : "+ getProduct);
				Thread.sleep(1000);
				
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@class='shelf-container']/div/p[contains(text(),'"+getProduct+"')]//parent::*/div[4]")).click();
				Thread.sleep(1000);
				break;
			}
		}
		
		driver.findElement(By.xpath("//*[contains(text(),'Checkout')]")).click();
		
		Thread.sleep(1000);
		
		//Get the Web Element corresponding to the field UserName (Textfield)
        WebElement user = driver.findElement(By.id("react-select-2-input"));

        //Get the Web Element corresponding to the field Password (Textfield)
        WebElement pass = driver.findElement(By.id("react-select-3-input"));
        
        //Enter UserName and Password
        user.sendKeys("image_not_loading_user");
        user.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        pass.sendKeys("testingisfun99");
        pass.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@id='login-btn']")).click();
		Thread.sleep(5000);	
		
		String ProductAddedInCart = driver.findElement(By.xpath("//*[@class='product-title optimizedCheckout-contentPrimary']")).getText();
		System.out.println(ProductAddedInCart);
		Thread.sleep(2000);	
		
		String PriceAddedInCart = driver.findElement(By.xpath("//*[@class='product-price optimizedCheckout-contentPrimary']")).getText();
		System.out.println(PriceAddedInCart);
		Thread.sleep(2000);	
		
		
		String CartPrice = PriceAddedInCart.replaceAll("[$,]", "");
		System.out.println(CartPrice);
		
		Assert.assertEquals(getProduct, ProductAddedInCart);
		System.out.println("Product matched");
		
		Assert.assertEquals(getpricelist, CartPrice);
		System.out.println("Product Price match");
		

		
		Thread.sleep(1000);
		// driver.close();

		// Code for entering the text
		driver.findElement(By.xpath("//input[@id='firstNameInput']")).sendKeys("Test");
		Thread.sleep(300);

		driver.findElement(By.xpath("//input[@id='lastNameInput']")).sendKeys("Test");
		Thread.sleep(300);

		driver.findElement(By.xpath("//input[@id='addressLine1Input']")).sendKeys("Test");
		Thread.sleep(300);

		driver.findElement(By.xpath("//input[@id='provinceInput']")).sendKeys("Test");
		Thread.sleep(300);

		driver.findElement(By.xpath("//input[@id='postCodeInput']")).sendKeys("2166");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@id='checkout-shipping-continue']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping »')]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//strong[contains(text(),'Orders')]")).click();
		Thread.sleep(2000);

    }
	
}