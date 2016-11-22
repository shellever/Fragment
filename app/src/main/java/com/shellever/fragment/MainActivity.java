package com.shellever.fragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.shellever.fragment.backtask.BackTaskActivity;
import com.shellever.fragment.basic.DeclareFragmentActivity;
import com.shellever.fragment.basic.ProgramFragmentActivity;
import com.shellever.fragment.interaction.InteractionFragmentActivity;
import com.shellever.fragment.preference.PreferenceFragmentActivity;

// Fragment
// import android.app.Fragment;
// import android.app.FragmentManager;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mDeclareFragmentBtn;
    private Button mProgramFragmentBtn;
    private Button mBackTaskFragmentBtn;
    private Button mInteractionFragmentBtn;
    private Button mPreferenceFragmentBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDeclareFragmentBtn = (Button) findViewById(R.id.btn_fragment_declare);
        mProgramFragmentBtn = (Button) findViewById(R.id.btn_fragment_program);
        mBackTaskFragmentBtn = (Button) findViewById(R.id.btn_fragment_back_task);
        mInteractionFragmentBtn = (Button) findViewById(R.id.btn_fragment_interaction);
        mPreferenceFragmentBtn = (Button) findViewById(R.id.btn_fragment_preference);

        mDeclareFragmentBtn.setOnClickListener(this);
        mProgramFragmentBtn.setOnClickListener(this);
        mBackTaskFragmentBtn.setOnClickListener(this);
        mInteractionFragmentBtn.setOnClickListener(this);
        mPreferenceFragmentBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_fragment_declare:
                useDeclareFragment();
                break;
            case R.id.btn_fragment_program:
                useProgramFragment();
                break;
            case R.id.btn_fragment_back_task:
                useBackTaskFragment();
                break;
            case R.id.btn_fragment_interaction:
                useInteractionFragment();
                break;
            case R.id.btn_fragment_preference:
                usePreferenceFragment();
                break;
        }
    }

    private void useDeclareFragment() {
        Intent intent = new Intent(MainActivity.this, DeclareFragmentActivity.class);
        startActivity(intent);
    }

    private void useProgramFragment() {
        Intent intent = new Intent(MainActivity.this, ProgramFragmentActivity.class);
        startActivity(intent);
    }

    private void useBackTaskFragment() {
        Intent intent = new Intent(MainActivity.this, BackTaskActivity.class);
        startActivity(intent);
    }

    private void useInteractionFragment() {
        Intent intent = new Intent(MainActivity.this, InteractionFragmentActivity.class);
        startActivity(intent);
    }

    private void usePreferenceFragment() {
        Intent intent = new Intent(MainActivity.this, PreferenceFragmentActivity.class);
        startActivity(intent);
    }
}
