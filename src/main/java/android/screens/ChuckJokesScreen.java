package android.screens;

import android.data.Jokes;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ChuckJokesScreen {

    @Step("Action: First Joke click Like button")
    public static void firstJokeLikeButtonClick() {
        $(Locator.jokeLikeButton).click();
    }

    @Step("Action: First Joke click Dislike button")
    public static void firstJokeDislikeButtonClick() {
        $(Locator.jokeDislikeButton).click();
    }

    @Step("Check: First Joke text equals expected")
    public static void firstJokeTextCheckText() {
        $(Locator.jokeText).shouldBe(Condition.exactText(Jokes.ribbedCondoms()));
    }

    @Step("Check: First Joke text equals expected")
    public static void firstJokeTextCheckText(String expectedText) {
        $(Locator.jokeText).shouldBe(Condition.exactText(expectedText));
    }

    @Step("Check: First Joke text should be visible")
    public static void firstJokeTextCheckVisibility() {
        $(Locator.jokeText).shouldBe(Condition.visible);
    }

    @Step("Check: First Joke like button should be visible")
    public static void firstJokeLikeButtonCheckVisibility() {
        $(Locator.jokeLikeButton).shouldBe(Condition.visible);
    }

    @Step("Check: First Joke share button should be visible")
    public static void firstJokeShareButtonCheckVisibility() {
        $(Locator.jokeShareButton).shouldBe(Condition.visible);
    }

    @Step("Check: Expecting 6 jokes to be present")
    public static void countJokeBlocks() {
        $$(Locator.jokeBlock).shouldHave(CollectionCondition.size(6));
    }

    @Step("Check: Expecting 6 jokes texts to be visible")
    public static void countVisibleJokeTexts() {
        $$(Locator.jokeText).shouldBe(CollectionCondition.size(6)).forEach(v -> v.shouldBe(Condition.visible));
    }

    private static class Locator {
        private static final By jokeText = By.id("text");
        private static final By jokeShareButton = By.id("shareButton");
        private static final By jokeLikeButton = By.id("likeButton");
        private static final By jokeDislikeButton = By.id("dislikeButton");
        private static final By jokeBlock = By.xpath("//*[@resource-id='ee.paxful.icndb:id/recyclerView']//android.view.ViewGroup");
    }

    public static class Text {
    }
}
