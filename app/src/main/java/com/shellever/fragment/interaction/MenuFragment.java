package com.shellever.fragment.interaction;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.shellever.fragment.R;

/**
 * Author: Shellever
 * Date:   11/22/2016
 * Email:  shellever@163.com
 */

public class MenuFragment extends Fragment implements View.OnClickListener {

    private OnMenuClickListener mListener;

    public MenuFragment() {
        // Required empty public constructor
    }

    // ============================================================
    // http://blog.csdn.net/hiccuphiccup/article/details/51009211
    // 经测试，此方法没有被正常调用，需要在api23中才能使用
    // 低于api23的会调用onAttach(Activity activity)
    @TargetApi(23)
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnMenuClickListener) {
            mListener = (OnMenuClickListener) context;
        } else {
            mListener = null;
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnMenuClickListener) {
            mListener = (OnMenuClickListener) activity;
        } else {
            mListener = null;
        }
    }
    // ============================================================

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        view.findViewById(R.id.btn_menu_video).setOnClickListener(this);
        view.findViewById(R.id.btn_menu_focus).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_menu_video:
                if (mListener != null) {
                    mListener.onMenuClickListener("video");
                }
                break;
            case R.id.btn_menu_focus:
                if (mListener != null) {
                    mListener.onMenuClickListener("focus");
                }
                break;
        }
    }

    // 用于外部手动注册事件监听
    public void setOnMenuClickListener(OnMenuClickListener listener){
        mListener = listener;
    }

    public interface OnMenuClickListener {
        void onMenuClickListener(String menu);
    }
}
