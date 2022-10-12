package work.hdjava.school.server.service;

import java.util.List;
import work.hdjava.school.server.domain.UniversityRank;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * Author suncl
 * Date: 2022/10/4 11:11
 * Description:  该文件的描述
 */
public interface UniversityRankService extends IService<UniversityRank> {

    int updateBatch(List<UniversityRank> list);

    int updateBatchSelective(List<UniversityRank> list);

    int batchInsert(List<UniversityRank> list);

    int insertOrUpdate(UniversityRank record);

    int insertOrUpdateSelective(UniversityRank record);

}

