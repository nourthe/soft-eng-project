package com.example.pbt.view;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.pbt.R;
import com.example.pbt.ViewModel.MainViewModel;
import com.example.pbt.model.Post;

public class PostDetailActivity extends AppCompatActivity {
    public static final String EXTRA_POST_ID = "extra_post_id";

    private MainViewModel mMainViewModel;
    private Post mPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);
        initViews();
    }

    private void initViews() {
        Toolbar toolbar = findViewById(R.id.main_toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mMainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mPost = mMainViewModel.getPost(getIntent().getIntExtra(EXTRA_POST_ID,0));
        ((TextView)findViewById(R.id.postTitle)).setText(mPost.getTitle());
        ((TextView)findViewById(R.id.postDescription)).setText(mPost.getDescription());
    }
}
