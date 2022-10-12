package work.hdjava.school.server.service;

import work.hdjava.school.server.bean.Permission;

import java.util.List;

/**
 * @author Fox
 */
public interface PermissionService  {

    List<Permission> selectByUserId(Long userId);
}
