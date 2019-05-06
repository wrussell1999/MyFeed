package com.will_russell.myfeed;

import android.app.VoiceInteractor;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class StoryFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private final String SERVER_URL = "";
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

        mSwipeRefreshLayout.post(() -> {
            mSwipeRefreshLayout.setRefreshing(true);
            loadRecyclerViewData();
        });
        return view;
    }

    @Override
    public void onRefresh() {
        loadRecyclerViewData();
    }

    public static void notifyUpdate() {
        adapter.notifyDataSetChanged();
    }

    private void loadRecyclerViewData()
    {
        mSwipeRefreshLayout.setRefreshing(true);
        RequestQueue queue;
        Cache cache = new DiskBasedCache(getActivity().getCacheDir(), 1024 * 1024);
        Network network = new BasicNetwork(new HurlStack());
        queue = new RequestQueue(cache, network);
        queue.start();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, SERVER_URL, response -> {
            String title = response;
            String content = "";
            Story.Companion.getStories().add(new Story(title, content));
        }, error -> Toast.makeText(getContext(), "Something went wrong.", Toast.LENGTH_LONG).show());
        queue.add(stringRequest);
        mSwipeRefreshLayout.setRefreshing(false);
    }


    public interface InteractionListener {
        void interactionListener(Story item);
    }
}
