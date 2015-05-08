package joandev.jedimeetingsapp.ui.MeetingList;

import joandev.jedimeetingsapp.domain.use_cases.login.meeting_list.MeetingListUseCase;
import joandev.jedimeetingsapp.domain.use_cases.login.meeting_list.MeetingListUseCaseImpl;

/**
 * Created by marcos on 28/04/2015.
 */
public class MeetingListPresenterImpl implements MeetingListPresenter {
        private MeetingView view;
        private MeetingListUseCase meetingListUseCase;

        public MeetingListPresenterImpl(MeetingView v){
            this.view = v;
            meetingListUseCase = new MeetingListUseCaseImpl();
        }
        @Override
        public void filterData(int dpt) {
            meetingListUseCase.refreshDataFilter(view.getAdapter(), dpt);
        }
}
