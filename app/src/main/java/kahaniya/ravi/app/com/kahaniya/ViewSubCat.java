package kahaniya.ravi.app.com.kahaniya;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ViewSubCat extends AppCompatActivity {
    ArrayList<String> arrayList;
    adapter mAdapter;
    String[] storyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewsub_cat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        toolbar.setNavigationIcon(R.mipmap.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CM.finishActivity(ViewSubCat.this);

            }
        });


        intitView();
    }


    private void intitView() {
        String page = getIntent().getStringExtra("page");
        setStory(page);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycleView);
        // mRecyclerView.setLayoutManager(new LinearLayoutManager(ViewSubCat.this));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        List<String> wordList = Arrays.asList(storyList);

        mAdapter = new adapter(this, wordList);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.SetOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(String item, String item1) {

                Intent intent = new Intent(ViewSubCat.this, Viewdetail.class);
                intent.putExtra("page", item1);
                CM.startActivity(intent, ViewSubCat.this);

            }
        });
    }


    public void setStory(String page) {

        switch (page) {
            case "1":
                storyList = getResources().getStringArray(R.array.storyArray1);
                break;
            case "2":
                storyList = getResources().getStringArray(R.array.storyArray2);
                break;
            case "3":
                storyList = getResources().getStringArray(R.array.storyArray3);
                break;
            case "4":
                storyList = getResources().getStringArray(R.array.storyArray4);
                break;
            case "5":
                storyList = getResources().getStringArray(R.array.storyArray5);
                break;
            case "6":
                storyList = getResources().getStringArray(R.array.storyArray6);
                break;
            case "7":
                storyList = getResources().getStringArray(R.array.storyArray7);
                break;
            case "8":
                storyList = getResources().getStringArray(R.array.storyArray8);
                break;
            case "9":
                storyList = getResources().getStringArray(R.array.storyArray9);
                break;
            case "10":
                storyList = getResources().getStringArray(R.array.storyArray10);
                break;

        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        CM.finishActivity(this);
    }
}
