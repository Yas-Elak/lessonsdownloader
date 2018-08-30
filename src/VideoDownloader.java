import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class VideoDownloader {



    public static void main(String[] args) {

        String chromeDriverPath = "D:\\OneDrive\\Programmation\\Projet perso\\DdlHtml5Tag\\chromedriver_win32\\chromedriver.exe";
        String webDriverType = "webdriver.chrome.driver";

        String parentUrl = "https://codewithmosh.com/courses/enrolled/225147";
        String filePath = "D:\\OneDrive\\Programmation\\Projet perso\\DdlHtml5Tag\\";

        List<String> urlDownloadLink = new ArrayList<>();

        System.setProperty(webDriverType,chromeDriverPath);
        WebDriver driver = new ChromeDriver();

        Login login = new Login("https://sso.teachable.com/secure/146684/users/sign_in?clean_login=true&reset_purchase_session=1",
                "Elalaoui87@gmail.com", "Calibur87?");
        login.logMe(driver, "user_email", "user_password", "commit");

        RetrieveDownloadLink rdl = new RetrieveDownloadLink(driver);
        urlDownloadLink = rdl.getListOfDownloadLink(parentUrl);



        System.out.print("Check");
    }
}
