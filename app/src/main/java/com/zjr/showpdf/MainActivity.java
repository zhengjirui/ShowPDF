package com.zjr.showpdf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebSettings.LayoutAlgorithm;
//http://www.2cto.com/kf/201303/192498.html
//实现者：http://zhidao.baidu.com/link?url=OGedS4Mg4BBIl2EdIEJm6EprlP9JEwjtHVo4lhPGxJwpWJC8UMe8rhpzzdvWRvMwhgTTc7rXmfhBPUBVTkyIsy1ixF_oitPLV1DlqemBMiK
public class MainActivity extends AppCompatActivity {
    private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init() {
        mWebView=(WebView) findViewById(R.id.webView);
        //方法1
        //loadPDF1();
        //方法2
        loadPDF2();
    }

    //方法1:利用设备自带浏览器打开pdf
    private void loadPDF1(){
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setSupportZoom(true);
        mWebView.getSettings().setDomStorageEnabled(true);
        mWebView.getSettings().setAllowFileAccess(true);
        //mWebView.getSettings().setPluginsEnabled(true);
        mWebView.getSettings().setUseWideViewPort(true);
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.requestFocus();
        mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebView.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
        String pdfUrl = "http://www8.cao.go.jp/okinawa/8/2012/0409-1-1.pdf";
        mWebView.loadUrl("http://docs.google.com/gview?embedded=true&url=" +pdfUrl);

    }
    //方法2:利用Google服务解析后再在mWebView中打开pdf
    private void loadPDF2(){
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setSupportZoom(true);
        mWebView.getSettings().setDomStorageEnabled(true);
        mWebView.getSettings().setAllowFileAccess(true);
        //mWebView.getSettings().setPluginsEnabled(true);
        mWebView.getSettings().setUseWideViewPort(true);
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.requestFocus(); // www.2cto.com
        mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebView.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
        String pdfUrl = "http://www8.cao.go.jp/okinawa/8/2012/0409-1-1.pdf";
        String data = "<iframe src='http://docs.google.com/gview?embedded=true&url="+pdfUrl+"'"+" width='100%' height='100%' style='border: none;'></iframe>";
        mWebView.loadData(data, "text/html", "UTF-8");

    }

}
