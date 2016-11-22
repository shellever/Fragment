package com.shellever.fragment.interaction;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shellever.fragment.R;

/**
 * Author: Shellever
 * Date:   11/22/2016
 * Email:  shellever@163.com
 */

public class MainFragment extends Fragment {

    private TextView mMainContentTv;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mMainContentTv = (TextView) view.findViewById(R.id.tv_main_content);

        return view;
    }

    public void setMainContent(String value){
        mMainContentTv.setText(value);
    }
}
