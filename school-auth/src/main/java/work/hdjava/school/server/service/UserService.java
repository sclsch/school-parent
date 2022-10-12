package work.hdjava.school.server.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import work.hdjava.school.server.bean.User;

/**
 * @author Fox
 */
public interface UserService extends UserDetailsService {

    User getByUsername(String username);
}
