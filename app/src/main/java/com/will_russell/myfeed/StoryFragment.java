package com.will_russell.myfeed;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class StoryFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private InteractionListener mListener;
    SwipeRefreshLayout mSwipeRefreshLayout;
    public static StoryAdapter adapter;

    public StoryFragment() {}

    public static StoryFragment newInstance() {
        StoryFragment fragment = new StoryFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.story_item_list, container, false);
        Context context = view.getContext();
        RecyclerView recyclerView = view.findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setHasFixedSize(true);
        adapter = new StoryAdapter(mListener, getContext());
        recyclerView.setAdapter(adapter);

        mSwipeRefreshLayout = view.findViewById(R.id.swipe_container);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark,
                android.R.color.holo_blue_dark);

        mSwipeRefreshLayout.post(new Runnable() {

            @Override
            public void run() {

                mSwipeRefreshLayout.setRefreshing(true);

                // Fetching data from server
                loadRecyclerViewData();
            }
        });
        return view;
    }

    @Override
    public void onRefresh() {

        // Fetching data from server
        loadRecyclerViewData();
    }

    public static void notifyUpdate() {
        adapter.notifyDataSetChanged();
    }

    private void loadRecyclerViewData()
    {
        mSwipeRefreshLayout.setRefreshing(true);
        // HTTP Request
        mSwipeRefreshLayout.setRefreshing(false);
    }

    public interface InteractionListener {
        void interactionListener(Story item);
    }
}
