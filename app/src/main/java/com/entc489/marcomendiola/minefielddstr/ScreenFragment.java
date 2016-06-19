package com.entc489.marcomendiola.minefielddstr;


import android.os.Bundle;
import android.support.v4.app.Fragment;
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

        PixelGridView pixelGridView = new PixelGridView(getActivity());
        pixelGridView.findViewById(R.id.pixelGridView);
        pixelGridView.setNumColumns(8);
        pixelGridView.setNumRows(8);

        return pixelGridView;
    }


}
