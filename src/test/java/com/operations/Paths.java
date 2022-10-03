package com.operations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Paths {


    By searchBox = By.xpath("/html/body/header/div/div/div[2]/div/div/div/input");

    By product = By.xpath("//*[@id=\"productList\"]/div[2]/div/div/div[1]");

    By productName = By.xpath("/html/body/div[3]/div[1]/div[1]/div[2]/div[2]/h1/span");

    By productPrice = By.xpath("//*[@id=\"priceNew\"]");

    By selectSize = By.xpath("//*[@id=\"sizes\"]/div/span[5]");


    By addtoBasket = By.xpath("//*[@id=\"addBasket\"]");
    By GoToBasket = By.xpath("//*[@id=\"addBasket\"]");
    By productDetailPrice = By.xpath("/html/body/div[1]/div/div/div/div[2]/div[1]/div[2]/ul/li[4]/span[2]");
    By quantity = By.xpath("//*[@id=\"quantitySelect0-key-0\"]");
    By quantityControl = By.xpath("//*[@id=\"quantitySelect0-key-0\"]");

  //  String control = driver.findElement(By.xpath("//*[@id=\"quantitySelect0-key-0\"]")).getAttribute("value");








}
