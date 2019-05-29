package org.kyc.article;

import java.util.List;

public interface ArticleDao {

	
	int insert(Article article);
	
	List<Article> selectAll(int offset, int count);
	
	void updateArticle(Article article);
	
	Article getArticle(int articleId);
	
	void deleteArticle(Article article);
	
	int countAll();

	Article getArticle(String articleId);
}