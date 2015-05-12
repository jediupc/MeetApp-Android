package joandev.jedimeetingsapp.domain.model;

import android.widget.ImageView;

/**
 * Created by joanbarroso on 30/4/15.
 */
public class Assistant {

    private String name;
    private String position;
    private boolean assisted;
    private ImageView avatar;



    public Assistant(String name, String[] position, boolean assisted, ImageView avatar) {
    }

    public Assistant(){}

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

    public boolean isAssisted() {
        return assisted;
    }

    public void setAssisted(boolean assisted) {
        this.assisted = assisted;
    }

    public ImageView getAvatar() {
        return avatar;
    }

    public void setAvatar(ImageView avatar) {
        this.avatar = avatar;
    }


}
