package org.kyc.article;

import java.util.List;

public interface ArticleDao {

	
	int insert(Article article);
	
	List<Article> selectAll(int offset, int count);
	
	
	
	Article getArticle(int articleId);
	
	int countAll();
	
}