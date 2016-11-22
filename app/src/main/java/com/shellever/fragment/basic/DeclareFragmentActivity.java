package com.shellever.fragment.basic;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.shellever.fragment.R;

// Fragment
// import android.app.Fragment;
// import android.app.FragmentManager;

public class DeclareFragmentActivity extends AppCompatActivity {

    private FragmentManager mFragmentManager;
    private TitleFragment mTitleFragment;
    private ContentFragment mContentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_declare_fragment);

        // 获取Fragment管理器
        mFragmentManager = getFragmentManager();
        // 通过Fragment管理器来获取Fragment实例
        mTitleFragment = (TitleFragment) mFragmentManager.findFragmentById(R.id.frag_title);
        mContentFragment = (ContentFragment) mFragmentManager.findFragmentById(R.id.frag_content);
    }
}
