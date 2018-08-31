import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class RetrieveDownloadLink {

    private WebDriver driver;
    private List<String> nameOfTheLessons = new ArrayList<>();
    private List<String> urlDownloadLink = new ArrayList<>();

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

        String urlLesson;
        List<String> urlLessons = new ArrayList<>();
        driver.get(urlCourse);

        //from one link I get all the lessons link
        List<WebElement> lessonsLink = driver.findElements(By.tagName("a"));
        for (WebElement element : lessonsLink) {
            urlLesson = String.valueOf(element.getAttribute("href"));
            if (urlLesson.contains("lectures"))
                urlLessons.add(urlLesson);
        }

        //Now that I have all the lessons Link I need to extract the download Link From Each Lessons
        // For my Site, the downloadble link has a classname : download, SO I get all the download class then
        //i Take only the href and put it in a list
        //Later I want to download the link so I will need a name for the file
        //in another list I will put the name of the file at the same time
        for(String str: urlLessons){
            driver.get(str);
            try {
                WebElement urlLink = driver.findElement(By.className("download"));
                WebElement linkName = driver.findElement(By.id("lecture_heading"));
                urlDownloadLink.add(urlLink.getAttribute("href"));
                nameOfTheLessons.add(linkName.getText().trim());
            } catch (Exception e) {
                System.out.println("No Download Tag");
               // e.printStackTrace();
            }
        }

        return urlDownloadLink;
    }

    public List<String> getNameOfTheLessons() {
        return nameOfTheLessons;
    }


}