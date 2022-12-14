package work.hdjava.school.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.hdjava.school.server.bean.Permission;
import work.hdjava.school.server.mapper.PermissionMapper;
import work.hdjava.school.server.service.PermissionService;

import java.util.List;

/**
 * @author Fox
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public List<Permission> selectByUserId(Long userId) {

        return permissionMapper.selectByUserId(userId);
    }
}
