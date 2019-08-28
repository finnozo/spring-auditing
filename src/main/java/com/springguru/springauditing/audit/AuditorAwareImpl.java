package com.springguru.springauditing.audit;

import com.springguru.springauditing.model.User;
import com.springguru.springauditing.security.UserPrincipal;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<Long> {

    private Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    /*@Override
    public Optional<User> getCurrentAuditor() {
        if (authentication == null || !authentication.isAuthenticated()) {
            return Optional.empty();
        }
        return Optional.of(getCurrentUser());
    }*/

    private User getCurrentUser() {
        return ((UserPrincipal) authentication.getPrincipal()).getUser();
    }

    @Override
    public Optional<Long> getCurrentAuditor() {
        //return Optional.empty();

        if (authentication == null || !authentication.isAuthenticated()) {
            return Optional.of(0L);
        }
        return Optional.of(getCurrentUser().getId());
    }
}
