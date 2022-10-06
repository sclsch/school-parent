package work.hdjava.school.server.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import work.hdjava.school.server.domain.UniversityRank;
import work.hdjava.school.server.dto.R;
import work.hdjava.school.server.service.UniversityRankService;

@RestController
public class UniversityRankController {

	@Autowired
	private UniversityRankService universityRankService;
	
	@GetMapping("/university/list")
	public R univercityList(UniversityRank universityRank) {
		Page<UniversityRank> hisPage = new Page<>(universityRank.getPageIndex(), universityRank.getPageSize());
		QueryWrapper<UniversityRank> queryWrapper = new QueryWrapper<>();
		queryWrapper.orderBy(true,true,"`rank`");
		Page<UniversityRank> page = universityRankService.page(hisPage, queryWrapper);
		return R.ok(page);
	}
}
