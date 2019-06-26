package com.example.pbt.view;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.pbt.R;
import com.example.pbt.ViewModel.MainViewModel;
import com.example.pbt.model.Post;

/**
 * A simple {@link Fragment} subclass.
 */
public class PostListFragment extends Fragment {


    private View rootview;

    public static final String EXTRA_POST_ID = "extra_post_id";

    private MainViewModel mMainViewModel;
    private Post mPost;
    private ImageButton mButtonLike;

    public PostListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootview = inflater.inflate(R.layout.fragment_post_list,container);
        initViews();
        addClickListeners();
        return rootview;
    }

    private void initViews() {
        Toolbar toolbar = rootview.findViewById(R.id.main_toolbar);
        toolbar.setTitle("");
        rootview.setSupportActionBar(toolbar);

        rootview.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mMainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        mPost = mMainViewModel.getPost(rootview.getIntent().getIntExtra(EXTRA_POST_ID,0));
        mButtonLike = rootview.findViewById(R.id.ib_like_post);
        if (mMainViewModel.isPostLiked(mPost)) {
            mButtonLike.setImageResource(R.drawable.ic_star_black_24dp);
        } else {
            mButtonLike.setImageResource(R.drawable.ic_star_border_black_24dp);
        }
        ((TextView)rootview.findViewById(R.id.postTitle)).setText(mPost.getTitle());
        ((TextView)rootview.findViewById(R.id.postDescription)).setText(mPost.getDescription());
    }

    private void addClickListeners() {
        mButtonLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMainViewModel.likePost(mPost);
            }
        });
    }

}
