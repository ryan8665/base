package com.secure;

        import java.util.ArrayList;
        import java.util.HashSet;
        import java.util.List;
        import java.util.Set;

        import com.dao.UserDao;
        import com.model.UserRole;
        import org.springframework.security.core.GrantedAuthority;
        import org.springframework.security.core.authority.SimpleGrantedAuthority;
        import org.springframework.security.core.userdetails.User;
        import org.springframework.security.core.userdetails.UserDetails;
        import org.springframework.security.core.userdetails.UserDetailsService;
        import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class userDetail implements UserDetailsService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //todo load user from DB
        com.model.User user = new com.model.User();
        List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());
        return buildUserForAuthentication(user, authorities);
    }

    private User buildUserForAuthentication(com.model.User user,
                                            List<GrantedAuthority> authorities) {
        return new User(user.getUsername(),
                user.getPassword(), user.isEnabled(),
                true, true, true, authorities);
    }


    private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
        // Build user's authorities
        for (UserRole userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
        }
        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
        return Result;
    }

}