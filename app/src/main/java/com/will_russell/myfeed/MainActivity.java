package com.will_russell.myfeed;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import androidx.fragment.app.FragmentTransaction;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Story story = new Story("Selly Oak is dangerous", "More students stabbed");
        Story.stories.add(story);
        AssetManager assetManager = getAssets();
        InputStream input;
        Bitmap image;
        ArrayList<Bitmap> images = new ArrayList<>();
        try {
            input = assetManager.open("bee.jpg");
            image = BitmapFactory.decodeStream(input);
            images.add(image);
            Story story3 = new Story("Hello", "World", image);
            Story.stories.add(story3);
            Story story1 = new Story("Bee Movie", "According to all known laws " +
                    "of aviation, " + "there is no way a bee " +
                    "should be able to fly.\n" +
                    "Its wings are too small to get " +
                    "its fat little body off the ground.\n" +
                    "The bee, of course, flies anyway " +
                    "because bees don't care" +
                    "what humans think is impossible.\n" +
                    "Yellow, black. Yellow, black.\n" +
                    "Yellow, black. Yellow, black.\n" +
                    "Ooh, black and yellow!\n" +
                    "Let's shake it up a little.\n" +
                    "Barry! Breakfast is ready!", image);
            Story.stories.add(story1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Story story2 = new Story("Brummy Memes", "Saturday exams are an absolute joke", images);
        Story story4 = new Story("Hello", "World");
        Story story5 = new Story("Hello", "World");
        Story story6 = new Story("Hello", "World");


        Story.stories.add(story2);

        Story.stories.add(story4);
        Story.stories.add(story5);
        Story.stories.add(story6);

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
        default:
            return super.onOptionsItemSelected(item);
        }
    }

    public void openStory(int position) {
        Story story = Story.stories.get(position);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame, ExpandedStoryFragment.newInstance(story));
        transaction.addToBackStack("expanded");
        transaction.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right);
        TextView title = findViewById(R.id.toolbar_title);
        title.setText(story.getTitle());
        transaction.commit();
    }
}
