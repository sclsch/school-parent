package work.hdjava.school.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import work.hdjava.school.server.domain.UniversityRank;

/**
 * Author suncl
 * Date: 2022/10/4 11:19
 * Description:  该文件的描述
 */
@Mapper
public interface UniversityRankMapper extends BaseMapper<UniversityRank> {

    int updateBatch(List<UniversityRank> list);

    int updateBatchSelective(List<UniversityRank> list);

    int batchInsert(@Param("list") List<UniversityRank> list);

    int insertOrUpdate(UniversityRank record);

    int insertOrUpdateSelective(UniversityRank record);
}