package com.will_russell.myfeed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomappbar.BottomAppBar;

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
        getMenuInflater().inflate(R.menu.menu_appbar, menu);
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
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return false;
    }
}
