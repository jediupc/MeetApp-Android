package joandev.jedimeetingsapp.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.ParseAnalytics;
import com.parse.ParsePush;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import fr.castorflex.android.circularprogressbar.CircularProgressBar;
import joandev.jedimeetingsapp.R;
import joandev.jedimeetingsapp.ui.MeetingList.MeetingListActivity;


public class LoginActivity extends Activity implements LoginView {

    @InjectView(R.id.passwordET) EditText passwordET;
    @InjectView(R.id.userNameET) EditText userNameET;
    @InjectView(R.id.loginButton) Button loginButton;
    @InjectView(R.id.tv)TextView meeting;

    private CircularProgressBar mProgressBar;


    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.inject(this);
        mProgressBar = (CircularProgressBar) findViewById(R.id.progressbar_circular);
        presenter = new LoginPresenterImpl(this);
        ParseAnalytics.trackAppOpened(getIntent());

    }

    @OnClick (R.id.loginButton)
    public void loginButtonPressed() {
        presenter.validateCredentials(userNameET.getText().toString(), passwordET.getText().toString());
    }

    @OnClick (R.id.tv) public void meetingTextViewPressed() {
        ParsePush push = new ParsePush();
        push.setChannel("");
        push.setMessage("New event");
        push.sendInBackground();
            Intent intent = new Intent(this, MeetingListActivity.class);
            startActivity(intent);
        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public void hideSpinner() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showSpinner() {
        mProgressBar.setVisibility(View.VISIBLE);
    }
}
