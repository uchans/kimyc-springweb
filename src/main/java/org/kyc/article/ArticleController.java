package org.kyc.article;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kyc.chap11.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import javax.servlet.http.HttpSession;



@Controller
public class ArticleController {

	@Autowired
	ArticleDao articleDao;

	Logger logger = LogManager.getLogger();

	
	
	@GetMapping("/article/step1")
	public String articleAddForm(HttpSession session) {
		return "article/step1";
}

	@PostMapping("/article/step2")
	public String articleAdd(Article article,
			@SessionAttribute("MEMBER") Member member) {
			article.setUserId(member.getMemberId());
			article.setName(member.getName());
			articleDao.insert(article);
			return "redirect:/app/list";
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

		
		final int COUNT = 100;
		
		int offset = (page - 1) * COUNT;

		List<Article> articleList = articleDao.selectAll(offset, COUNT);

		int totalCount = articleDao.countAll();

		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", articleList);
		return "list";
	}
	@GetMapping("/article/delete")
	public String deleteArticle(
			@RequestParam("articleId") String articleId,
			@SessionAttribute("MEMBER") Member member) {
			Article article = articleDao.getArticle(articleId);
			
			if(!member.getMemberId().equals(article.getUserId()))
				return "redirect:/app/article/step3?articleId="+articleId;
			articleDao.deleteArticle(article);
			return "article/delete";
	}
	@PostMapping("/article/revise")
	public String up(Article article,
	        @RequestParam("articleId") String articleId,
	        @SessionAttribute("MEMBER") Member member) {
	    article.setArticleId(articleId);
	    articleDao.updateArticle(article);
	    return "article/revise";
	   }
	@GetMapping("/article/reviseTool")
	public String update(
		 @RequestParam("articleId") String articleId,
	    @SessionAttribute("MEMBER") Member member,Model model) {
	    Article article = articleDao.getArticle(articleId);
	    
	    if(!member.getMemberId().equals(article.getUserId()))
	        return "redirect:/app/article/step3?articleId="+articleId;
	    model.addAttribute("article",article);
	    return "article/reviseTool";
	}
}