package work.hdjava.school.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import work.hdjava.school.domain.UniversityRank;
import work.hdjava.school.mapper.UniversityRankMapper;
import work.hdjava.school.service.UniversityRankService;

/**
 * Author suncl
 * Date: 2022/10/4 11:11
 * Description:  该文件的描述
 */
@Service
public class UniversityRankServiceImpl extends ServiceImpl<UniversityRankMapper, UniversityRank> implements UniversityRankService {

    @Override
    public int insertSelective(UniversityRank record) {
        return baseMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(UniversityRank record) {
        return baseMapper.updateByPrimaryKeySelective(record);
    }

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

