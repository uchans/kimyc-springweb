package org.kyc.article;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class ArticleController {

	@Autowired
	ArticleDao articleDao;

	static final Logger logger = LogManager.getLogger();

	
	
	@RequestMapping("/article/step1")
	public String handleStep1() {
		return "article/step1";
	}
	

	@PostMapping("/article/step2")
	public String handleStep2(Article article) {
			articleDao.insert(article);
			logger.debug("글정보를 저장했습니다. {}", article);
			return "article/step2";
} 
	@RequestMapping(value="/article/step3", method=RequestMethod.GET)
	public String step3(@RequestParam int articleId,Model model) {
		Article step3 = articleDao.getArticle(articleId);
		model.addAttribute("step3",step3);
				return "/article/step3";
		}

	@GetMapping("/list")
	public String articles(
			@RequestParam(value = "page", defaultValue = "1") int page,
			Model model) {

		// 페이지 당 가져오는 행의 수
		final int COUNT = 100;
		// 시작점
		int offset = (page - 1) * COUNT;

		List<Article> articleList = articleDao.selectAll(offset, COUNT);

		int totalCount = articleDao.countAll();

		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", articleList);
		return "list";
	}
}