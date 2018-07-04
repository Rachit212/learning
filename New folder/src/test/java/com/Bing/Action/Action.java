package com.Bing.Action;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;

import java.awt.Window;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Action {
	WebDriver driver;

	public void Load_Driver() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
	}

	public void Set_Path() {
		driver.get("https://www.bing.com/translator");
		driver.manage().window().maximize();
	}

	public void Select_Language() {
		Select language = new Select(driver.findElement(By.xpath("//select[@id='t_tl']")));
		language.selectByVisibleText("Hindi");
	}

	public void Give_Input() {
		WebElement input = driver.findElement(By.xpath("//textarea[@id='t_sv']"));
		input.sendKeys("hello");
	}

	public void Check_Clear_Button() {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@h='ID=translator,5011.1']")));
		driver.findElement(By.xpath("//a[@h='ID=translator,5011.1']")).click();

	}

	public void Swap_Values() throws InterruptedException {
		Thread.sleep(1000);
		WebDriverWait wait1 = new WebDriverWait(driver, 1000);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[placeholder='Translation']")));
		driver.findElement(By.cssSelector("#rich_tltr .ttop_switch")).click();
		WebElement translate = driver.findElement(By.xpath("//textarea[@readonly]"));
		String trn = translate.getText();
		Assert.assertEquals(trn, "Hello");
		System.out.println("true");
	}
}
