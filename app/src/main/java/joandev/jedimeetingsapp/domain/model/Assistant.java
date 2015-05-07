package joandev.jedimeetingsapp.domain.model;

<<<<<<< HEAD
import android.view.View;
=======
import android.media.Image;
import android.widget.ImageView;
>>>>>>> ddb05325c7f4bde80deee398d5f274ad321847cf

/**
 * Created by joanbarroso on 30/4/15.
 */
public class Assistant {

    private String name;
    private String position;
    private View avatar;
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

<<<<<<< HEAD
=======
    public ImageView getAvatar() {
        return avatar;
    }

    public void setAvatar(ImageView avatar) {
        this.avatar = avatar;
    }


>>>>>>> ddb05325c7f4bde80deee398d5f274ad321847cf
}
