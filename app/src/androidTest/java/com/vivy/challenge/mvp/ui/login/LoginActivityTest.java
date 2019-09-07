package com.vivy.challenge.mvp.ui.login;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;

import com.vivy.challenge.mvp.R;
import com.vivy.challenge.mvp.TestComponentRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by ELOUALI on 03/02/17.
 */
@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    public final TestComponentRule component =
            new TestComponentRule(InstrumentationRegistry.getTargetContext());

    public final IntentsTestRule<LoginActivity> main =
            new IntentsTestRule<>(LoginActivity.class, false, false);

    @Rule
    public TestRule chain = RuleChain.outerRule(component).around(main);

    @Before
    public void setup() {

    }


    @Test
    public void loginClickErrorEmptyEmail() {
        main.launchActivity(LoginActivity.getStartIntent(component.getContext()));

        String email = "";
        String password = getResourceString(R.string.default_vivy_password);

        onView(withId(R.id.et_email))
                .check(matches(isDisplayed()));
        onView(withId(R.id.et_password))
                .check(matches(isDisplayed()));

        onView((withId(R.id.et_email)))
                .perform(ViewActions.replaceText(email));
        onView(withId(R.id.et_password))
                .perform(ViewActions.replaceText(password));

        Espresso.closeSoftKeyboard();

        onView(withId(R.id.btn_server_login))
                .perform(ViewActions.click());

        onView(withText(getResourceString(R.string.empty_email)))
                .check(matches(withEffectiveVisibility(
                        ViewMatchers.Visibility.VISIBLE
                )));

    }

    @Test
    public void loginClickErrorInvalidEmail() {
        main.launchActivity(LoginActivity.getStartIntent(component.getContext()));

        String email = "androidChallenge";
        String password = getResourceString(R.string.default_vivy_password);

        onView((withId(R.id.et_email)))
                .perform(ViewActions.replaceText(email));
        onView(withId(R.id.et_password))
                .perform(ViewActions.replaceText(password));

        Espresso.closeSoftKeyboard();

        onView(withId(R.id.btn_server_login))
                .perform(ViewActions.click());

        onView(withText(getResourceString(R.string.invalid_email)))
                .check(matches(withEffectiveVisibility(
                        ViewMatchers.Visibility.VISIBLE
                )));

    }

    @Test
    public void loginClickErrorEmptyPassword() {
        main.launchActivity(LoginActivity.getStartIntent(component.getContext()));

        String email = getResourceString(R.string.default_vivy_username);
        String password = "";


        onView((withId(R.id.et_email)))
                .perform(ViewActions.replaceText(email));
        onView(withId(R.id.et_password))
                .perform(ViewActions.replaceText(password));

        Espresso.closeSoftKeyboard();

        onView(withId(R.id.btn_server_login))
                .perform(ViewActions.click());

        onView(withText(getResourceString(R.string.empty_password)))
                .check(matches(withEffectiveVisibility(
                        ViewMatchers.Visibility.VISIBLE
                )));
    }

    @Test
    public void loginClickSuccess() {
        main.launchActivity(LoginActivity.getStartIntent(component.getContext()));

        String email = getResourceString(R.string.default_vivy_username);
        String password = getResourceString(R.string.default_vivy_password);


        onView(withId(R.id.btn_server_login))
                .check(matches(isDisplayed()));

        onView((withId(R.id.et_email)))
                .perform(ViewActions.replaceText(email));
        onView(withId(R.id.et_password))
                .perform(ViewActions.replaceText(password));

        Espresso.closeSoftKeyboard();

        onView(withId(R.id.btn_server_login))
                .perform(ViewActions.click());

    }

    private String getResourceString(int id) {
        Context targetContext = InstrumentationRegistry.getTargetContext();
        return targetContext.getResources().getString(id);
    }

}