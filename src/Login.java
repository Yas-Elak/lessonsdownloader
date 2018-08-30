import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

    String loginUrl;
    String username;
    String password;


    public Login(String loginUrl, String username, String password){
        this.loginUrl = loginUrl;
        this.username = username;
        this.password = password;
    }

    public void logMe(WebDriver driver, String idUsername, String IdPassword, String nameLogButton){
        driver.get(loginUrl);
        driver.findElement(By.id(idUsername)).sendKeys(username);
        driver.findElement(By.id(IdPassword)).sendKeys(password);
        driver.findElement(By.name(nameLogButton)).click();
    }


}
