package pages;

import com.titanium.framework.base.BasePage;
import com.titanium.framework.base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FindMoviesPage extends BasePage {

    public void selectMovie(String movie){
        DriverFactory.getInstance().getDriver().findElement(By.xpath("(//span[contains(text(),'"+movie+"')])[1]")).click();
    }

    public boolean getMovieName(String movie){
        WebElement movieTitle = DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[contains(text(),'"+movie+"')]"));
        return movieTitle.getText().contains(movie);
    }
}
