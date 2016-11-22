package com.shellever.fragment.preference;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.shellever.fragment.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class PreferenceFragmentActivity extends AppCompatActivity implements OperationFragment.OnButtonClickListener {

    private OperationFragment mOperationFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference_fragment);

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        mOperationFragment = new OperationFragment();
        ft.add(R.id.fl_prefs, mOperationFragment);
        ft.commit();
    }

    @Override
    public void onButtonClickListener(int viewId) {
        switch (viewId) {
            case R.id.btn_setup_prefs:
                setupPreferences();
                break;
            case R.id.btn_view_prefs:
                viewPreferences();
                break;
        }
    }

    private void setupPreferences() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        MyPreferenceFragment fragment = new MyPreferenceFragment();
        ft.replace(R.id.fl_prefs, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    private void viewPreferences() {
        // SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        // String city_name = sp.getString("city_name", "");
        mOperationFragment.setPrefsContent(getSharedPreferencesXML("preferences"));
    }

    private String getSharedPrefsFileString(Context context, String name) {
        String path = context.getFilesDir().getParent();// 获取文件目录的父目录路径
        String packageName = getPackageName();          // 获取包名
        // /data/data/com.shellever.fragment/shared_prefs/com.shellever.fragment_preferences.xml
        return path + "/shared_prefs/" + packageName + "_" + name + ".xml"; // SharedPreferences生成的xml数据文件
    }

    private String getSharedPreferencesXML(String name) {
        String file = getSharedPrefsFileString(this, name);
        String text = file;
        text += "\n\n";

        FileInputStream fis = null;
        ByteArrayOutputStream out = null;
        try {
            fis = new FileInputStream(file);        // 构建文件输入流
            out = new ByteArrayOutputStream();      // 构建字节数组输出流
            int len;                                // 记录每次读取数据的大小，-1表示结束
            byte[] buffer = new byte[10 * 1024];    // 定义10kB大小的缓冲区
            while ((len = fis.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            text += out.toString();
            return text;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }
}
