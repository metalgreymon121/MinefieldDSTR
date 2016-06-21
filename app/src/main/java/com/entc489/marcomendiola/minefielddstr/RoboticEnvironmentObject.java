package com.entc489.marcomendiola.minefielddstr;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by Marco on 6/19/2016.
 */
public class RoboticEnvironmentObject {

    private Bitmap bitmap;
    private int x;
    private int y;

    public RoboticEnvironmentObject(Bitmap bitmap, int x, int y){
        this.bitmap = bitmap;
        this.x = x;
        this.y = y;
    }

    public Bitmap getBitmap(){
        return bitmap;
    }
    public void setBitmap(Bitmap bitmap){
        this.bitmap = bitmap;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public void draw(Canvas canvas){
        canvas.drawBitmap(bitmap, x - (bitmap.getWidth() / 2), y - (bitmap.getHeight() / 2), null);
    }
    public void update(){
        //get data from database
        //scale it
        //set coordinates of image equal to scaled coordinates
        scaleData(x,y);
    }
    public void scaleData(int x, int y){
        //scaling data
        //basketball court width is 10ft
        //length is 30ft
        //scale data according to amount of space in fragment
        //fragment width is 656 pixels
        //height is 775 pixels
        //using center of fragment as point of reference
        //therefore the values amount of pixels are halved
        x *= 32.8;
        y *= 12.9;
        setX(x);
        setY(y);
    }
}
