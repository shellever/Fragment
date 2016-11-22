package com.shellever.fragment.backtask;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.shellever.fragment.R;

public class BackTaskActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mHomeTabBtn;
    private Button mSettingsTabBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_task);

        mHomeTabBtn = (Button) findViewById(R.id.btn_tab_home);
        mSettingsTabBtn = (Button) findViewById(R.id.btn_tab_settings);

        mHomeTabBtn.setOnClickListener(this);
        mSettingsTabBtn.setOnClickListener(this);

        switchToDefaultTabContent();       // initial state
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_tab_home:
                switchToHomeTabContent();
                break;
            case R.id.btn_tab_settings:
                switchToSettingsTabContent();
                break;
        }
    }

    private void switchToDefaultTabContent() {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        // TabContentFragment fragment = new TabContentFragment("Home Tab Content");
        TabContentFragment fragment = TabContentFragment.getInstance("Home Tab Content");

        transaction.replace(R.id.fl_content_tab, fragment);
        // 防止点击Back键时出现白板，故初始化时不将此fragment添加到返回栈中
        // transaction.addToBackStack(null);
        transaction.commit();
    }

    private void switchToHomeTabContent() {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        // TabContentFragment fragment = new TabContentFragment("Home Tab Content");
        TabContentFragment fragment = TabContentFragment.getInstance("Home Tab Content");

        transaction.replace(R.id.fl_content_tab, fragment);
        transaction.addToBackStack(null); // 在切换至HomeTab时，将上一个fragment界面保存到返回栈，但会出现重复添加同一个fragment
        transaction.commit();
    }

    private void switchToSettingsTabContent() {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        // TabContentFragment fragment = new TabContentFragment("Settings Tab Content");
        TabContentFragment fragment = TabContentFragment.getInstance("Settings Tab Content");

        transaction.replace(R.id.fl_content_tab, fragment);
        transaction.addToBackStack(null); // 在切换至SettingsTab时，将上一个fragment界面保存到返回栈
        transaction.commit();
    }

    // 魅蓝note2按中键键时也默认会进行Fragment出栈操作，可省略该方法
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) { // 返回按钮按下
            // 如果Fragment管理器中返回栈实体数目为零，则直接退出Activity
            if (getFragmentManager().getBackStackEntryCount() == 0) {
                finish();
            } else {    // 否则将fragment进行出栈操作
                getFragmentManager().popBackStack();        // 将fragment出栈
            }
            return true;        // 拦截此事件，不然会出现出栈错误
        }
        return super.onKeyDown(keyCode, event);
    }
}
