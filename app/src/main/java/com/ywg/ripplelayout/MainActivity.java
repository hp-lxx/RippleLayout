package com.ywg.ripplelayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener{

    private Button mBtnRipple1;

    private Button mBtnRipple2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //XML设置水波纹效果
        mBtnRipple1 = (Button) findViewById(R.id.btn_ripple1);
        mBtnRipple1.setOnClickListener(this);
        mBtnRipple1.setOnLongClickListener(this);

        //代码设置水波纹效果
        mBtnRipple2 = (Button) findViewById(R.id.btn_ripple2);
        RippleLayout.on(mBtnRipple2)
                .rippleColor(Color.parseColor("#FF0000"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();

        mBtnRipple2.setOnLongClickListener(this);
        mBtnRipple2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Short click", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onLongClick(View v) {
        if (v.getId() == R.id.btn_ripple1) {
            Toast.makeText(this, "Long click not consumed", Toast.LENGTH_SHORT).show();
            return false;
        }
        Toast.makeText(this, "Long click and consumed", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.switch_list) {
            startActivity(new Intent(this, ListActivity.class));
            finish();
            return true;
        } else if (id == R.id.switch_recycler) {
            startActivity(new Intent(this, RecyclerActivity.class));
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
