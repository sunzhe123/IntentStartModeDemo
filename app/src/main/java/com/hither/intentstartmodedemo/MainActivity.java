package com.hither.intentstartmodedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String toast = "http://news.jstv.com";
    private WebView webview;
    private static final int TAG_ONCREAT = 1;
    private static final int TAG_NEWINTENT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        processExtraData(TAG_ONCREAT);
    }

    public void startNew(View v) {
        Intent intent = new Intent(this, NewActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        processExtraData(TAG_NEWINTENT);
    }

    /**
     * 系统可能会随时杀掉后台运行的Activity，如果这一切发生，那么系统就会调用onCreate方法，
     * 而不调用onNewIntent方法，一个好的解决方法就是在onCreate和onNewIntent方法中调用同一个处理数据的方法
     *
     * @param tag:用来判断是从onCreate方法调用还是从onNewIntent方法调用, 省去每次从onNewIntent方法中调用时候获取webview的引用
     */
    private void processExtraData(int tag) {
        if (tag == TAG_ONCREAT) {
            webview = (WebView) findViewById(R.id.webView);
        }
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("test");
        if (stringExtra != null && !TextUtils.isEmpty(stringExtra)) {
            toast = stringExtra;
        }
        webview.loadUrl(toast);
    }
}
