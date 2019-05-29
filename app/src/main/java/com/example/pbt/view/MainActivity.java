package com.example.pbt.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pbt.R;
import com.example.pbt.ViewModel.MainViewModel;
import com.example.pbt.data.PostData;
import com.example.pbt.model.PBT;
import com.example.pbt.model.Post;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        addListObserver();
    }

    private void addListObserver() {
        mViewModel.getRecentPosts().observe(this, new Observer<List<Post>>() {
        @Override
        public void onChanged(@Nullable List<Post> posts) {
            //noinspection unchecked
            ((ArrayAdapter)mListView.getAdapter()).addAll(posts);
            ((ArrayAdapter)mListView.getAdapter()).notifyDataSetChanged();
        }
        });
    }

    private void initViews() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.mListView = findViewById(R.id.listView);
        mListView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Snackbar.make(view,
                    "Titulo del post: " + ((Post)(parent.getItemAtPosition(position))).getTitle(),
                        Snackbar.LENGTH_SHORT)
                        .show();
            }
        });
    }

}
