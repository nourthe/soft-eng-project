package com.example.pbt.view;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pbt.R;
import com.example.pbt.ViewModel.MainViewModel;
import com.example.pbt.model.Comment;
import com.example.pbt.model.Post;

public class PostDetailActivity extends AppCompatActivity {
    public static final String EXTRA_POST_ID = "extra_post_id";

    private MainViewModel mMainViewModel;
    private Post mPost;
    private ImageButton mButtonLike;
    private ListView commentsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);
        initViews();
        addClickListeners();
    }


    private void initViews() {
        Toolbar toolbar = findViewById(R.id.main_toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mMainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mPost = mMainViewModel.getPost(getIntent().getIntExtra(EXTRA_POST_ID,0));
        mButtonLike = findViewById(R.id.ib_like_post);
        commentsList = findViewById(R.id.listaComentarios);
        if (mPost.getCommentList().isEmpty()) ((TextView) (findViewById(R.id.textView3))).setText("No hay comentarios");
        commentsList.setAdapter(new ArrayAdapter<Comment>(this,android.R.layout.simple_list_item_1,mPost.getCommentList()));
        if (mMainViewModel.isPostLiked(mPost)) {
            mButtonLike.setImageResource(R.drawable.ic_star_black_24dp);
        } else {
            mButtonLike.setImageResource(R.drawable.ic_star_border_black_24dp);
        }
        ((TextView)findViewById(R.id.postTitle)).setText(mPost.getTitle());
        ((TextView)findViewById(R.id.postDescription)).setText(mPost.getDescription());
    }

    private void addClickListeners() {
        mButtonLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mMainViewModel.likePost(mPost);
                if (mMainViewModel.isPostLiked(mPost)) {
                    mButtonLike.setImageResource(R.drawable.ic_star_black_24dp);
                } else {
                    mButtonLike.setImageResource(R.drawable.ic_star_border_black_24dp);
                }
            }
        });
    }
}
