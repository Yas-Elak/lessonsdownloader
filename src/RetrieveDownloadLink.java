import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

public class RetrieveDownloadLink {

    WebDriver driver;

    RetrieveDownloadLink(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * I have a link who contains all the links who go to the different lessons.
     * Each Lessons have one link to download the video
     * the link to download the video has an ID tag "download"
     * from the first link I need t get all the lessons and then I need to get each download link of each lesson
     *
     * @return : list of download Links
     */
    public List<String> getListOfDownloadLink(String urlCourse) {
        List<String> urlLessons = new ArrayList<>();
        List<String> urlDownloadLink = new ArrayList<>();
        driver.get(urlCourse);
        //from one link I get all the lessons link
        List<WebElement> lessonsLink = driver.findElements(By.tagName("a"));
        for (WebElement element : lessonsLink) {
            urlLessons.add(String.valueOf(element.getAttribute("href")));
        }
        //Now that I have all the lessons Link I need to extract the download Link From Each Lessons
        // For my Site, the downloadble link has a classname : download, SO I get all the download class then
        //i Take only the href and put it in a list
        for(String str: urlLessons){
            driver.get(str);
            try {
                WebElement webEle = driver.findElement(By.className("download"));
                urlDownloadLink.add(String.valueOf(webEle.getAttribute("href")));
            } catch (Exception e) {
                System.out.println("No Download Tag");
            }
        }

        return urlDownloadLink;
    }
}