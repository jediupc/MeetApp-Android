package joandev.jedimeetingsapp.ui.profile_info;

import joandev.jedimeetingsapp.R;
import joandev.jedimeetingsapp.domain.use_cases.profile_info.ProfileInfoUseCase;
import joandev.jedimeetingsapp.domain.use_cases.profile_info.ProfileInfoUseCaseImpl;

/**
 * Created by albert on 07/05/15.
 */
public class ProfileInfoPresenterImpl implements ProfileInfoPresenter {

    ProfileInfoView view;
    ProfileInfoUseCase model;

    public ProfileInfoPresenterImpl(ProfileInfoView v) {
        this.view = v;
        model = new ProfileInfoUseCaseImpl();
    }

    @Override
    public void retrieveUserInfo() {
        view.showSpinner();


        view.notifyUserName(model.getUserName());

        // TODO: Change enum toString for string resource replacement
        view.notifyUserDepartment(model.getUserDepartment().toString());

        // TODO: Change enum toString for string resource replacement
        String userStatus = view.getResourceString(
                R.string.user_profile_status_since
        ).replace("[status]", model.getUserStatus().toString())
                .replace("[date]", model.getUserStatusDate().toString());

        view.notifyUserStatus(userStatus);

        view.notifyUserAssemblies(view.getResourceString(
                R.string.user_profile_joined_assemblies
        ).replace("[njoined]", model.getUserJoinedAssembliesCount().toString())
                .replace("[ntotal]",
                        model.getTotalUserAssemblies().toString()));

        view.notifyUserMeetings(view.getResourceString(
                R.string.user_profile_joined_meetings
        ).replace("[njoined]", model.getUserJoinedMeetingsCount().toString())
                .replace("[ntotal]", model.getTotalUserMeetings().toString()));

        view.notifyUserProjects(model.getUserProjects());


        view.hideSpinner();
    }
}
