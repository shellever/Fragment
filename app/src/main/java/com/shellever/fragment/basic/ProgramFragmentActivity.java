package com.shellever.fragment.basic;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.shellever.fragment.R;

public class ProgramFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_fragment);

        addFragment();
    }

    // 通过代码添加Fragment
    private void addFragment() {
        // 获取Fragment管理器
        FragmentManager manager = getFragmentManager();

        // 通过管理器来启动一个Fragment事务
        FragmentTransaction transaction = manager.beginTransaction();

        // 添加一个Fragment
        ContentFragment fragment = new ContentFragment();
        transaction.add(R.id.fl_content, fragment);

        // 提交事务，使更改有效化
        transaction.commit();
    }
}
