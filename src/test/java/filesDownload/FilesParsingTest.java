package filesDownload;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.opencsv.CSVReader;
import filesDownload.domain.Teacher;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Java6Assertions.assertThat;


public class FilesParsingTest {

    @Test
    void parsePdfTest () throws Exception {
        open("https://junit.org/junit5/docs/current/user-guide/");
        File pdfDownload = $(byText("PDF download")).download();
        PDF pdf = new PDF(pdfDownload);
        assertThat(pdf.author).contains("Marc Philipp");
    }

    @Test
    void parseXlsTest() throws Exception{
        open("http://romashka2008.ru/price");
        File xlsDownload = $(".site-main__inner a[href*='prajs_ot']").download();
        XLS xls = new XLS(xlsDownload);
        assertThat(xls.excel
                .getSheetAt(0)
                .getRow(11)
                .getCell(1)
                .getStringCellValue()).contains("Сахалинская обл, Южно-Сахалинск");

    }

    @Test
    void parseCsvFTest() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        try (InputStream is = classLoader.getResourceAsStream("files/business-financial-data-sep-2021-quarter.csv");
             CSVReader reader = new CSVReader(new InputStreamReader(is))) {
            List<String[]> content =  reader.readAll();
            assertThat(content.get(0)).contains(
                    "Series_reference",
                    "Period",
                    "Data_value",
                    "Suppressed",
                    "STATUS",
                    "UNITS",
                    "Magnitude",
                    "Subject",
                    "Group",
                    "Series_title_1",
                    "Series_title_2",
                    "Series_title_3",
                    "Series_title_4",
                    "Series_title_5");
        }

    }

    @Test
    void parseZipTest() throws Exception {
        try (InputStream is = classLoader.getResourceAsStream("files/sample-zip-file.zip");
             ZipInputStream zis = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                assertThat(entry.getName()).isEqualTo("sample.txt");
            }
        }
    }

    @Test
    void jsonCommonTest() throws Exception {
        Gson gson = new Gson();
        try (InputStream is = classLoader.getResourceAsStream("files/simple.json")) {
            String json = new String(is.readAllBytes(), StandardCharsets.UTF_8);
            JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
            assertThat(jsonObject.get("name").getAsString()).isEqualTo("Yury");
            assertThat(jsonObject.get("address").getAsJsonObject().get("street").getAsString()).isEqualTo("Mira");
        }
    }

    @Test
    void jsonTypeTest() throws Exception {
        Gson gson = new Gson();
        try (InputStream is = classLoader.getResourceAsStream("files/simple.json")) {
            String json = new String(is.readAllBytes(), StandardCharsets.UTF_8);
            Teacher jsonObject = gson.fromJson(json, Teacher.class);
            assertThat(jsonObject.name).isEqualTo("Yury");
            assertThat(jsonObject.address.street).isEqualTo("Mira");
        }
    }
}
