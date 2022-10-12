package work.hdjava.school.server.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import work.hdjava.school.server.domain.UniversityRank;
import work.hdjava.school.server.mapper.UniversityRankMapper;
import work.hdjava.school.server.service.UniversityRankService;

/**
 * Author suncl
 * Date: 2022/10/4 11:11
 * Description:  该文件的描述
 */
@Service
public class UniversityRankServiceImpl extends ServiceImpl<UniversityRankMapper, UniversityRank> implements UniversityRankService {



    @Override
    public int updateBatch(List<UniversityRank> list) {
        return baseMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<UniversityRank> list) {
        return baseMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<UniversityRank> list) {
        return baseMapper.batchInsert(list);
    }

    @Override
    public int insertOrUpdate(UniversityRank record) {
        return baseMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(UniversityRank record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}

