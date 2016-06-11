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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Canvas canvas;
    Paint paint;
    private static Context context;

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

        //draw basketball court;
        // createRect(MainActivity.context = getApplicationContext());
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

    public void createRect(Context context) {
        float width = 0;
        float height = 0;

        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        width = metrics.widthPixels;
        height = metrics.heightPixels;

        float left = 0;
        float top = 0;
        float right = width - 16;
        float bottom = (height * 75) / 100;

        paint.setColor(Color.BLACK);
        canvas.drawRect(left, top, right, bottom, paint);
    }

    /**
     * This method converts dp unit to equivalent pixels, depending on device density.
     * dp  = A value in dp (density independent pixels) unit. Which we need to convert into pixels
     * context = Context to get resources and device specific display metrics
     * Returns: A float value to represent px equivalent to dp depending on device density
     */
    public static float convertDpToPixel(float dp, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }

    /**
     * This method converts device specific pixels to density independent pixels.
     * px = A value in px (pixels) unit. Which we need to convert into db
     * context = Context to get resources and device specific display metrics
     * Returns: A float value to represent dp equivalent to px value
     */
    public static float convertPixelsToDp(float px, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float dp = px / ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return dp;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonStart:
                Toast.makeText(getApplicationContext(), "Start works", Toast.LENGTH_LONG).show();
                break;
            case R.id.buttonPause:
                Toast.makeText(getApplicationContext(), "Pause works", Toast.LENGTH_LONG).show();
                break;
            case R.id.buttonStop:
                Toast.makeText(getApplicationContext(), "Stop works", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
