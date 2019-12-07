package com.example.espresso_demo;

import androidx.test.espresso.action.ScrollToAction;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.pressBack;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;

import static androidx.test.espresso.action.ViewActions.typeText;

import static androidx.test.espresso.action.ViewActions.click;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static org.hamcrest.Matchers.not;


@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {


    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule =
            new ActivityTestRule<>(LoginActivity.class);

    @Rule
    public ActivityTestRule<WelcomeActivity> mActivityRule1 =
            new ActivityTestRule<>(WelcomeActivity.class);

    @Test
    public void testHintandTextOnWidgets() {
        onView(withId(R.id.username)).check(matches(withHint("User name")));
        onView(withId(R.id.password)).check(matches(withHint("Password")));
        onView(withId(R.id.login)).check(matches(withText("Login")));
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void onLoginFailure() {

        onView(withId(R.id.username)).perform(typeText("Jason1994"),closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText("123456"),closeSoftKeyboard());

        onView(withId(R.id.username)).perform(clearText(),closeSoftKeyboard());
        onView(withId(R.id.login)).perform(click());
        onView(withId(R.id.error)).check(matches(isDisplayed()))
        .check(matches(withText("Please enter username and password")));
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
    @Test
    public void onLoginSuccessful() {
        onView(withId(R.id.error)).check(matches(not(isDisplayed())));
        onView(withId(R.id.username)).perform(typeText("Jason1994"),closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText("123456"),closeSoftKeyboard());
        onView(withId(R.id.login)).perform(click());
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void onWebViewTest() {
        onLoginSuccessful();
        onView(withId(R.id.welcome_text)).perform(click());
        pressBack();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void onCheckBoxCheck() {
        onLoginSuccessful();
        onView(withId(R.id.checkbox)).perform(click());
        onView(withId(R.id.checkbox)).check(matches(isChecked()));
        onView(withId(R.id.showlistbtn)).check(matches(isEnabled()));
        onView(withId(R.id.showlistbtn)).perform(click());
        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void onCheckBoxNotChecked() {
        onLoginSuccessful();
        onView(withId(R.id.checkbox)).check(matches(not(isChecked())));
        onView(withId(R.id.showlistbtn)).check(matches(not(isEnabled())));
        onView(withId(R.id.showlistbtn)).check(matches(withText("No List")));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


