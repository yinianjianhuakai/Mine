package sdkdemo.demo.com.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.*;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import com.sjx.handlereventbus.eventbus.OnRxEventListener;
import com.sjx.handlereventbus.eventbus.RxBus;
import com.sjx.handlereventbus.eventbus.RxData;
import sdkdemo.demo.com.myapplicatione.R;
import sdkdemo.demo.com.utils.FileNetEvent;
import sdkdemo.demo.com.utils.NetFileNameUtils;
import sdkdemo.demo.com.utils.NetMusicInputStream;
import sdkdemo.demo.com.utils.TDevice;

import java.io.ByteArrayInputStream;

/**
 * Created by  sjx  on 2020/8/26
 */
public class CustomWebViewActivity extends AppCompatActivity implements OnRxEventListener {

    private              WebView mWebView;
    private static final String  URL_STR = "https://m.ting22.com/ting/1751-%s.html";

    private static String CURRENT_PAGE = "618";
    private static String TARGET_PAGE  = "1800";

    private String mUrl   = "";
    private String mp3Url = "";

    private EditText startEt;
    private EditText endEt;

    private Handler mHandler = new Handler();

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RxBus.getInstance().register(this);
        setContentView(R.layout.layout_custom_web_view_activity);
        mWebView = findViewById(R.id.web_view);
        initWebView();
        initView();
    }

    private void initView() {
        startEt = findViewById(R.id.start_web_view);
        endEt = findViewById(R.id.end_web_view);

        onLastFile();

        endEt.setText(TARGET_PAGE);
        findViewById(R.id.start_tv).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mUrl = String.format(URL_STR, startEt.getText().toString().trim());
                mWebView.loadUrl(mUrl);
                TDevice.hideSoftKeyboard(CustomWebViewActivity.this);
            }
        });

        findViewById(R.id.end_tv).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                CustomWebViewActivity.this.finish();
                NetFileNameUtils.reCheckFile();
            }
        });
    }

    private void initWebView() {
        WebSettings webSettings = mWebView.getSettings();

        webSettings.setDefaultTextEncodingName("utf-8");
        webSettings.setJavaScriptEnabled(true);
        webSettings.setPluginState(WebSettings.PluginState.ON);
        webSettings.setSavePassword(true);
        webSettings.setSaveFormData(true);
        webSettings.setSupportMultipleWindows(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        webSettings.setBlockNetworkImage(false);
        webSettings.setDatabaseEnabled(true);
        String path = this.getApplicationContext().getDir("cache", this.MODE_PRIVATE).getPath();
        webSettings.setDatabasePath(path);
        webSettings.setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mWebView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }

        //支持缩放并且隐藏缩放按钮
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);

        mWebView.setWebChromeClient(new CustomWebChromeClient());
        mWebView.setWebViewClient(new CustomWebViewClient());
    }

    private class CustomWebChromeClient extends WebChromeClient {
        @Override
        public void onReceivedTouchIconUrl(WebView view, String url, boolean precomposed) {
            log("onReceivedTouchIconUrl url : " + url);
            super.onReceivedTouchIconUrl(view, url, precomposed);
        }

        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            log("onJsAlert url : " + url);
            return super.onJsAlert(view, url, message, result);
        }

        @Override
        public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
            log("onJsConfirm url : " + url);
            return super.onJsConfirm(view, url, message, result);
        }

        @Override
        public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
            log("onJsPrompt url : " + url);
            return super.onJsPrompt(view, url, message, defaultValue, result);
        }

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            log("onProgressChanged...newProgress : " + newProgress);
            if (newProgress == 100 && TextUtils.isEmpty(mp3Url)) {
                mHandler.postDelayed(new Runnable() {
                    public void run() {
//                        mWebView.loadUrl(mUrl);
                    }
                }, 4000);
            }
        }

        @Override
        public void onShowCustomView(View view, CustomViewCallback callback) {

        }

        @Override
        public void onHideCustomView() {

        }
    }

    private class CustomWebViewClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            log("shouldOverrideUrlLoading  url : " + url);
            if (!TextUtils.isEmpty(url) && (url.startsWith("tel:") || url.endsWith("apk"))) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
                return true;
            }

            if (!TextUtils.isEmpty(url) && (url.endsWith(".mp3") || url.endsWith(".m4a"))) {
                return true;
            }

