package com.shellever.fragment.preference;

import android.app.Activity;
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

public class OperationFragment extends Fragment implements View.OnClickListener {

    private TextView mPrefsContentTv;

    private OnButtonClickListener mListener;

    public OperationFragment() {
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnButtonClickListener) {
            mListener = (OnButtonClickListener) activity;
        } else {
            mListener = null;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_operation, container, false);

        view.findViewById(R.id.btn_setup_prefs).setOnClickListener(this);
        view.findViewById(R.id.btn_view_prefs).setOnClickListener(this);
        mPrefsContentTv = (TextView) view.findViewById(R.id.tv_prefs_content);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_setup_prefs:
                mListener.onButtonClickListener(R.id.btn_setup_prefs);
                break;
            case R.id.btn_view_prefs:
                mListener.onButtonClickListener(R.id.btn_view_prefs);
                break;
        }
    }

    public void setPrefsContent(String value){
        mPrefsContentTv.setText(value);
    }

    public interface OnButtonClickListener {
        void onButtonClickListener(int viewId);
    }
}
