package com.example.rcpensoft;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
  
public class MainActivity extends AppCompatActivity {

    private WebView webview;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomWebViewClient client = new CustomWebViewClient(this);
        webview = findViewById(R.id.webview);
        webview.setWebViewClient(client);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl("https://happy-mestorf-7cf24a.netlify.app/");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode == KeyEvent.KEYCODE_BACK && this.webview.canGoBack()){
            this.webview.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}

class CustomWebViewClient extends WebViewClient{
    private Activity activity;
    public CustomWebViewClient(Activity activity){
        this.activity = activity;
    }
    //API LEVEL LESS THAN < 24
    @Override
    public boolean shouldOverrideUrlLoading(WebView webView, String url){
        return false;
    }

    //API LEVEL >=24
    @Override
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest request){
        return false;
    }
}