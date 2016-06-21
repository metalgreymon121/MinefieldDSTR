package com.entc489.marcomendiola.minefielddstr;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Marco on 6/18/2016.
 */
public class TheCanvas extends SurfaceView implements SurfaceHolder.Callback {
    float width;
    float height;
    int x, y;
    SurfaceHolder surfaceHolder;

    TheThread thread;
    RoboticEnvironmentObject dstr1, dstr2, dstr3, dstr4;
    RoboticEnvironmentObject asep;
    RoboticEnvironmentObject beacon1, beacon2, beacon3;


    public TheCanvas(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TheCanvas(Context context) {
        super(context);
        init();
    }

    private void init() {
        getHolder().addCallback(this);
        beacon1 = new RoboticEnvironmentObject(BitmapFactory.decodeResource(getResources(), R.drawable.beacon), 50, 50);
        beacon2 = new RoboticEnvironmentObject(BitmapFactory.decodeResource(getResources(), R.drawable.beacon), 606, 50);
        beacon3 = new RoboticEnvironmentObject(BitmapFactory.decodeResource(getResources(), R.drawable.beacon), 50, 725);
        dstr1 = new RoboticEnvironmentObject(BitmapFactory.decodeResource(getResources(), R.drawable.dstr), 50, 130);
        dstr2 = new RoboticEnvironmentObject(BitmapFactory.decodeResource(getResources(), R.drawable.dstr), 50, 210);
        dstr3 = new RoboticEnvironmentObject(BitmapFactory.decodeResource(getResources(), R.drawable.dstr), 50, 290);
        dstr4 = new RoboticEnvironmentObject(BitmapFactory.decodeResource(getResources(), R.drawable.dstr), 50, 370);
        asep = new RoboticEnvironmentObject(BitmapFactory.decodeResource(getResources(), R.drawable.asep), 50, 450);
        thread = new TheThread(getHolder(), this);
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        if (canvas != null) {
            canvas.drawColor(Color.WHITE);
            beacon1.draw(canvas);
            beacon2.draw(canvas);
            beacon3.draw(canvas);
            dstr1.draw(canvas);
            dstr2.draw(canvas);
            dstr3.draw(canvas);
            dstr4.draw(canvas);
            asep.draw(canvas);
        }

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
//        this.x = width;
//        this.y = height;
//        dstr1.setX(x);
//        dstr1.setY(y);

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        thread.setRunning(false);
        thread = null;
    }


    public void updateAll() {
//        dstr1.update();
//        dstr2.update();
//        dstr3.update();
//        dstr4.update();
//        asep.update();
    }


//    public void pause() {
//        if (thread != null || thread.running == false) {
//            thread.setRunning(false);
//            thread = null;
//        }
//    }

    public void unpause() {
        if (thread == null || thread.running == true) {
            thread.setRunning(true);
            thread = new TheThread(getHolder(),this);
            thread.start();
        }
    }

}
