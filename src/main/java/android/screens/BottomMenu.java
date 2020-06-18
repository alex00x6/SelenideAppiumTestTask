package android.screens;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BottomMenu {

    @Step("Action: Click on Chuck Jokes button")
    public static void chuckJokesButtonClick() {
        $(Locator.chuckJokesButton).click();
    }

    @Step("Action: Click on My Jokes button")
    public static void myJokesButtonClick() {
        $(Locator.myJokesButton).click();
    }

    @Step("Action: Click on Settings button")
    public static void settingsButtonClick() {
        $(Locator.settingsButton).click();
    }

    @Step("Check: Chuck Jokes button should be visible")
    public static void chuckJokesButtonCheckVisibility() {
        $(Locator.chuckJokesButton).shouldBe(Condition.visible);
    }

    @Step("Check: My Jokes button should be visible")
    public static void myJokesButtonCheckVisibility() {
        $(Locator.myJokesButton).shouldBe(Condition.visible);
    }

    @Step("Check: Settings button should be visible")
    public static void settingsButtonCheckVisibility() {
        $(Locator.settingsButton).shouldBe(Condition.visible);
    }

    @Step("Check: Chuck Jokes button text equals expected")
    public static void chuckJokesButtonCheckText() {
        $(Locator.chuckJokesButtonText).shouldHave(Condition.exactText(Text.chuckJokesButtonText));
    }

    @Step("Check: My Jokes button text equals expected")
    public static void myJokesButtonCheckText() {
        $(Locator.myJokesButtonText).shouldHave(Condition.exactText(Text.myJokesButtonText));
    }

    @Step("Check: Settings button text equals expected")
    public static void settingsButtonCheckText() {
        $(Locator.settingsButtonText).shouldHave(Condition.exactText(Text.settingsButtonText));
    }

    private static class Locator {
        private static final By chuckJokesButton = By.id("menu_chuck_jokes");
        private static final By chuckJokesButtonText = By.xpath("//*[@resource-id='ee.paxful.icndb:id/menu_chuck_jokes']//android.widget.TextView");
        private static final By myJokesButton = By.id("menu_my_jokes");
        private static final By myJokesButtonText = By.xpath("//*[@resource-id='ee.paxful.icndb:id/menu_my_jokes']//android.widget.TextView");
        private static final By settingsButton = By.id("menu_settings");
        private static final By settingsButtonText = By.xpath("//*[@resource-id='ee.paxful.icndb:id/menu_settings']//android.widget.TextView");
    }

    private static class Text {
        private static final String chuckJokesButtonText = "Chuck Jokes";
        private static final String myJokesButtonText = "My Jokes";
        private static final String settingsButtonText = "Settings";
    }
}
