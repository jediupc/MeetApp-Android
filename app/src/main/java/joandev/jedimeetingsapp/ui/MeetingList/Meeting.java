package joandev.jedimeetingsapp.ui.MeetingList;

/**
 * Created by marcos on 28/04/2015.
 */
public class Meeting {
    private int dpt;
    private String subject;
    private String hour;
    private String day;
    private String month;

    public Meeting(){
    }
    public Meeting(int dpt, String sub, String hour, String day, String month){
        this.dpt = dpt;
        this.subject = sub;
        this.hour = hour;
        this.day = day;
        this.month = month;
    }

    public int getDpt() {
        return dpt;
    }

    public void setDpt(int dpt) {
        this.dpt = dpt;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
