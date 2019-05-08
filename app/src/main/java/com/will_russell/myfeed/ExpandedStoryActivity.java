package com.will_russell.myfeed;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.CollapsingToolbarLayout;


public class ExpandedStoryActivity extends AppCompatActivity {

    private ImageView headerImageView;
    private TextView contentView;
    private Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expanded_story);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setHomeAsUpIndicator(R.drawable.white_back);

        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);
        story = Story.stories.get(position);
        this.getSupportActionBar().setTitle(story.getTitle());

        contentView = findViewById(R.id.contentView);
        contentView.setText(story.getContent());
        //headerImageView = findViewById(R.id.headerImageView);

        CollapsingToolbarLayout toolbarLayout = findViewById(R.id.toolbar_layout);


        if (story.getImages().size() > 0) {
            //headerImageView.setImageBitmap(story.getImages().get(0));
            Drawable header = new BitmapDrawable(getResources(), story.getImages().get(0));
            toolbarLayout.setBackground(header);
        } else {
            //headerImageView.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return false;
    }
}
