package joandev.jedimeetingsapp.domain.use_cases.login.meeting_list;

import joandev.jedimeetingsapp.ui.MeetingList.MeetingAdapter;

/**
 * Created by marcos on 07/05/2015.
 */
public interface MeetingListUseCase {
    public boolean newMeeting();

    void refreshDataFilter(MeetingAdapter adapter, int dpt);
}
