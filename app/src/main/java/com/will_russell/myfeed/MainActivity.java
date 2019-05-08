package com.will_russell.myfeed;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;

import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private final String SERVER_URL = "";
    SwipeRefreshLayout mSwipeRefreshLayout;
    public static StoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Context context = getApplicationContext();

        RecyclerView recyclerView = findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setHasFixedSize(true);
        adapter = new StoryAdapter(getApplicationContext());
        recyclerView.setAdapter(adapter);

        mSwipeRefreshLayout = findViewById(R.id.swipe_container);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark,
                android.R.color.holo_blue_dark);

        mSwipeRefreshLayout.post(() -> {
            loadRecyclerViewData();
        });



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
            Story story1 = new Story("Bee Movie", "  \n" +
                    "According to all known laws\n" +
                    "of aviation,\n" +
                    "\n" +
                    "  \n" +
                    "there is no way a bee\n" +
                    "should be able to fly.\n" +
                    "\n" +
                    "  \n" +
                    "Its wings are too small to get\n" +
                    "its fat little body off the ground.\n" +
                    "\n" +
                    "  \n" +
                    "The bee, of course, flies anyway\n" +
                    "\n" +
                    "  \n" +
                    "because bees don't care\n" +
                    "what humans think is impossible.\n" +
                    "\n" +
                    "  \n" +
                    "Yellow, black. Yellow, black.\n" +
                    "Yellow, black. Yellow, black.\n" +
                    "\n" +
                    "  \n" +
                    "Ooh, black and yellow!\n" +
                    "Let's shake it up a little.\n" +
                    "\n" +
                    "  \n" +
                    "Barry! Breakfast is ready!\n" +
                    "\n" +
                    "  \n" +
                    "Ooming!\n" +
                    "\n" +
                    "  \n" +
                    "Hang on a second.\n" +
                    "\n" +
                    "  \n" +
                    "Hello?\n" +
                    "\n" +
                    "  \n" +
                    "- Barry?\n" +
                    "- Adam?\n" +
                    "\n" +
                    "  \n" +
                    "- Oan you believe this is happening?\n" +
                    "- I can't. I'll pick you up.\n" +
                    "\n" +
                    "  \n" +
                    "Looking sharp.\n" +
                    "\n" +
                    "  \n" +
                    "Use the stairs. Your father\n" +
                    "paid good money for those.\n" +
                    "\n" +
                    "  \n" +
                    "Sorry. I'm excited.\n" +
                    "\n" +
                    "  \n" +
                    "Here's the graduate.\n" +
                    "We're very proud of you, son.\n" +
                    "\n" +
                    "  \n" +
                    "A perfect report card, all B's.\n" +
                    "\n" +
                    "  \n" +
                    "Very proud.\n" +
                    "\n" +
                    "  \n" +
                    "Ma! I got a thing going here.\n" +
                    "\n" +
                    "  \n" +
                    "- You got lint on your fuzz.\n" +
                    "- Ow! That's me!\n" +
                    "\n" +
                    "  \n" +
                    "- Wave to us! We'll be in row 118,000.\n" +
                    "- Bye!\n" +
                    "\n" +
                    "  \n" +
                    "Barry, I told you,\n" +
                    "stop flying in the house!\n" +
                    "\n" +
                    "  \n" +
                    "- Hey, Adam.\n" +
                    "- Hey, Barry.\n" +
                    "\n" +
                    "  \n" +
                    "- Is that fuzz gel?\n" +
                    "- A little. Special day, graduation.\n" +
                    "\n" +
                    "  \n" +
                    "Never thought I'd make it.\n" +
                    "\n" +
                    "  \n" +
                    "Three days grade school,\n" +
                    "three days high school.\n" +
                    "\n" +
                    "  \n" +
                    "Those were awkward.\n" +
                    "\n" +
                    "  \n" +
                    "Three days college. I'm glad I took\n" +
                    "a day and hitchhiked around the hive.\n" +
                    "\n" +
                    "  \n" +
                    "You did come back different.\n" +
                    "\n" +
                    "  \n" +
                    "- Hi, Barry.\n" +
                    "- Artie, growing a mustache? Looks good.\n" +
                    "\n" +
                    "  \n" +
                    "- Hear about Frankie?\n" +
                    "- Yeah.\n" +
                    "\n" +
                    "  \n" +
                    "- You going to the funeral?\n" +
                    "- No, I'm not going.\n" +
                    "\n" +
                    "  \n" +
                    "Everybody knows,\n" +
                    "sting someone, you die.\n" +
                    "\n" +
                    "  \n" +
                    "Don't waste it on a squirrel.\n" +
                    "Such a hothead.\n" +
                    "\n" +
                    "  \n" +
                    "I guess he could have\n" +
                    "just gotten out of the way.\n" +
                    "\n" +
                    "  \n" +
                    "I love this incorporating\n" +
                    "an amusement park into our day.\n" +
                    "\n" +
                    "  \n" +
                    "That's why we don't need vacations.\n" +
                    "\n" +
                    "  \n" +
                    "Boy, quite a bit of pomp...\n" +
                    "under the circumstances.\n" +
                    "\n" +
                    "  \n" +
                    "- Well, Adam, today we are men.\n" +
                    "- We are!\n" +
                    "\n" +
                    "  \n" +
                    "- Bee-men.\n" +
                    "- Amen!\n" +
                    "\n" +
                    "  \n" +
                    "Hallelujah!\n" +
                    "\n" +
                    "  \n" +
                    "Students, faculty, distinguished bees,\n" +
                    "\n" +
                    "  \n" +
                    "please welcome Dean Buzzwell.\n" +
                    "\n" +
                    "  \n" +
                    "Welcome, New Hive Oity\n" +
                    "graduating class of...\n" +
                    "\n" +
                    "  \n" +
                    "...9:15.\n" +
                    "\n" +
                    "  \n" +
                    "That concludes our ceremonies.\n" +
                    "\n" +
                    "  \n" +
                    "And begins your career\n" +
                    "at Honex Industries!\n" +
                    "\n" +
                    "  \n" +
                    "Will we pick ourjob today?\n" +
                    "\n" +
                    "  \n" +
                    "I heard it's just orientation.\n" +
                    "\n" +
                    "  \n" +
                    "Heads up! Here we go.\n" +
                    "\n" +
                    "  \n" +
                    "Keep your hands and antennas\n" +
                    "inside the tram at all times.\n" +
                    "\n" +
                    "  \n" +
                    "- Wonder what it'll be like?\n" +
                    "- A little scary.\n" +
                    "\n" +
                    "  \n" +
                    "Welcome to Honex,\n" +
                    "a division of Honesco\n" +
                    "\n" +
                    "  \n" +
                    "and a part of the Hexagon Group.\n" +
                    "\n" +
                    "  \n" +
                    "This is it!\n" +
                    "\n" +
                    "  \n" +
                    "Wow.\n" +
                    "\n" +
                    "  \n" +
                    "Wow.\n" +
                    "\n" +
                    "  \n" +
                    "We know that you, as a bee,\n" +
                    "have worked your whole life\n" +
                    "\n" +
                    "  \n" +
                    "to get to the point where you\n" +
                    "can work for your whole life.\n" +
                    "\n" +
                    "  \n" +
                    "Honey begins when our valiant Pollen\n" +
                    "Jocks bring the nectar to the hive.\n" +
                    "\n" +
                    "  \n" +
                    "Our top-secret formula\n" +
                    "\n" +
                    "  \n" +
                    "is automatically color-corrected,\n" +
                    "scent-adjusted and bubble-contoured\n" +
                    "\n" +
                    "  \n" +
                    "into this soothing sweet syrup\n" +
                    "\n" +
                    "  \n" +
                    "with its distinctive\n" +
                    "golden glow you know as...\n" +
                    "\n" +
                    "  \n" +
                    "Honey!", image);
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
    }

    @Override
    public void onRefresh() {
        swipeReloadRecyclerView();
    }

    private void loadRecyclerViewData()
    {
        RequestQueue queue;
        Cache cache = new DiskBasedCache(this.getCacheDir(), 1024 * 1024);
        Network network = new BasicNetwork(new HurlStack());
        queue = new RequestQueue(cache, network);
        queue.start();
        try {
            StringRequest stringRequest = new StringRequest(Request.Method.GET, SERVER_URL, response -> {
                String title = response;
                String content = "";
                ArrayList<Bitmap> images = new ArrayList<>();
                Story.stories.add(new Story(title, content, images));
            }, error -> Toast.makeText(getApplicationContext(), getResources().getString(R.string.error), Toast.LENGTH_SHORT).show());
            queue.add(stringRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        notifyUpdate();
    }

    public static void notifyUpdate() {
        adapter.notifyDataSetChanged();
    }

    private void swipeReloadRecyclerView() {
        mSwipeRefreshLayout.setRefreshing(true);
        loadRecyclerViewData();
        mSwipeRefreshLayout.setRefreshing(false);
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
        Intent intent = new Intent(this, ExpandedStoryActivity.class);
        intent.putExtra("position", position);
        startActivity(intent);
    }
}
