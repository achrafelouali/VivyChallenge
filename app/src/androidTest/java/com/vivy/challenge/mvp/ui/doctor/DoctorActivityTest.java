package com.vivy.challenge.mvp.ui.doctor;

/**
 * Created by ELOUALI Achraf on 07/09/2019.
 */


import android.app.Activity;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;

import com.vivy.challenge.mvp.R;
import com.vivy.challenge.mvp.TestComponentRule;
import com.vivy.challenge.mvp.ui.doctors.DoctorActivity;
import com.vivy.challenge.mvp.ui.splash.SplashActivity;

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
public class DoctorActivityTest {

    public final TestComponentRule component =
            new TestComponentRule(InstrumentationRegistry.getTargetContext());

    public final IntentsTestRule<DoctorActivity> main =
            new IntentsTestRule<>(DoctorActivity.class, false, false);

    @Rule
    public TestRule chain = RuleChain.outerRule(component).around(main);

    @Before
    public void setup() {

    }


    @Test
    public void LaunchSplachScreenTest() {
        Activity activity = main.launchActivity(SplashActivity.getStartIntent(component.getContext()));

        onView(withId(R.id.et_server_search))
                .check(matches(isDisplayed()));
        onView(withId(R.id.btn_server_search))
                .check(matches(isDisplayed()));
        onView(withId(R.id.doctor_recycler_view))
                .check(matches(isDisplayed()));

        onView(withId(R.id.et_server_search))
                .perform(ViewActions.replaceText("Frank"));

        Espresso.closeSoftKeyboard();

        onView(withId(R.id.btn_server_search))
                .perform(ViewActions.click());


        RecyclerView recyclerView = activity.findViewById(R.id.doctor_recycler_view);
        int itemCount = recyclerView.getAdapter().getItemCount();
        onView(withId(R.id.doctor_recycler_view))
                .perform(RecyclerViewActions.scrollToPosition(itemCount - 1));

    }


}