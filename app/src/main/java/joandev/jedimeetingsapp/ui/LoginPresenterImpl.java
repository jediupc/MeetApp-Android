package joandev.jedimeetingsapp.ui;

import joandev.jedimeetingsapp.domain.use_cases.login.LoginUseCase;
import joandev.jedimeetingsapp.domain.use_cases.login.LoginUseCaseImpl;

/**
 * Created by joanbarroso on 14/4/15.
 */
public class LoginPresenterImpl implements LoginPresenter {

    private LoginView view;
    private LoginUseCase loginUseCase;
    private boolean spinning;

    public LoginPresenterImpl (LoginView loginView) {
        spinning = false;
        this.view = loginView;
        this.loginUseCase =  new LoginUseCaseImpl();
    }
    @Override
    public void validateCredentials(String username, String password) {
        //TODO: show spinner
        if (!spinning) view.showSpinner();
        else view.hideSpinner();
        spinning = !spinning;
        loginUseCase.validateUser(username, password);
    }

    @Override
    public void onUsernameError() {
        view.hideSpinner();
    }

    @Override
    public void onPasswordError() {
        view.hideSpinner();
    }

    @Override
    public void onSuccess() {
        view.hideSpinner();
    }


}
