package work.hdjava.school.auth.service;

import work.hdjava.school.auth.bean.Permission;

import java.util.List;

/**
 * @author Fox
 */
public interface PermissionService  {

    List<Permission> selectByUserId(Long userId);
}
