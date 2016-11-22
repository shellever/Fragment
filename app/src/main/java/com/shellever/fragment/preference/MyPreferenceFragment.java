package com.shellever.fragment.preference;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.shellever.fragment.R;

/**
 * Author: Shellever
 * Date:   11/22/2016
 * Email:  shellever@163.com
 */

public class MyPreferenceFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);      // 从xml文件加载选项
    }
}
