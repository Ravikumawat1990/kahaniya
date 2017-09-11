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

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class Viewhome extends AppCompatActivity implements View.OnClickListener, RewardedVideoAdListener {


    LinearLayout layout1, layout2, layout3, layout4, layout5, layout6, layout7, layout8, layout9, layout10, layout11, layout12, layout13, layout14, layout15, layoutLoadMore, layoutDiv;
    private RewardedVideoAd mRewardedVideoAd;
    private AdView mAdView;
    InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewhome);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Full Screen on back
        interstitialAd = new InterstitialAd(Viewhome.this);
        interstitialAd.setAdUnitId(getResources().getString(R.string.interstitial_full_screen));
        interstitialAd.loadAd(new AdRequest.Builder().build());


        //Bottom
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Toast.makeText(getApplicationContext(), "Ad is loaded!", Toast.LENGTH_SHORT).show();
                mAdView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAdClosed() {
                mAdView.setVisibility(View.GONE);
                //  Toast.makeText(getApplicationContext(), "Ad is closed!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                mAdView.setVisibility(View.GONE);
                //   Toast.makeText(getApplicationContext(), "Ad failed to load! error code: " + errorCode, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdLeftApplication() {
                mAdView.setVisibility(View.GONE);
                //  Toast.makeText(getApplicationContext(), "Ad left application!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdOpened() {
                mAdView.setVisibility(View.GONE);
                //    Toast.makeText(getApplicationContext(), "Ad is opened!", Toast.LENGTH_SHORT).show();
            }
        });


        //video Adv
        MobileAds.initialize(this, getString(R.string.AD_UNIT_ID));
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd.setRewardedVideoAdListener(this);
        loadRewardedVideoAd();

        initView();
    }

    private void loadRewardedVideoAd() {
        if (!mRewardedVideoAd.isLoaded()) {
            mRewardedVideoAd.loadAd(getString(R.string.AD_UNIT_ID), new AdRequest.Builder().build());
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
        layout11 = (LinearLayout) findViewById(R.id.layout11);
        layout12 = (LinearLayout) findViewById(R.id.layout12);
        layout13 = (LinearLayout) findViewById(R.id.layout13);
        layout14 = (LinearLayout) findViewById(R.id.layout14);
        layout15 = (LinearLayout) findViewById(R.id.layout15);
        layoutDiv = (LinearLayout) findViewById(R.id.layoutSub);
        layoutDiv.setVisibility(View.GONE);
        layoutLoadMore = (LinearLayout) findViewById(R.id.layoutLoadMore);


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
        layout11.setOnClickListener(this);
        layout12.setOnClickListener(this);
        layout13.setOnClickListener(this);
        layout14.setOnClickListener(this);
        layout15.setOnClickListener(this);


        layoutLoadMore.setOnClickListener(this);


    }

    private void setVisibleGone() {
        layout7.setVisibility(View.GONE);
        layout8.setVisibility(View.GONE);
        layout9.setVisibility(View.GONE);
        layout10.setVisibility(View.GONE);
        layout11.setVisibility(View.GONE);
        layout12.setVisibility(View.GONE);
        layout13.setVisibility(View.GONE);
        layout14.setVisibility(View.GONE);
        layout15.setVisibility(View.GONE);
    }

    private void setVisibleVisibile() {
        layout7.setVisibility(View.VISIBLE);
        layout8.setVisibility(View.VISIBLE);
        layout9.setVisibility(View.VISIBLE);
        layout10.setVisibility(View.VISIBLE);
        layout11.setVisibility(View.VISIBLE);
        layout12.setVisibility(View.VISIBLE);
        layout13.setVisibility(View.VISIBLE);
        layout14.setVisibility(View.VISIBLE);
        layout15.setVisibility(View.VISIBLE);
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
        Toast.makeText(this, "onRewardedVideoAdOpened", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewarded(RewardItem reward) {
        Toast.makeText(this,
                String.format(" onRewarded! currency: %s amount: %d", reward.getType(),
                        reward.getAmount()),
                Toast.LENGTH_SHORT).show();
        layoutLoadMore.setVisibility(View.GONE);
        layoutDiv.setVisibility(View.VISIBLE);

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
            case R.id.layout11:
                intent.putExtra("page", "11");
                CM.startActivity(intent, Viewhome.this);
                break;
            case R.id.layout12:
                intent.putExtra("page", "12");
                CM.startActivity(intent, Viewhome.this);
                break;
            case R.id.layout13:
                intent.putExtra("page", "13");
                CM.startActivity(intent, Viewhome.this);
                break;
            case R.id.layout14:
                intent.putExtra("page", "14");
                CM.startActivity(intent, Viewhome.this);
                break;
            case R.id.layout15:
                intent.putExtra("page", "15");
                CM.startActivity(intent, Viewhome.this);
                break;
            case R.id.layoutLoadMore:
                if (CM.isInternetAvailable(this)) {
                    showRewardedVideo();
                } else {
                    CM.showToast(getString(R.string.checkinternet), this);
                }
                break;

        }

    }


    @Override
    public void onResume() {
        mRewardedVideoAd.resume(this);

        if (mAdView != null) {
            mAdView.resume();
        }
        super.onResume();
    }

    @Override
    public void onPause() {
        mRewardedVideoAd.pause(this);
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onDestroy() {
        mRewardedVideoAd.destroy(this);
        if (mAdView != null) {
            mAdView.destroy();
        }
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


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (interstitialAd.isLoaded()) {
            interstitialAd.show();
        }
    }
}
