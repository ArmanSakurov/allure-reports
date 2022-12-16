package tests.demoqa;

import data.UserData;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

import static io.qameta.allure.Allure.step;

public class PracticeFormTests extends TestBase {
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
                    .clickSubmit();
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
    }
}
