import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class VideoDownloader {



    public static void main(String[] args) {

        // Starting by initializing the different path I will need
        //first for selenium
        String chromeDriverPath = "Path to the chromedriver.exe";
        String webDriverType = "webdriver.chrome.driver";

        //then for the course I want to download and where I want to download it
        String urlCourse = "url of the course who get all the lessons";
        String whereToDownload = "path of where I want to download them";

        List<String> urlDownloadLink;
        List<String> nameOfTheLesson;

        //I set up selenium
        System.setProperty(webDriverType,chromeDriverPath);
        WebDriver driver = new ChromeDriver();

        //if i need to be logged on the website I use this object
        Login login = new Login("url of the login page",
                "my username", "my password");
        login.logMe(driver, "user_email", "user_password", "commit");

        //then I retrieve the different link to download and a name because their link are something like .../1565616
        RetrieveDownloadLink rdl = new RetrieveDownloadLink(driver);
        urlDownloadLink = rdl.getListOfDownloadLink(urlCourse);
        nameOfTheLesson = rdl.getNameOfTheLessons();

        //If I ever want to use a different software to download them, I create a text file with the link to download
        PrintToTxtFile printToTxtFile = new PrintToTxtFile(urlDownloadLink);
        printToTxtFile.generateTextFile(whereToDownload, urlCourse);

        //I download them (still slow but the website I want is already slow)
        HttpDownloadUtility hdu = new HttpDownloadUtility();
        try {
            hdu.downloadFile(urlDownloadLink, whereToDownload, nameOfTheLesson);
        } catch (Exception e){
            e.printStackTrace();
        }


    }
}