//            if (!TextUtils.isEmpty(url)) {
//                url = url.toLowerCase();
//                boolean flag = url.startsWith("telnet") || url.startsWith("ftp")
//                        || url.startsWith("smtp") || url.startsWith("http")
//                        || url.startsWith("https") || url.startsWith("dns")
//                        || url.startsWith("ssh") || url.startsWith("pop")
//                        || url.startsWith("imap");
//                if (!flag) {
//                    return true;
//                }
//            }
            return super.shouldOverrideUrlLoading(view, url);
        }

        @Override
        public void onLoadResource(WebView view, String url) {
            log("onLoadResource url=" + url); // 开始加载
            requestMp3Url(url);
            super.onLoadResource(view, url);
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
            String pathUrl   = request.getUrl().getPath();
            String authority = request.getUrl().getAuthority();
            String host      = request.getUrl().getHost();
            log("shouldInterceptRequest pathUrl : " + pathUrl + "  authority : " + authority + "  host : " + host);
            if (host != null && ("https://img.alicdn.com".contains(host) || "www.jfsdiwmnbsk002.top".contains(host))) {
                log("https://img.alicdn.com\".contains(host) : true");
                String htmlPage = "<html>\n" +
                        "<title>千度</title>\n" +
                        "<body>\n" +
                        "<a href=\"www.taobao.com\">千度</a>,比百度知道的多10倍\n" +
                        "</body>\n" +
                        "<html>";
                byte[]               bytes       = htmlPage.getBytes();
                ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
                try {
//                    return new WebResourceResponse("text/css", "UTF-8", CustomWebViewActivity.this.getAssets().open("404.html"));
                    return new WebResourceResponse("text/html", "utf-8", inputStream);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                /*try {
                    return new WebResourceResponse("image/png", "utf-8", CustomWebViewActivity.this.getAssets().open("ic_launcher.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
            }
            return super.shouldInterceptRequest(view, request);
        }

        @Override
        public void onPageFinished(WebView view, String url) {

            String title = view.getTitle(); // 得到网页标题
            log("onPageFinished WebView title=" + title);

        }

        //处理https的证书问题，对所有证书信任
        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed();
        }

        @Override
        public void onReceivedError(WebView view, int errorCode,
                                    String description, String failingUrl) {
            log("onReceivedError...setPullRefreshEnable(true)....");
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            log("onPageStarted " + url);
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageCommitVisible(WebView view, String url) {
            log("onPageCommitVisible url : " + url);
            super.onPageCommitVisible(view, url);
        }
    }

    private void requestMp3Url(final String url) {
        if (url != null && (url.endsWith(".mp3") || url.endsWith(".m4a"))) {
            mp3Url = url;
            log("Start Thread to basic data... url : " + url);
            new Thread() {
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String fileName = getFileName();
                    if (!TextUtils.isEmpty(fileName)) {
                        new NetMusicInputStream().request(url, fileName);
                    }
                }
            }.start();

            String jsonStr = FileNetEvent.getInstance().createJson(getFileName(), url);
            FileNetEvent.getInstance().writeLine(jsonStr);
        }
    }

    private void log(String log) {
        Log.i("Test", log);
    }

    @Override
    public void onRxEvent(RxData event) {
        switch (event.getEventCode()) {
            case 321:
                String msg = (String) event.getObj1();
                String lastName = msg.substring(0, msg.lastIndexOf("."));
                int lastIndex = Integer.parseInt(lastName);
                log("lastIndex : " + lastIndex);
                if (lastIndex < Integer.parseInt(TARGET_PAGE)) {
                    mUrl = String.format(URL_STR, String.valueOf(lastIndex + 1));
                    mHandler.postDelayed(new Runnable() {
                        public void run() {
                            mp3Url = "";
                            mWebView.loadUrl(mUrl);
                        }
                    }, 1000);
                    onLastFile();
                }
                break;
            case 322:
                log("onEvent error..............");
                onLastFile();
                mp3Url = "";
//                mHandler.postDelayed(new Runnable() {
//                    public void run() {
//                        mWebView.loadUrl(mUrl);
//                    }
//                }, 3000);
                break;
        }
    }

    private void onLastFile() {
        int value = NetFileNameUtils.getLastFileName();
        if (value != -1) {
            CURRENT_PAGE = String.valueOf(value);
        }
        startEt.setText(CURRENT_PAGE);
    }

    private String getFileName() {
        int    lastIndexOf = mUrl.lastIndexOf("-") + 1;
        String fileName    = "";
        if (!TextUtils.isEmpty(mp3Url)) {
            if (mp3Url.endsWith(".mp3")) {
                fileName = mUrl.substring(lastIndexOf, mUrl.lastIndexOf(".")) + ".mp3";
            } else if (mp3Url.endsWith(".m4a")) {
                fileName = mUrl.substring(lastIndexOf, mUrl.lastIndexOf(".")) + ".m4a";
            }
        }
        return fileName;
    }

    protected void onDestroy() {
        RxBus.getInstance().unRegister(this);
        FileNetEvent.getInstance().onClose();
        mHandler.removeCallbacksAndMessages(null);
        mWebView.destroy();
        mWebView = null;
        super.onDestroy();
    }


}
