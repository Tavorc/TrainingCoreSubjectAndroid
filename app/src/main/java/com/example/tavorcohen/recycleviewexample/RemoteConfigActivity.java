package com.example.tavorcohen.recycleviewexample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

import java.util.ArrayList;

public class RemoteConfigActivity extends AppCompatActivity {

    private FirebaseRemoteConfig mFirebaseRemoteConfig;
    private static final String KEY_HOST="host";
    private static final String KEY_PROD = "prod";
    private WebView mWebView;
    private ArrayList<String> mPhoneNumberList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote_config);
        initView();
        initRemoteConfig();
        fetch();
    }


    private void initView(){
        mWebView = findViewById(R.id.webView);
        mPhoneNumberList =new ArrayList<>();
        mPhoneNumberList.add("0542341881");
    }

    /**
     * function that init the remote config
     */
    public void initRemoteConfig(){
        mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings
                .Builder()
                .setDeveloperModeEnabled(BuildConfig.DEBUG)
                .setMinimumFetchIntervalInSeconds(3600)
                .build();
        mFirebaseRemoteConfig.setConfigSettings(configSettings);
        mFirebaseRemoteConfig.setDefaults(R.xml.remote_config_defaults);
    }

    /**
     * fetch and activate the remote config
     */
    private void fetch(){
        mFirebaseRemoteConfig.fetchAndActivate()
                .addOnCompleteListener(this, new OnCompleteListener<Boolean>() {
                    @Override
                    public void onComplete(@NonNull Task<Boolean> task) {
                        if (task.isSuccessful()) {
                            boolean result = task.getResult();
                            Toast.makeText(RemoteConfigActivity.this, "Fetch and activate succeeded",
                                    Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(RemoteConfigActivity.this, "Fetch failed",
                                    Toast.LENGTH_SHORT).show();
                        }
                        displayUrl();
                    }
                });
    }

    /**
     * display the url on webview by the key of the remote config
     */
    public void displayUrl() {
        String urlDev = mFirebaseRemoteConfig.getString(KEY_HOST);
        mWebView.loadUrl(urlDev);
    }


    private String getUserPhone(){
        return "0542341881";
    }
}
