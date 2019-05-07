package com.will_russell.myfeed;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class ExpandedStoryFragment extends Fragment {

    private TextView contentView;
    private Story story;

    public static ExpandedStoryFragment newInstance(Story story) {
        ExpandedStoryFragment fragment = new ExpandedStoryFragment();
        fragment.story = story;
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_story, container, false);
        contentView = view.findViewById(R.id.contentView);
        contentView.setText(story.getContent());

        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle(story.getTitle());
        return view;
    }
}
