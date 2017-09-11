package kahaniya.ravi.app.com.kahaniya;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ViewSubCat extends AppCompatActivity implements RewardedVideoAdListener {
    String[] storyList;

    ListView mRecyclerView;
    int count = 20;
    List<String> oldArrayList;
    ArrayList<String> newArrayList;
    View loadMoreView;
    private CustomAdapter customAdapter;

    private RewardedVideoAd mRewardedVideoAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewsub_cat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.mipmap.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CM.finishActivity(ViewSubCat.this);

            }
        });
        MobileAds.initialize(this, getString(R.string.AD_UNIT_ID));
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd.setRewardedVideoAdListener(this);
        loadRewardedVideoAd();

        intitView();
    }


    private void intitView() {
        String page = getIntent().getStringExtra("page");
        setStory(page);
        mRecyclerView = (ListView) findViewById(R.id.recycleView);
        oldArrayList = Arrays.asList(storyList);

        loadMoreView = ((LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                .inflate(R.layout.loadmore, null, false);
        mRecyclerView.addFooterView(loadMoreView);
        newArrayList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            if (oldArrayList.size() == newArrayList.size()) {
                loadMoreView.setVisibility(View.GONE);

            } else {
                newArrayList.add(oldArrayList.get(i));
            }
        }

        customAdapter = new CustomAdapter(this, newArrayList);
        mRecyclerView.setAdapter(customAdapter);

        loadMoreView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (CM.isInternetAvailable(ViewSubCat.this)) {
                    showRewardedVideo();
                } else {
                    CM.showToast(getString(R.string.checkinternet), ViewSubCat.this);
                }
            }
        });

    }

    private void loadRewardedVideoAd() {
        if (!mRewardedVideoAd.isLoaded()) {
            mRewardedVideoAd.loadAd(getString(R.string.AD_UNIT_ID), new AdRequest.Builder().build());
        }
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
            case "11":
                storyList = getResources().getStringArray(R.array.storyArray6);
                break;
            case "12":
                storyList = getResources().getStringArray(R.array.storyArray7);
                break;
            case "13":
                storyList = getResources().getStringArray(R.array.storyArray8);
                break;
            case "14":
                storyList = getResources().getStringArray(R.array.storyArray9);
                break;
            case "15":
                storyList = getResources().getStringArray(R.array.storyArray10);
                break;

        }

    }

    private void showRewardedVideo() {
        if (mRewardedVideoAd.isLoaded()) {
            mRewardedVideoAd.show();
        }
    }


    @Override
    public void onRewardedVideoAdLeftApplication() {
        Toast.makeText(this, "onRewardedVideoAdLeftApplication", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdClosed() {
        loadRewardedVideoAd();
    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int errorCode) {
        Toast.makeText(this, "onRewardedVideoAdFailedToLoad", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdLoaded() {
        Toast.makeText(this, "onRewardedVideoAdLoaded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdOpened() {
        //Toast.makeText(this, "onRewardedVideoAdOpened", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewarded(RewardItem reward) {
        Toast.makeText(this,
                String.format(" onRewarded! currency: %s amount: %d", reward.getType(),
                        reward.getAmount()),
                Toast.LENGTH_SHORT).show();
        for (int i = newArrayList.size(); i < count; i++) {

            if (newArrayList.size() == oldArrayList.size()) {
                loadMoreView.setVisibility(View.GONE);

            } else {
                newArrayList.add(oldArrayList.get(i));
            }
        }
        count = count + 10;
        newArrayList.size();
        customAdapter.notifyDataSetChanged();
        mRecyclerView.invalidate();
    }

    @Override
    public void onRewardedVideoStarted() {
        //Toast.makeText(this, "onRewardedVideoStarted", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        CM.finishActivity(this);
    }

    @Override
    public void onResume() {
        mRewardedVideoAd.resume(this);
        super.onResume();
    }

    @Override
    public void onPause() {
        mRewardedVideoAd.pause(this);

        super.onPause();
    }

    @Override
    public void onDestroy() {
        mRewardedVideoAd.destroy(this);
        super.onDestroy();
    }
}
