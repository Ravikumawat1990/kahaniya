package kahaniya.ravi.app.com.kahaniya;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class Viewhome extends AppCompatActivity implements View.OnClickListener, RewardedVideoAdListener {


    LinearLayout layout1, layout2, layout3, layout4, layout5, layout6, layout7, layout8, layout9, layout10;


    private static final String AD_UNIT_ID = "ca-app-pub-3940256099942544/5224354917";
    private static final String APP_ID = "ca-app-pub-3940256099942544~3347511713";
    private RewardedVideoAd mRewardedVideoAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewhome);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showRewardedVideo();
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        // Initialize the Mobile Ads SDK.
        MobileAds.initialize(this, APP_ID);
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd.setRewardedVideoAdListener(this);
        loadRewardedVideoAd();

        initView();
    }

    private void loadRewardedVideoAd() {
        if (!mRewardedVideoAd.isLoaded()) {
            mRewardedVideoAd.loadAd(AD_UNIT_ID, new AdRequest.Builder().build());
        }
    }

    private void initView() {


        layout1 = (LinearLayout) findViewById(R.id.layout1);
        layout2 = (LinearLayout) findViewById(R.id.layout2);
        layout3 = (LinearLayout) findViewById(R.id.layout3);
        layout4 = (LinearLayout) findViewById(R.id.layout4);
        layout5 = (LinearLayout) findViewById(R.id.layout5);
        layout6 = (LinearLayout) findViewById(R.id.layout6);
        layout7 = (LinearLayout) findViewById(R.id.layout7);
        layout8 = (LinearLayout) findViewById(R.id.layout8);
        layout9 = (LinearLayout) findViewById(R.id.layout9);
        layout10 = (LinearLayout) findViewById(R.id.layout10);


        if (CM.getSp(Viewhome.this, "isViewed", "").toString().equals("1")) {
            //layout5.setVisibility(View.VISIBLE);
            layout6.setVisibility(View.VISIBLE);
            layout7.setVisibility(View.VISIBLE);
            layout8.setVisibility(View.VISIBLE);
            layout9.setVisibility(View.VISIBLE);
            layout10.setVisibility(View.VISIBLE);

        } else {

            showPopup(this);
            //layout5.setVisibility(View.GONE);
            layout6.setVisibility(View.GONE);
            layout7.setVisibility(View.GONE);
            layout8.setVisibility(View.GONE);
            layout9.setVisibility(View.GONE);
            layout10.setVisibility(View.GONE);

        }
        layout1.setOnClickListener(this);
        layout2.setOnClickListener(this);
        layout3.setOnClickListener(this);
        layout4.setOnClickListener(this);
        layout5.setOnClickListener(this);
        layout6.setOnClickListener(this);
        layout7.setOnClickListener(this);
        layout8.setOnClickListener(this);
        layout9.setOnClickListener(this);
        layout10.setOnClickListener(this);


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
        // Toast.makeText(this, "onRewardedVideoAdClosed", Toast.LENGTH_SHORT).show();

        // Preload the next video ad.
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
        Toast.makeText(this, "onRewardedVideoAdOpened", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewarded(RewardItem reward) {
        Toast.makeText(this,
                String.format(" onRewarded! currency: %s amount: %d", reward.getType(),
                        reward.getAmount()),
                Toast.LENGTH_SHORT).show();
        CM.setSp(Viewhome.this, "isViewed", "1");
        layout5.setVisibility(View.VISIBLE);
        layout6.setVisibility(View.VISIBLE);
        layout7.setVisibility(View.VISIBLE);
        layout8.setVisibility(View.VISIBLE);
        layout9.setVisibility(View.VISIBLE);
        layout10.setVisibility(View.VISIBLE);
    }

    @Override
    public void onRewardedVideoStarted() {
        Toast.makeText(this, "onRewardedVideoStarted", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(Viewhome.this, ViewSubCat.class);
        switch (view.getId()) {
            case R.id.layout1:
                intent.putExtra("page", "1");
                CM.startActivity(intent, Viewhome.this);
                break;
            case R.id.layout2:
                intent.putExtra("page", "2");
                CM.startActivity(intent, Viewhome.this);
                break;
            case R.id.layout3:
                intent.putExtra("page", "3");
                CM.startActivity(intent, Viewhome.this);
                break;
            case R.id.layout4:
                intent.putExtra("page", "4");
                CM.startActivity(intent, Viewhome.this);
                break;
            case R.id.layout5:
                intent.putExtra("page", "5");
                CM.startActivity(intent, Viewhome.this);
                break;
            case R.id.layout6:
                intent.putExtra("page", "6");
                CM.startActivity(intent, Viewhome.this);
                break;
            case R.id.layout7:
                intent.putExtra("page", "7");
                CM.startActivity(intent, Viewhome.this);
                break;
            case R.id.layout8:
                intent.putExtra("page", "8");
                CM.startActivity(intent, Viewhome.this);
                break;
            case R.id.layout9:
                intent.putExtra("page", "9");
                CM.startActivity(intent, Viewhome.this);
                break;
            case R.id.layout10:
                intent.putExtra("page", "10");
                CM.startActivity(intent, Viewhome.this);
                break;

        }

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

    public void showPopup(Context context) {
        new AlertDialog.Builder(context)
                .setTitle(getString(R.string.app_name))
                .setMessage(getString(R.string.warning))
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        showRewardedVideo();
                    }
                }).setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setIcon(R.mipmap.ic_launcher).show();
    }

}
