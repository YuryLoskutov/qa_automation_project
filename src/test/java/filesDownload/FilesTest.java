package filesDownload;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class FilesTest {

    @Test
    void selenideDownloadTest() throws Exception {
        open("https://github.com/junit-team/junit5/blob/main/README.md");
        File downloadedFile = $("#raw-url").download();

        // Делает то же, что и String readString = Files......
        try (InputStream is = new FileInputStream(downloadedFile)){
            is.readAllBytes();
            assertThat(new String(is.readAllBytes(), UTF_8).contains("This repository is the home of the next generation of JUnit"));
            is.close();
        }
        // Делает то же, что и try(InputStream is....), но это из новой джавы
        String readString = Files.readString(downloadedFile.toPath(), UTF_8);
    }

    @Test
    void uploadSelenideTest() {
        open("https://the-internet.herokuapp.com/upload");
        $("input[type = 'file']")
        //        .uploadFile( new File("D:\\Idea\\Projects\\test_repo\\src\\test\\resources\\files\\1.txt"));
                .uploadFromClasspath( "files/1.txt");
        $("#file-submit").click();
        $("div.example").shouldHave(Condition.text("File Uploaded!"));
        $("#uploaded-files").shouldHave(Condition.text("1.txt"));
    }

}