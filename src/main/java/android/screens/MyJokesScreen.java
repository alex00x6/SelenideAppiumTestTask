package android.screens;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MyJokesScreen {

    @Step("Action: Click on New Joke button")
    public static void addNewJokeButtonClick() {
        $(Locator.addNewJokeButton).click();
    }

    @Step("Action: Click on Add New Joke pop-up Save button")
    public static void addNewJokePopupSaveButtonClick() {
        $(Locator.addNewJokePopupSaveButton).click();
    }

    @Step("Action: Click on Joke Item Delete button")
    public static void jokeItemDeleteButtonClick() {
        $(Locator.jokeItemDeleteButton).click();
    }

    @Step("Check: Add New button should be visible")
    public static void addNewJokeButtonCheckVisibility() {
        $(Locator.addNewJokeButton).shouldBe(Condition.visible);
    }

    @Step("Check: Empty View should be NOT visible")
    public static void emptyViewCheckInvisibility() {
        $(Locator.emptyViewText).shouldBe(Condition.not(Condition.visible));
    }

    @Step("Check: Empty View should be visible")
    public static void emptyViewCheckVisibility() {
        $(Locator.emptyViewText).shouldBe(Condition.visible);
    }

    @Step("Check: Empty View text equals expected")
    public static void emptyViewCheckText() {
        $(Locator.emptyViewText).shouldHave(Condition.exactText(Text.emptyViewText));
    }

    @Step("Check: Joke Item text equals expected")
    public static void jokeItemCheckText(String expectedText) {
        $(Locator.jokeItemText).shouldHave(Condition.exactText(expectedText));
    }

    @Step("Check: Add New Joke pop-up title should be visible")
    public static void addNewJokePopupCheckVisibility() {
        $(Locator.addNewJokePopupTitle).shouldBe(Condition.visible);
    }

    @Step("Action: Send keys to Add New Joke pop-up input")
    public static void addNewJokePopupInputSendKeys(CharSequence... keysToSend) {
        $(Locator.addNewJokePopupInput).sendKeys(keysToSend);
    }

    private static class Locator {
        private static final By addNewJokeButton = By.id("addFab");
        private static final By emptyViewText = By.id("emptyView");

        private static final By addNewJokePopupTitle = By.id("title");
        private static final By addNewJokePopupInput = By.id("editText");
        private static final By addNewJokePopupCancelButton = By.id("cancelButton");
        private static final By addNewJokePopupSaveButton = By.id("saveButton");

        private static final By jokeItemText = By.id("text");
        private static final By jokeItemDeleteButton = By.id("deleteButton");
    }

    private static class Text {
        private static final String addNewJokePopupTitle = "Add New Joke";
        private static final String emptyViewText = "There are not jokes to display at the moment. Populate " +
                "the list by clicking 'Like' in Chuck Jokes list or adding custom joke with via the button in" +
                " the bottom right.";
    }
}
