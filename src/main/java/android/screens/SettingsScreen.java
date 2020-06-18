package android.screens;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SettingsScreen {

    @Step("Action: Send keys to First Name input")
    public static void firstNameInputSendKeys(CharSequence... keysToSend) {
        $(Locator.firstNameInput).sendKeys(keysToSend);
    }

    @Step("Action: Send keys to Last Name input")
    public static void lastNameInputSendKeys(CharSequence... keysToSend) {
        $(Locator.lastNameInput).sendKeys(keysToSend);
    }

    @Step("Check: First Name input should be visible")
    public static void firstNameInputCheckVisibility() {
        $(Locator.firstNameInput).shouldBe(Condition.visible);
    }

    @Step("Check: Last input should be visible")
    public static void lastNameInputCheckVisibility() {
        $(Locator.lastNameInput).shouldBe(Condition.visible);
    }

    private static class Locator {
        private static final By firstNameInput = By.id("characterFirstName");
        private static final By lastNameInput = By.id("characterLastName");
        private static final By shakeBehaviourTitle = By.id("shakeBehaviourTitle");
        private static final By shakeBehaviourText = By.id("shakeBehaviourText");
        private static final By shakeBehaviourToggle = By.id("shakeBehaviourSwitch");
    }

    private static class Text {
        private static final String firstNameInput = "Character First Name";
        private static final String lastNameInput = "Character Last Name";
        private static final String shakeBehaviourTitle = "Shake Behaviour";
        private static final String shakeBehaviourTextShuffle = "Shake shuffles Chuck Jokes";
        private static final String shakeBehaviourTextShowsRandom = "Shake shows random Chuck Jokes";
    }
}
