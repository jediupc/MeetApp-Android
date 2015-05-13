package joandev.jedimeetingsapp.domain.use_cases.meeting_list;

import joandev.jedimeetingsapp.ui.MeetingList.MeetingAdapter;

/**
 * Created by marcos on 07/05/2015.
 */
public class MeetingListUseCaseImpl implements MeetingListUseCase {
    //TODO implement
    @Override
    public boolean newMeeting() {
        return false;
    }

    @Override
    public void refreshDataFilter(MeetingAdapter adapter, int dpt) {
            adapter.filterData(dpt);
    }

}
