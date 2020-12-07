package pl.coderslab.letsbefit.app;

import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {

    public static String login(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
