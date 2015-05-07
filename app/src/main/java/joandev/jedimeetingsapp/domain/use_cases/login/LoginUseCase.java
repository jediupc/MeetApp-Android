package joandev.jedimeetingsapp.domain.use_cases.login;

/**
 * Created by joanbarroso on 14/4/15.
 */
public interface LoginUseCase {
        void validateUser(String username, String password);
}
