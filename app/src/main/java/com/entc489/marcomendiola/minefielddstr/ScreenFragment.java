package com.entc489.marcomendiola.minefielddstr;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * This fragment is in charge of drawing the basketball court.
 * It will draw the static locations of the beacons,
 * the location of the DSTR and ASEP robots in real time,
 * and the locations of the mines the DSTR robots find.
 */
public class ScreenFragment extends Fragment {

    TheCanvas theCanvas;
    TheThread thread;
    String screenXY = ",";
    int amountofMinesFound = 0;

    int fragmentWidth;
    int fragmentHeight;
    int calls;
    int percent;

    //create a new instance of this fragment
    public static ScreenFragment newInstance() {
        ScreenFragment fragment = new ScreenFragment();

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_screen, container, false);
        theCanvas = (TheCanvas) view.findViewById(R.id.theCanvas);
        return view;
    }

//    @Override
//    public void onResume() {
//        super.onResume();
//       theCanvas.unpause();
//    }

//    @Override
//    public void onPause() {
//        super.onPause();
//        theCanvas.pause();
//    }


}
