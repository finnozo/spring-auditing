package com.springguru.springauditing.audit;

import com.springguru.springauditing.model.User;
import com.springguru.springauditing.security.UserPrincipal;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuditorAwareImpl implements AuditorAware<Long> {




    /*@Override
    public Optional<User> getCurrentAuditor() {
        if (authentication == null || !authentication.isAuthenticated()) {
            return Optional.empty();
        }
        return Optional.of(getCurrentUser());
    }*/

    private User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return ((UserPrincipal) auth.getPrincipal()).getUser();
    }

    @Override
    public Optional<Long> getCurrentAuditor() {
        User currentUser = getCurrentUser();
        if (currentUser == null) {
            return Optional.of(0L);
        }
        return Optional.of(currentUser.getId());
    }
}
