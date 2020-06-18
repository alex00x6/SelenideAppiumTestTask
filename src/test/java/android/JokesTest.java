package android;

import android.data.Jokes;
import android.screens.BottomMenu;
import android.screens.ChuckJokesScreen;
import android.screens.MyJokesScreen;
import android.screens.SettingsScreen;
import android.utils.AppiumListener;
import com.github.javafaker.Faker;
import io.qameta.allure.Feature;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AppiumListener.class)
public class JokesTest {

    @Feature("Bottom menu")
    @Test(description = "Check buttons functionality")
    public void bottomMenuButtonsTest() {
        BottomMenu.settingsButtonClick();
        SettingsScreen.firstNameInputCheckVisibility();
        BottomMenu.myJokesButtonClick();
        MyJokesScreen.addNewJokeButtonCheckVisibility();
        BottomMenu.chuckJokesButtonClick();
        ChuckJokesScreen.firstJokeTextCheckVisibility();
    }

    @Feature("My Jokes screen")
    @Test(description = "Check add joke & remove joke functional")
    public void myJokesAddJokeTest() {
        String myJokeText = Faker.instance().chuckNorris().fact();
        BottomMenu.myJokesButtonClick();
        MyJokesScreen.addNewJokeButtonClick();
        MyJokesScreen.emptyViewCheckInvisibility();
        MyJokesScreen.addNewJokePopupCheckVisibility();
        MyJokesScreen.addNewJokePopupInputSendKeys(myJokeText);
        MyJokesScreen.addNewJokePopupSaveButtonClick();
        MyJokesScreen.jokeItemCheckText(myJokeText);
        MyJokesScreen.jokeItemDeleteButtonClick();
        MyJokesScreen.emptyViewCheckVisibility();
    }

    @Feature("Chuck Jokes screen")
    @Test(description = "Check like functional")
    public void chuckJokesLikeTest() {
        ChuckJokesScreen.firstJokeTextCheckText();
        ChuckJokesScreen.firstJokeLikeButtonClick();
        BottomMenu.myJokesButtonClick();
        MyJokesScreen.jokeItemCheckText(Jokes.ribbedCondoms());
    }

    @Feature("Chuck Jokes screen")
    @Test(description = "Check dislike functional")
    public void chuckJokesDislikeTest() {
        ChuckJokesScreen.firstJokeTextCheckText();
        ChuckJokesScreen.firstJokeLikeButtonClick();
        BottomMenu.myJokesButtonClick();
        MyJokesScreen.jokeItemCheckText(Jokes.ribbedCondoms());
        BottomMenu.chuckJokesButtonClick();
        ChuckJokesScreen.firstJokeDislikeButtonClick();
        BottomMenu.myJokesButtonClick();
        MyJokesScreen.emptyViewCheckVisibility();
    }

    @Feature("Settings screen")
    @Test(description = "Joke customization functional")
    public void settingsJokeCustomizationTest() {
        String firstName = Faker.instance().name().firstName();
        String lastName = Faker.instance().name().lastName();

        ChuckJokesScreen.firstJokeTextCheckText();
        BottomMenu.settingsButtonClick();
        SettingsScreen.firstNameInputSendKeys(firstName);
        SettingsScreen.lastNameInputSendKeys(lastName);
        BottomMenu.chuckJokesButtonClick();
        ChuckJokesScreen.firstJokeTextCheckText(Jokes.ribbedCondoms(firstName, lastName));
    }

    @Feature("Chuck Jokes screen")
    @Test(description = "Check first joke text")
    public void chuckJokesFirstJokeTextTest() {
        ChuckJokesScreen.firstJokeTextCheckVisibility();
        ChuckJokesScreen.firstJokeTextCheckText();
    }

    @Feature("Chuck Jokes screen")
    @Test(description = "Check visibility of elements")
    public void chuckJokesElementVisibilityTest() {
        ChuckJokesScreen.firstJokeTextCheckVisibility();
        ChuckJokesScreen.firstJokeLikeButtonCheckVisibility();
        ChuckJokesScreen.firstJokeShareButtonCheckVisibility();
        ChuckJokesScreen.countJokeBlocks();
        ChuckJokesScreen.countVisibleJokeTexts();
    }

    @Feature("Bottom menu")
    @Test(description = "Check visibility of elements")
    public void bottomMenuElementVisibilityTest() {
        BottomMenu.chuckJokesButtonCheckVisibility();
        BottomMenu.myJokesButtonCheckVisibility();
        BottomMenu.settingsButtonCheckVisibility();
    }

    @Feature("Bottom menu")
    @Test(description = "Check text of elements")
    public void bottomMenuElementTextTest() {
        BottomMenu.chuckJokesButtonCheckText();
        BottomMenu.myJokesButtonCheckText();
        BottomMenu.settingsButtonCheckText();
    }

    @Feature("My Jokes screen")
    @Test(description = "Check empty screen")
    public void myJokesEmptyScreenTest() {
        BottomMenu.myJokesButtonClick();
        MyJokesScreen.addNewJokeButtonCheckVisibility();
        MyJokesScreen.emptyViewCheckText();
    }

    @Feature("Failed test example")
    @Test(description = "This test was meant to fail")
    public void failTest() {
        BottomMenu.myJokesButtonClick();
        SettingsScreen.firstNameInputCheckVisibility();
    }

}
