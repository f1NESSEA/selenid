package ru.netology;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
//import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.files.DownloadActions.click;


public class CardTest {



    public String generateDate(int daysToAdd, String pattern) {
        return LocalDate.now().plusDays(daysToAdd).format(DateTimeFormatter.ofPattern(pattern));
    }


    @Test
    void shouldTestSomething() {

        open("http://localhost:7777/");
        $("[data-test-id=city] input").setValue("Рязань");
        // $("[data-test-id=date] input").click();
        $("[data-test-id=date] input").doubleClick();
        $("[data-test-id=date] input").sendKeys(Keys.BACK_SPACE);
        String meetDate = generateDate(4, "dd.MM.yyyy");
        $("[data-test-id=date] input").setValue(meetDate);
        $("[data-test-id=name] input").setValue("Джонни Уокер");
        $("[name='phone']").setValue("+73409514575");
        $("[data-test-id=agreement").click();
        $(byClassName("button")).click();
        $("[data-test-id=notification").shouldHave(Condition.text("Встреча успешно забронирована на " + meetDate),Duration.ofSeconds(15)).shouldBe(visible);

    }
}
