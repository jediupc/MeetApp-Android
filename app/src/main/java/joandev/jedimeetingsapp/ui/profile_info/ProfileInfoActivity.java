package joandev.jedimeetingsapp.ui.profile_info;

import android.app.Activity;
import android.graphics.*;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import fr.castorflex.android.circularprogressbar.CircularProgressBar;
import joandev.jedimeetingsapp.R;

import java.util.ArrayList;

public class ProfileInfoActivity extends Activity implements ProfileInfoView {
    @InjectView(R.id.userNameTV) TextView userNameTV;
    @InjectView(R.id.userAvatarIV) ImageView userAvatarTV;
    @InjectView(R.id.userDptTV) TextView userDptTV;
    @InjectView(R.id.userStatusDateTV) TextView userStatusTV;
    @InjectView(R.id.userAssembliesTV) TextView userAssembliesTV;
    @InjectView(R.id.userMeetingsTV) TextView userMeetingsTV;
    @InjectView(R.id.projectsLV) ListView projectsSV;
    @InjectView(R.id.profileInfoCPB) CircularProgressBar mProgressBar;

    ProfileInfoPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_info);
        ButterKnife.inject(this);
        presenter = new ProfileInfoPresenterImpl(this);
        presenter.retrieveUserInfo();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_profile_info, menu);
        return true;
    }

    @OnClick(R.id.moreJedisBT)
    public void onMoreJedisClicked() {
        // TODO: Jump to Jedi's list view
    }

    @Override
    public void notifyUserName(String name) {
        userNameTV.setText(name);
    }

    @Override
    public void notifyUserDepartment(String dpt) {
        userDptTV.setText(dpt);
    }

    @Override
    public void notifyUserStatus(String status) {
        userStatusTV.setText(status);
    }

    @Override
    public void notifyUserAssemblies(String assemblies) {
        userAssembliesTV.setText(assemblies);
    }

    @Override
    public void notifyUserMeetings(String meetings) {
        userMeetingsTV.setText(meetings);
    }

    @Override
    public void notifyUserProjects(ArrayList<String> projects) {
        // TODO: Set the adapter and put the projects info
    }

    @Override
    public void notifyUserAvatar(Bitmap avatar) {
        userAvatarTV.setImageBitmap(getRoundedBitmap(avatar));
    }

    @Override
    public void hideSpinner() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showSpinner() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public String getResourceString(int id) {
        return getResources().getString(id);
    }

    public static Bitmap getRoundedBitmap(Bitmap bitmap) {
        final Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(), Bitmap.Config.ARGB_8888);

        final Canvas canvas = new Canvas(output);

        final int color = Color.RED;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawOval(rectF, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);

        bitmap.recycle();

        return output;
    }
}
