package pages;

import io.cucumber.java.it.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utilities.*;

public class MainPage {

    public static WebElement name;
    public static WebElement phone;
    public static WebElement gender;

    public MainPage(){
        PageFactory.initElements(Driver.get(),this);

    }

    public static void getByIndex(int index){

        name = Driver.get().findElement(By.xpath("//td[contains(text()," + "'" + index + "'" + ")]/following-sibling::td[1]"));
        phone = Driver.get().findElement(By.xpath("//td[contains(text()," + "'" + index + "'" + ")]/following-sibling::td[2]"));
        gender = Driver.get().findElement(By.xpath("//td[contains(text()," + "'" + index + "'" + ")]/following-sibling::td[3]"));
    }


}
