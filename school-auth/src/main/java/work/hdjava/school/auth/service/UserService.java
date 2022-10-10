package work.hdjava.school.auth.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import work.hdjava.school.auth.bean.User;

/**
 * @author Fox
 */
public interface UserService extends UserDetailsService {

    User getByUsername(String username);
}
