package joandev.jedimeetingsapp.ui;

/**
 * Created by joanbarroso on 14/4/15.
 */
public interface LoginPresenter {

    void validateCredentials(String username, String password);

    void onUsernameError();

    void onPasswordError();

    void onSuccess();
}
