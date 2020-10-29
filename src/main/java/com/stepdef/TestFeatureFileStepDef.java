package com.stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class TestFeatureFileStepDef {
	
	public static WebDriver chromeDriver;
	
	@Given("^I launch the url$")
	public void i_launch_the_url() throws Throwable {
		final ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu");
        options.addArguments("--headless");
        options.addArguments("--window-size=1366,768");
        options.addArguments("--single-process");
        options.addArguments("--no-sandbox");
        options.addArguments("--user-data-dir=/tmp/user-data");
        options.addArguments("--data-path=/tmp/data-path");
        options.addArguments("--homedir=/tmp");
        options.addArguments("--disk-cache-dir=/tmp/cache-dir");

        if (System.getProperty("chrome.binary") != null) {
            options.setBinary(System.getProperty("chrome.binary"));
        }
        
        DesiredCapabilities capabilities =  new DesiredCapabilities();
        
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(capabilities);
        chromeDriver = new ChromeDriver(options);
        
	    //chromeDriver = new ChromeDriver();
	    chromeDriver.get("https://google.com");
	}

	@Given("^get the value$")
	public void get_the_value() throws Throwable {
		String getText = chromeDriver.findElement(By.xpath("//*[@id=\"gbw\"]/div/div/div[1]/div[1]/a")).getText();
		System.out.println(getText);
	}

	@Then("^it should be correct$")
	public void it_should_be_correct() throws Throwable {

		chromeDriver.quit();
	}



}
