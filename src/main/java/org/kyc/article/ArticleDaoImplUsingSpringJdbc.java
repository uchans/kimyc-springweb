package org.kyc.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository("articleDao")
public class ArticleDaoImplUsingSpringJdbc implements ArticleDao {
	static final String INSERT = "INSERT article(title, content, userId, name) VALUES(?,?,?,?)";

	static final String SELECT_ALL = "SELECT articleId, userId, title, content, name,  left(cdate,19) cdate FROM article ORDER BY articleId desc LIMIT ?,?";

	static final String COUNT_ALL = "SELECT count(articleId) count FROM article";

	static final String GET_ARTICLE = "SELECT articleId,userId, title, content, name, udate FROM article WHERE articleId=?";
	
	@Autowired
	JdbcTemplate jdbcTemplate;
 
	final RowMapper<Article> ArticleRowMapper = new BeanPropertyRowMapper<>(
										Article.class);


	@Override
	public int insert(Article article) {
		return jdbcTemplate.update(INSERT, article.getTitle(), article.getContent(), "2015041035", "김유찬");
}

	@Override
	public Article getArticle(int articleId) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(GET_ARTICLE,
				ArticleRowMapper, articleId);
	}

	@Override
	public List<Article> selectAll(int offset, int count) {
		return jdbcTemplate.query(SELECT_ALL, ArticleRowMapper, offset, count);
	}

	@Override
	public int countAll() {
		return jdbcTemplate.queryForObject(COUNT_ALL, Integer.class);
	}

	
}