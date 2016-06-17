package com.entc489.marcomendiola.minefielddstr;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
/*
* This class will call the screen fragment,
* query the ThingWorx cloud to get data on the pressure and temperature of the basketball court,
* and send data to the ThingWorx cloud to start, pause or stop the DSTR robots.
*/
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //connect MainActivity with xml buttons
        ImageButton start = (ImageButton) findViewById(R.id.buttonStart);
        ImageButton pause = (ImageButton) findViewById(R.id.buttonPause);
        ImageButton stop = (ImageButton) findViewById(R.id.buttonStop);

        //have buttons listen for clicks
        start.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);

        //place screenfragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ScreenFragment screenFragment = ScreenFragment.newInstance();
        fragmentTransaction.replace(R.id.content_frame, screenFragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonStart:
                Toast.makeText(getApplicationContext(), "Start works", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonPause:
                Toast.makeText(getApplicationContext(), "Pause works", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonStop:
                Toast.makeText(getApplicationContext(), "Stop works", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
