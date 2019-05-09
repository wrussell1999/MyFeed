package com.will_russell.myfeed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ViewHolder> {

    Context context;

    public StoryAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.story_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return Story.stories.size();
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mItem = Story.stories.get(position);
        holder.titleView.setText(holder.mItem.getTitle());
        holder.contentView.setText(holder.mItem.getContent());
        if (holder.mItem.getImages().size() > 0) {
            holder.imageView.setImageBitmap(holder.mItem.getImages().get(0));
        } else {
            holder.imageView.setVisibility(View.GONE);
        }
        holder.mView.setClickable(true);
        holder.mView.setOnClickListener(v -> ((MainActivity) holder.mView.getContext()).openStory(position));
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView titleView;
        public final TextView contentView;
        public final ImageView imageView;

        public Story mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            titleView = view.findViewById(R.id.titleView);
            contentView = view.findViewById(R.id.contentView);
            imageView = view.findViewById(R.id.imageView);
        }
    }
}
