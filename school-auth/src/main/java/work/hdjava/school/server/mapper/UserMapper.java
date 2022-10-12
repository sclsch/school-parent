package work.hdjava.school.server.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import work.hdjava.school.server.bean.User;

/**
 * @author Fox
 */
@Mapper
public interface UserMapper {

    @Select("select * from tb_user where username=#{username}")
    User getByUsername(String username);
}
