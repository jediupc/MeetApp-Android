package joandev.jedimeetingsapp;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParsePush;
import com.parse.PushService;

import joandev.jedimeetingsapp.R;
import joandev.jedimeetingsapp.ui.login.LoginActivity;

public class Application extends android.app.Application {

    public Application() {
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // Initialize the Parse SDK.
        Parse.initialize(this, getString(R.string.APP_ID), getString(R.string.CLIENT_KEY));

        // Specify an Activity to handle all pushes by default.
        PushService.setDefaultPushCallback(this, LoginActivity.class);
    }
}