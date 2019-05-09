package com.will_russell.myfeed;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;

import com.google.android.material.bottomappbar.BottomAppBar;

import org.apache.commons.validator.routines.UrlValidator;

public class ExpandedStoryActivity extends AppCompatActivity {

    private ImageView headerImageView;
    private TextView titleView;
    private TextView contentView;
    private Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expanded_story);

        BottomAppBar appBar = findViewById(R.id.bar);
        setSupportActionBar(appBar);

        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setHomeAsUpIndicator(R.drawable.white_back);

        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);
        story = Story.stories.get(position);

        titleView = findViewById(R.id.titleView);
        contentView = findViewById(R.id.contentView);
        headerImageView = findViewById(R.id.headerImageView);

        titleView.setText(story.getTitle());
        contentView.setText(story.getContent());

        if (story.getImages().size() > 0) {
            headerImageView.setImageBitmap(story.getImages().get(0));
        } else {
            headerImageView.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        String[] schemes = {"http","https"};
        UrlValidator urlValidator = new UrlValidator(schemes);
        if (!urlValidator.isValid(story.getUrl())) {
            getMenuInflater().inflate(R.menu.menu_appbar_nourl, menu);
        } else {
            getMenuInflater().inflate(R.menu.menu_appbar, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
        case R.id.app_bar_like:
            // Send data to server to train model
            // - Like
            // - Tags
            return true;
        case R.id.app_bar_dislike:
            // Send data to server to train model
            // - Dislike
            // - Tags
            return true;
        case R.id.app_bar_share:
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, story.getUrl());
            sendIntent.setType("text/plain");
            startActivity(Intent.createChooser(sendIntent, getResources().getText(R.string.send_to)));
            return true;
        case R.id.app_bar_open:
            Uri uriUrl = Uri.parse(story.getUrl());
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            builder.setToolbarColor(getResources().getColor(R.color.colorPrimaryDark));
            CustomTabsIntent customTabsIntent = builder.build();
            customTabsIntent.launchUrl(this, uriUrl);
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
