package com.shellever.fragment.interaction;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.shellever.fragment.R;

public class InteractionFragmentActivity extends Activity implements MenuFragment.OnMenuClickListener {

    private MenuFragment menuFragment;
    private MainFragment mainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interaction_fragment);

        menuFragment = (MenuFragment) getFragmentManager().findFragmentById(R.id.frag_menu);
        mainFragment = (MainFragment) getFragmentManager().findFragmentById(R.id.frag_main);

        mainFragment.setMainContent("video");               // 初始化显示

//        menuFragment.setOnMenuClickListener(this);      // 手动注册监听器
    }

    @Override
    public void onMenuClickListener(String menu) {
        mainFragment.setMainContent(menu);
    }
}
