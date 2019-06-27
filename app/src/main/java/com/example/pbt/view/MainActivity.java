package com.example.pbt.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.pbt.R;
import com.example.pbt.ViewModel.MainViewModel;
import com.example.pbt.model.Post;
import com.example.pbt.util.sort.EntryAuthorEntrySort;
import com.example.pbt.util.sort.EntryDateEntrySort;
import com.example.pbt.util.sort.EntryFilter;
import com.example.pbt.util.sort.EntryTitleEntrySort;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private MainViewModel mViewModel;
    private Button filtrarPostsTitulo;
    private Button filtrarPostAutor;
    EntryFilter filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        filter = new EntryDateEntrySort();
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        filtrarPostAutor = findViewById(R.id.btn_filter_by_post_author);
        filtrarPostsTitulo = findViewById(R.id.btn_filter_by_post_title);
            addListObserver();
            addOnClickListeners();
    }


    private void initViews() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.mListView = findViewById(R.id.listView);
        mListView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1));
    }
    private void addListObserver() {
        mViewModel.getRecentPosts().observe(this, new Observer<List<Post>>() {
        @Override
        public void onChanged(@Nullable List<Post> posts) {
            ((ArrayAdapter)mListView.getAdapter()).clear();
            //noinspection unchecked

            ((ArrayAdapter)mListView.getAdapter()).addAll(filter.filter(posts));
            ((ArrayAdapter)mListView.getAdapter()).notifyDataSetChanged();
        }
        });
    }

    private void addOnClickListeners() {
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), PostDetailActivity.class);
                intent.putExtra(PostDetailActivity.EXTRA_POST_ID, position);
                startActivity(intent);
            }
        });
        filtrarPostsTitulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filter = new EntryTitleEntrySort();
                mViewModel.notifyRecentPosts();
            }
        });
        filtrarPostAutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filter = new EntryAuthorEntrySort();
                mViewModel.notifyRecentPosts();
            }
        });
    }



}
