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
        holder.summaryView.setText(holder.mItem.getSummary());
        holder.sourceView.setText(holder.mItem.getSource());
        holder.dateView.setText(holder.mItem.getDate());

        if (holder.mItem.getImage() != null) {
            holder.headerView.setImageBitmap(holder.mItem.getImage());
        } else {
            holder.headerView.setVisibility(View.GONE);
        }
        if (holder.mItem.getSourceLogo() != null) {
            holder.sourceLogoView.setImageBitmap(holder.mItem.getSourceLogo());
        }

        holder.mView.setClickable(true);
        holder.mView.setOnClickListener(v -> ((MainActivity) holder.mView.getContext()).openStory(position));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView titleView;
        public final TextView summaryView;
        public final ImageView headerView;
        public final TextView sourceView;
        public final ImageView sourceLogoView;
        public final TextView dateView;

        public Story mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            titleView = view.findViewById(R.id.titleView);
            summaryView = view.findViewById(R.id.summaryView);
            headerView = view.findViewById(R.id.imageView);
            sourceView = view.findViewById(R.id.sourceView);
            sourceLogoView = view.findViewById(R.id.sourceLogoView);
            dateView = view.findViewById(R.id.dateView);
        }
    }
}
