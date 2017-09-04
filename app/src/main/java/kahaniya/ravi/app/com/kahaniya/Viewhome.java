package kahaniya.ravi.app.com.kahaniya;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

public class Viewhome extends AppCompatActivity implements View.OnClickListener {


    LinearLayout layout1, layout2, layout3, layout4, layout5, layout6, layout7, layout8, layout9, layout10;

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
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        initView();
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
}
