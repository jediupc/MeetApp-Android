package joandev.jedimeetingsapp.ui.profile_info;

import android.graphics.Bitmap;

import java.util.ArrayList;

/**
 * Created by albert on 07/05/15.
 */
public interface ProfileInfoView {

    void notifyUserName(String name);

    void notifyUserDepartment(String dpt);

    void notifyUserStatus(String status);

    void notifyUserAssemblies(String assemblies);

    void notifyUserMeetings(String meetings);

    void notifyUserProjects(ArrayList<String> projects);

    void notifyUserAvatar(Bitmap avatar);

    void hideSpinner();

    void showSpinner();

    String getResourceString(int id);
}
