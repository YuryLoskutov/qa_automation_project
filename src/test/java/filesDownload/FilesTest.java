package filesDownload;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FilesTest {
    @Test
    void selenideDownloadTest() throws FileNotFoundException {
        open("https://github.com/junit-team/junit5#readme");
        File downloadFile = $("#url").download();


    }

}
