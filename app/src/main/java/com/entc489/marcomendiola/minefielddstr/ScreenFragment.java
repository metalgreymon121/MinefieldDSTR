package com.entc489.marcomendiola.minefielddstr;


import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * This fragment is in charge of drawing the basketball court.
 * It will draw the static locations of the beacons,
 * the location of the DSTR and ASEP robots in real time,
 * and the locations of the mines the DSTR robots find.
 */
public class ScreenFragment extends Fragment {
    private final int CONTEXT_CLIENT_VERSION = 2;
    private GLSurfaceView glSurfaceView;

    int amountofMinesFound = 0;
    DSTR DSTR1 = new DSTR(0, 0, false);
    DSTR DSTR2 = new DSTR(0, 0, false);
    DSTR DSTR3 = new DSTR(0, 0, false);
    DSTR DSTR4 = new DSTR(0, 0, false);

    //create a new instance of this fragment
    public static ScreenFragment newInstance() {
        ScreenFragment fragment = new ScreenFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_screen, container, false);
        glSurfaceView = (GLSurfaceView) view.findViewById(R.id.glSurfaceView);
        glSurfaceView.setEGLContextClientVersion(3);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        //setting your renderer here causes onSurfaceCreated to be called
        //if you set your renderer here then you have a context to load resources
        super.onActivityCreated(savedInstanceState);
        glSurfaceView.setEGLContextClientVersion(CONTEXT_CLIENT_VERSION);
        glSurfaceView.setRenderer(new ScreenRenderer(getActivity()));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Fragment", "OnCreate");
    }

    @Override
    public void onPause() {
        super.onPause();
        glSurfaceView.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        glSurfaceView.onResume();
    }

}
