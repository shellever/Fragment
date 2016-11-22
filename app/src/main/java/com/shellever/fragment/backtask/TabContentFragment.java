package com.shellever.fragment.backtask;

import android.annotation.SuppressLint;
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

public class TabContentFragment extends Fragment {

    private static final String ARG_TITLE = "title";

    private String title;

    // Required empty public constructor
    public TabContentFragment() {
    }

    // 屏幕旋转时会丢失掉数据title (不应该使用此方法传参数)
    @SuppressLint("ValidFragment")
    public TabContentFragment(String title) {
        this.title = title;
    }

    // Fragment的正确传参方法，使用静态工厂的方式
    public static TabContentFragment getInstance(String title) {
        TabContentFragment fragment = new TabContentFragment();

        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ARG_TITLE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_content, container, false);
        TextView tv = (TextView) view.findViewById(R.id.tv_tab_content);
        tv.setText(title);
        return view;
    }
}
