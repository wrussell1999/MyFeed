package com.will_russell.myfeed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import androidx.recyclerview.widget.RecyclerView;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ViewHolder> {

    private final StoryFragment.InteractionListener mListener;
    Context context;

    public StoryAdapter(StoryFragment.InteractionListener listener, Context context) {
        mListener = listener;
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
        return Story.Companion.getStories().size();
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mItem = Story.Companion.getStories().get(position);
        holder.titleView.setText(Story.Companion.getStories().get(position).getTitle());
        holder.contentView.setText(Story.Companion.getStories().get(position).getContent());
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView titleView;
        public final TextView contentView;

        public Story mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            titleView = view.findViewById(R.id.titleView);
            contentView = view.findViewById(R.id.contentView);
        }
    }
}
