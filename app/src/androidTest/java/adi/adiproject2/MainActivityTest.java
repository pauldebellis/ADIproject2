package adi.adiproject2;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by klaus_000 on 9/7/2016.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void testCategoriesShown() throws Exception{

        onView(withId(R.id.modList))
                .check(matches(isDisplayed()));
    }

    @Test
    public void testAddButtonOpensAddModView() throws Exception{

        onView(withId(R.id.addButton))
                .perform(click());

        onView(withId(R.id.finalizeMod))
                .check(matches(isDisplayed()));

        onView(withId(R.id.enterModName))
                .check(matches(isDisplayed()));

        onView(withId(R.id.enterModDescription))
                .check(matches(isDisplayed()));

        onView(withId(R.id.enterModEndorsements))
                .check(matches(isDisplayed()));

        onView(withId(R.id.enterModCategory))
                .check(matches(isDisplayed()));
    }

    @Test
    public void testAddMod() throws Exception{


    }
}
