package work.hdjava.school.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import work.hdjava.school.domain.UniversityRank;
import work.hdjava.school.service.UniversityRankService;

@RestController
public class UniversityRankController {

	@Autowired
	private UniversityRankService universityRankService;
	
	@GetMapping("/university/list")
	public ResponseEntity univercityList(UniversityRank universityRank) {
		Page<UniversityRank> hisPage = new Page<>(universityRank.getPageIndex(), universityRank.getPageSize());
		QueryWrapper<UniversityRank> queryWrapper = new QueryWrapper<>();
		queryWrapper.orderBy(true,true,"`rank`");
		Page<UniversityRank> page = universityRankService.page(hisPage, queryWrapper);
		return ResponseEntity.ok(page);
	}
}
