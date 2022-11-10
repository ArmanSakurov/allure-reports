package tests.demoqa;

import data.UserData;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class RegistrationFormTests extends TestBase {
    PracticeFormPage practiceFormPage = new PracticeFormPage();
    @Test
    void fillFormTests() {
        step("Fill registration form", () -> {
            practiceFormPage.openPage("/automation-practice-form")
                    .setFirstName(UserData.name)
                    .setLastName(UserData.lastName)
                    .setUserEmail(UserData.userEmail)
                    .setGenter(UserData.gender)
                    .setPhoneNumber(UserData.userNumber)
                    .setBirthDate(UserData.date, UserData.month, UserData.year)
                    .setSubject(UserData.subject)
                    .setHobbies(UserData.hobby)
                    .setPicture(UserData.picturePath)
                    .setAddress(UserData.currentAddress, UserData.state, UserData.city)
                    .clickSubmit()
            ;
        });
        step("Check form results", () -> {
            practiceFormPage.checkResultsTableVisible()
                    .checkResult("Student Name", UserData.name + " " + UserData.lastName)
                    .checkResult("Student Email", UserData.userEmail)
                    .checkResult("Gender", UserData.gender)
                    .checkResult("Mobile", UserData.userNumber)
                    .checkResult("Date of Birth", UserData.date + " " + UserData.month + "," + UserData.year)
                    .checkResult("Subjects", UserData.subject)
                    .checkResult("Hobbies", UserData.hobby)
                    .checkResult("Picture", "fox.jpg")
                    .checkResult("Address", UserData.currentAddress)
                    .checkResult("State and City", UserData.state + " " + UserData.city);
        });

//    @Test
//    void fillFormTest() {
//        step("Open registrations form", () -> {
//            open("/automation-practice-form");
//            $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
//            executeJavaScript("$('footer').remove()");
//            executeJavaScript("$('#fixedban').remove()");
//        });
//        step("Fill form", () -> {
//            $("#firstName").setValue("Alex");
//            $("#lastName").setValue("Egorov");
//            $("#userEmail").setValue("alex@egorov.com");
//            $("#genterWrapper").$(byText("Other")).click(); // best
//            $("#userNumber").setValue("1234567890");
//            $("#dateOfBirthInput").click();
//            $(".react-datepicker__month-select").selectOption("July");
//            $(".react-datepicker__year-select").selectOption("2008");
//            $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
//            $("#subjectsInput").setValue("Math").pressEnter();
//            $("#hobbiesWrapper").$(byText("Sports")).click(); // best
////            $("#uploadPicture").uploadFromClasspath("img/1.png");
//            $("#currentAddress").setValue("Some address 1");
//            $("#state").click();
//            $("#stateCity-wrapper").$(byText("NCR")).click();
//            $("#city").click();
//            $("#stateCity-wrapper").$(byText("Delhi")).click();
//            $("#submit").click();
//        });
//        step("Check form results", () -> {
//            $(".modal-dialog").should(appear);
//            $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
//
//            $(".table-responsive table").shouldHave(text("Alex"), text("Egorov"),
//                    text("alex@egorov.com"), text("1234567890"));
//        });
    }
}
