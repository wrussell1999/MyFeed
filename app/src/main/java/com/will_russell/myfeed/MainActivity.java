package com.will_russell.myfeed;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
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
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;

import java.io.InputStream;
import java.net.URL;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;

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

        AssetManager assetManager = getAssets();
        InputStream input;
        Bitmap image;
        try {
            input = assetManager.open("bee.jpg");
            image = BitmapFactory.decodeStream(input);
            Story story3 = new Story("There are exams soon!", "Believe or not, the exams are creeping up on us", "summary", "date", "https://github.com/wrussell1999", image, "UoB", null);

            Story.stories.add(story3);
            Story story1 = new Story("Bee Movie", "" +
                    "According to all known laws" +
                    " of aviation, " +
                    "there is no way a bee" +
                    "should be able to fly." +
                    "Its wings are too small to get " +
                    "its fat little body off the ground. " +
                    "The bee, of course, flies anyway " +
                    "because bees don't care " +
                    "what humans think is impossible." +
                    "Yellow, black. Yellow, black. " +
                    "Yellow, black. Yellow, black. " +
                    "Ooh, black and yellow! " +
                    "Let's shake it up a little. " +
                    "Barry! Breakfast is ready! " +
                    "Ooming! " +
                    "Hang on a second. " +
                    "Hello? " +
                    "- Barry? " +
                    "- Adam? " +
                    "- Oan you believe this is happening? " +
                    "- I can't. I'll pick you up. " +
                    "Looking sharp. " +
                    "Use the stairs. Your father " +
                    "paid good money for those. " +
                    "Sorry. I'm excited. " +
                    "Here's the graduate. " +
                    "We're very proud of you, son. " +
                    "A perfect report card, all B's. " +
                    "Very proud. " +
                    "Ma! I got a thing going here. " +
                    "- You got lint on your fuzz. " +
                    "- Ow! That's me! " +
                    "- Wave to us! We'll be in row 118,000. " +
                    "- Bye! " +
                    "Barry, I told you, " +
                    "stop flying in the house! " +
                    "- Hey, Adam. " +
                    "- Hey, Barry. " +
                    "- Is that fuzz gel? " +
                    "- A little. Special day, graduation. " +
                    "Never thought I'd make it. " +
                    "Three days grade school, " +
                    "three days high school. " +
                    "Those were awkward. " +
                    "Three days college. I'm glad I took " +
                    "a day and hitchhiked around the hive. " +
                    "You did come back different. " +
                    "- Hi, Barry. " +
                    "- Artie, growing a mustache? Looks good. " +
                    "- Hear about Frankie? " +
                    "- Yeah. " +
                    "- You going to the funeral? " +
                    "- No, I'm not going. " +
                    "Everybody knows, " +
                    "sting someone, you die. " +
                    "Don't waste it on a squirrel. " +
                    "Such a hothead. " +
                    "I guess he could have " +
                    "just gotten out of the way. " +
                    "I love this incorporating " +
                    "an amusement park into our day. " +
                    "That's why we don't need vacations. " +
                    "Boy, quite a bit of pomp... " +
                    "under the circumstances. " +
                    "- Well, Adam, today we are men. " +
                    "- We are! " +
                    "- Bee-men. " +
                    "- Amen! " +
                    "Hallelujah! " +
                    "Students, faculty, distinguished bees, " +
                    "please welcome Dean Buzzwell. " +
                    "Welcome, New Hive Oity " +
                    "graduating class of... " +
                    "...9:15. " +
                    "That concludes our ceremonies. " +
                    "And begins your career " +
                    "at Honex Industries! " +
                    "Will we pick ourjob today? " +
                    "I heard it's just orientation. " +
                    "Heads up! Here we go. " +
                    "Keep your hands and antennas " +
                    "inside the tram at all times. " +
                    "- Wonder what it'll be like? " +
                    "- A little scary. " +
                    "Welcome to Honex, " +
                    "a division of Honesco " +
                    "and a part of the Hexagon Group. " +
                    "This is it!" +
                    "Wow. " +
                    "Wow. " +
                    "We know that you, as a bee, " +
                    "have worked your whole life " +
                    "to get to the point where you " +
                    "can work for your whole life. " +
                    "Honey begins when our valiant Pollen " +
                    "Jocks bring the nectar to the hive. " +
                    "Our top-secret formula " +
                    "is automatically color-corrected, " +
                    "scent-adjusted and bubble-contoured " +
                    "into this soothing sweet syrup " +
                    "with its distinctive " +
                    "golden glow you know as... " +
                    "Honey!", "hello", "date", "", image, "Bee Movie Corp", null);
            Story.stories.add(story1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Story story = new Story("Selly Oak is dangerous and wild. Please be careful", "More students stabbed", "ya" ,"date", "https://github.com/wrussell1999", null);
        Story story2 = new Story("Brummy Memes", "Saturday exams are an absolute joke", "date", "oof", "https://github.com/wrussell1999", null);
        Story story4 = new Story("Hello", "Oof", "World", "date", "https://github.com/wrussell1999", null);
        Story story5 = new Story("Hello", "World", "Summary", "date", "https://github.com/wrussell1999", null);
        Story story6 = new Story("Hello", "World", "Summary", "date", "https://www.bbc.co.uk/ ", null, "Source", null);
        Story.stories.add(story);
        Story.stories.add(story2);
        Story.stories.add(story4);
        Story.stories.add(story5);
        Story.stories.add(story6);
    }

    @Override
    public void onRefresh() {
        swipeReloadRecyclerView();
    }

    private void loadRecyclerViewData() {
        Story story = new Story();
        RequestQueue queue;
        Cache cache = new DiskBasedCache(this.getCacheDir(), 1024 * 1024);
        Network network = new BasicNetwork(new HurlStack());
        queue = new RequestQueue(cache, network);
        queue.start();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, SERVER_URL, null, response -> {
            try {
                story.setTitle(response.getJSONObject("story").getString("title"));
                story.setContent(checkContent(response.getJSONObject("story").getString("content")));
                story.setSummary(response.getJSONObject("story").getString("summary"));
                story.setDate(shortenDate(response.getJSONObject("story").getString("date")));
                story.setUrl(response.getJSONObject("story").getString("link"));
                story.setImage(convertImageToBitmap(response.getJSONObject("story").getString("image")));
                story.setSource(response.getJSONObject("source").getString("name"));
                story.setSourceLogo(convertImageToBitmap(response.getJSONObject("source").getString("icon")));
                Story.stories.add(story);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, error -> Toast.makeText(getApplicationContext(), getResources().getString(R.string.error), Toast.LENGTH_SHORT).show());
        queue.add(jsonObjectRequest);
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

    public Bitmap convertImageToBitmap(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable imageDrawable = Drawable.createFromStream(is, "");
            Bitmap image = ((BitmapDrawable) imageDrawable).getBitmap();
            return image;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String checkContent(String content) {
        return content;
    }

    public String shortenDate(String date) {
        String month = new DateFormatSymbols().getMonths()[Integer.valueOf(date.substring(5, 6)) - 1];
        String day = ordinal(Integer.valueOf(date.substring(8, 9)));
        String time = date.substring(11, 15);
        date = time + ", " + day + " " + month;
        return date;
    }

    public static String ordinal(int i) {
        return i % 100 == 11 || i % 100 == 12 || i % 100 == 13 ? i + "th" : i + new String[]{"th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th"}[i % 10];
    }
}
