package com.will_russell.myfeed;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        StoryFragment.newInstance();

        Story story = new Story("Selly Oak is dangerous", "More students stabbed");
        Story story1 = new Story("Bee Movie", "According to all known laws\n" +
                "of aviation,\n" +
                "\n" +
                "there is no way a bee\n" +
                "should be able to fly.\n" +
                "\n" +
                "Its wings are too small to get\n" +
                "its fat little body off the ground.\n" +
                "\n" +
                "The bee, of course, flies anyway\n" +
                "\n" +
                "because bees don't care\n" +
                "what humans think is impossible.\n" +
                "\n" +
                "Yellow, black. Yellow, black.\n" +
                "Yellow, black. Yellow, black.\n" +
                "\n" +
                "Ooh, black and yellow!\n" +
                "Let's shake it up a little.\n" +
                "\n" +
                "Barry! Breakfast is ready!");
        Story story2 = new Story("Brummy Memes", "Saturday exams are an absolute joke");
        Story story3 = new Story("Hello", "World");
        Story story4 = new Story("Hello", "World");
        Story story5 = new Story("Hello", "World");
        Story story6 = new Story("Hello", "World");
        Story.Companion.getStories().add(story);
        Story.Companion.getStories().add(story1);
        Story.Companion.getStories().add(story2);
        Story.Companion.getStories().add(story3);
        Story.Companion.getStories().add(story4);
        Story.Companion.getStories().add(story5);
        Story.Companion.getStories().add(story6);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame, StoryFragment.newInstance());
        transaction.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.action_settings:
            return true;
        case R.id.action_about:
            return true;
        case R.id.menu_refresh:
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
}
