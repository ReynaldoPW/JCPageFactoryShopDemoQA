package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
    private WebDriver driver;

    public ProductPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "pa_color")
    WebElement selectColor;

    @FindBy(id = "pa_size")
    WebElement selectSize;

    @FindBy(css = ".single_add_to_cart_button")
    WebElement addToCartButton;


    @FindBy(css = "a[class='custom-logo-link'] img[alt='ToolsQA Demo Site']")
    WebElement homepage;

    @FindBy(css = ".noo-product-inner")
    WebElement productLink;
    public void setAddToCartButton(String color, String size){
        JavascriptExecutor js =(JavascriptExecutor) driver;
        homepage.click();
        js.executeScript("arguments[0].click();", productLink);
        productLink.click();
        js.executeScript("window.scrollBy(0,400)");
        Select colorSelect= new Select(selectColor);
        colorSelect.selectByValue(color);
        Select sizeSelect = new Select(selectSize);
        sizeSelect.selectByValue(size);
        addToCartButton.click();
    }
}
