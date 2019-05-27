package com.example.pbt.view;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.pbt.R;
import com.example.pbt.data.PostData;
import com.example.pbt.model.PBT;
import com.example.pbt.model.Post;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PBT mPBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mPBT = new PBT();

        PostData postData = new PostData(mPBT);



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ListView listView = findViewById(R.id.listView);
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,mPBT.getLatestPostsList().getValue()));
        mPBT.getLatestPostsList().observe(this, new Observer<List<Post>>() {
            @Override
            public void onChanged(@Nullable List<Post> posts) {
                ((ArrayAdapter)listView.getAdapter()).addAll(posts);
                ((ArrayAdapter)listView.getAdapter()).notifyDataSetChanged();
            }
        });


        postData.fetchLatestPosts(1000);
        postData.fetchLatestPosts(2000);
        postData.fetchLatestPosts(3000);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
