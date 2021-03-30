package ru.netology.web;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

class DeliveryOrderTest {
    LocalDate today = LocalDate.now();
    LocalDate newDate = today.plusDays(3);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @Test
    void shouldFormFilledOutCorrectly() {
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Москва");
        $("[data-test-id='date'] .input__control").doubleClick().sendKeys(formatter.format(newDate));
        $("[data-test-id='name'] input").setValue("Николай Римский-Корсаков");
        $("[data-test-id='phone'] input").setValue("+12345678901");
        $("[data-test-id='agreement']").click();
        $$(".button").find(exactText("Забронировать")).click();
        $(byText("Успешно!")).shouldBe(visible, Duration.ofMillis(15000));
    }

//    @Test
//    void shouldIncorrectFillingCity() {
//        open("http://localhost:9999");
//        $("[data-test-id='city'] input").setValue("Майский");
//        $("[data-test-id='date'] .input__control").doubleClick().sendKeys(formatter.format(newDate));
//        $("[data-test-id='name'] input").setValue("Николай Римский-Корсаков");
//        $("[data-test-id='phone'] input").setValue("+12345678901");
//        $("[data-test-id='agreement']").click();
//        $$(".button").find(exactText("Забронировать")).click();
//        $("[data-test-id='city'] .input__sub").shouldHave(exactText("Доставка в выбранный город недоступна"));
//    }
//
//    @Test
//    void shouldIncorrectFillingDate() {
//        newDate = today.plusDays(2);
//        open("http://localhost:9999");
//        $("[data-test-id='city'] input").setValue("Москва");
//        $("[data-test-id='date'] .input__control").doubleClick().sendKeys(formatter.format(newDate));
//        $("[data-test-id='name'] input").setValue("Николай Римский-Корсаков");
//        $("[data-test-id='phone'] input").setValue("+12345678901");
//        $("[data-test-id='agreement']").click();
//        $$(".button").find(exactText("Забронировать")).click();
//        $("[data-test-id='date'] .input__sub").shouldHave(exactText("Заказ на выбранную дату невозможен"));
//    }
//
//    @Test
//    void shouldIncorrectFillingName() {
//        open("http://localhost:9999");
//        $("[data-test-id='city'] input").setValue("Москва");
//        $("[data-test-id='date'] .input__control").doubleClick().sendKeys(formatter.format(newDate));
//        $("[data-test-id='name'] input").setValue("Alex Smith");
//        $("[data-test-id='phone'] input").setValue("+12345678901");
//        $("[data-test-id='agreement']").click();
//        $$(".button").find(exactText("Забронировать")).click();
//        $("[data-test-id='name'] .input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
//    }
//
//    @Test
//    void shouldIncorrectFillingPhone() {
//        open("http://localhost:9999");
//        $("[data-test-id='city'] input").setValue("Москва");
//        $("[data-test-id='date'] .input__control").doubleClick().sendKeys(formatter.format(newDate));
//        $("[data-test-id='name'] input").setValue("Николай Римский-Корсаков");
//        $("[data-test-id='phone'] input").setValue("1234567890");
//        $("[data-test-id='agreement']").click();
//        $$(".button").find(exactText("Забронировать")).click();
//        $("[data-test-id='phone'] .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
//    }
//
//    @Test
//    void shouldCheckboxIsNotSelected() {
//        open("http://localhost:9999");
//        $("[data-test-id='city'] input").setValue("Москва");
//        $("[data-test-id='date'] .input__control").doubleClick().sendKeys(formatter.format(newDate));
//        $("[data-test-id='name'] input").setValue("Николай Римский-Корсаков");
//        $("[data-test-id='phone'] input").setValue("+12345678901");
//        $$(".button").find(exactText("Забронировать")).click();
//        $("[data-test-id='agreement'].input_invalid .checkbox__text").shouldHave(exactText("Я соглашаюсь с условиями обработки и использования моих персональных данных"));
//    }
//
//    @Test
//    void shouldFieldCityIsEmpty() {
//        open("http://localhost:9999");
//        $("[data-test-id='city'] input").setValue("");
//        $("[data-test-id='date'] .input__control").doubleClick().sendKeys(formatter.format(newDate));
//        $("[data-test-id='name'] input").setValue("Николай Римский-Корсаков");
//        $("[data-test-id='phone'] input").setValue("+12345678901");
//        $("[data-test-id='agreement']").click();
//        $$(".button").find(exactText("Забронировать")).click();
//        $("[data-test-id='city'].input_invalid .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
//    }
//
//    @Test
//    void shouldFieldDateIsEmpty() {
//        open("http://localhost:9999");
//        $("[data-test-id='city'] input").setValue("Москва");
//        $("[data-test-id='date'] .input__control").doubleClick().sendKeys(" ");
//        $("[data-test-id='name'] input").setValue("Николай Римский-Корсаков");
//        $("[data-test-id='phone'] input").setValue("+12345678901");
//        $("[data-test-id='agreement']").click();
//        $$(".button").find(exactText("Забронировать")).click();
//        $("[data-test-id='date'] .input__sub").shouldHave(exactText("Неверно введена дата"));
//    }
//
//    @Test
//    void shouldFieldNameIsEmpty() {
//        open("http://localhost:9999");
//        $("[data-test-id='city'] input").setValue("Москва");
//        $("[data-test-id='date'] .input__control").doubleClick().sendKeys(formatter.format(newDate));
//        $("[data-test-id='name'] input").setValue("");
//        $("[data-test-id='phone'] input").setValue("+12345678901");
//        $("[data-test-id='agreement']").click();
//        $$(".button").find(exactText("Забронировать")).click();
//        $("[data-test-id='name'].input_invalid .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
//    }
//
//    @Test
//    void shouldPhoneFieldIsEmpty() {
//        open("http://localhost:9999");
//        $("[data-test-id='city'] input").setValue("Москва");
//        $("[data-test-id='date'] .input__control").doubleClick().sendKeys(formatter.format(newDate));
//        $("[data-test-id='name'] input").setValue("Николай Римский-Корсаков");
//        $("[data-test-id='phone'] input").setValue(" ");
//        $("[data-test-id='agreement']").click();
//        $$(".button").find(exactText("Забронировать")).click();
//        $("[data-test-id='phone'].input_invalid .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
//    }
//
//    @Test
//    void shouldSubmittingEmptyForm() {
//        open("http://localhost:9999");
//        $("[data-test-id='city'] input").setValue("");
//        $("[data-test-id='date'] .input__control").doubleClick().sendKeys(" ");
//        $("[data-test-id='name'] input").setValue(" ");
//        $("[data-test-id='phone'] input").setValue(" ");
//        $$(".button").find(exactText("Забронировать")).click();
//        $("[data-test-id='city'].input_invalid .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
//    }
}

