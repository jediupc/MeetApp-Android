package joandev.jedimeetingsapp.domain.use_cases.profile_info;

import joandev.jedimeetingsapp.Department;
import joandev.jedimeetingsapp.MemberStatus;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by albert on 07/05/15.
 */
public interface ProfileInfoUseCase {
    String getUserName();

    // TODO: Create enum Department
    Department getUserDepartment();

    MemberStatus getUserStatus();

    Calendar getUserStatusDate();

    Integer getUserJoinedAssembliesCount();

    Integer getTotalUserAssemblies();

    Integer getUserJoinedMeetingsCount();

    Integer getTotalUserMeetings();

    ArrayList<String> getUserProjects();
}
