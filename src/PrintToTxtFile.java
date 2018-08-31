import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PrintToTxtFile {

    private List<String> urlDownloadLink;


    public PrintToTxtFile(List<String> urlDownloadLink){
        this.urlDownloadLink = urlDownloadLink;
    }

    public void generateTextFile(String whereToDownload, String urlCourse){
        try (BufferedWriter bw = new BufferedWriter
                (new FileWriter(whereToDownload+(urlCourse.substring(urlCourse.lastIndexOf('/')+1))
                        +".txt")))
        {
            for (String line : urlDownloadLink) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
