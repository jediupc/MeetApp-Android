package joandev.jedimeetingsapp.ui.JediList;

/**
 * Created by Florencia Tarditti on 10/05/15.
 */
public class Jedi {

    private String name;
    private String position;

    public Jedi() {

    }

    public Jedi(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

}
