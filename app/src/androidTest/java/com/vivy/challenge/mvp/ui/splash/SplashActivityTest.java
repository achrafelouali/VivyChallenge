package com.vivy.challenge.mvp.ui.splash;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.intent.rule.IntentsTestRule;
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
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by ELOUALI on 03/02/17.
 */
@RunWith(AndroidJUnit4.class)
public class SplashActivityTest {

    public final TestComponentRule component =
            new TestComponentRule(InstrumentationRegistry.getTargetContext());

    public final IntentsTestRule<SplashActivity> main =
            new IntentsTestRule<>(SplashActivity.class, false, false);

    @Rule
    public TestRule chain = RuleChain.outerRule(component).around(main);

    @Before
    public void setup() {

    }


    @Test
    public void LaunchSplachScreenTest() {
        main.launchActivity(SplashActivity.getStartIntent(component.getContext()));

        onView(withId(R.id.pb_loading))
                .check(matches(isDisplayed()));
        onView(withId(R.id.tv_title))
                .check(matches(isDisplayed()));
        onView(withId(R.id.tv_message))
                .check(matches(isDisplayed()));

    }


}