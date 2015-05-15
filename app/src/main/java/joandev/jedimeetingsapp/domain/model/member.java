package joandev.jedimeetingsapp.domain.model;

import android.widget.ImageView;

/**
 * Created by Carles on 15/5/2015.
 */
public class Member {

    private String name;
    private String position;
    private ImageView avatar;


    public Member(String name, String[] position, ImageView avatar) {
    }

    public Member(){}

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ImageView getAvatar() {
        return avatar;
    }

    public void setAvatar(ImageView avatar) {
        this.avatar = avatar;
    }
}
