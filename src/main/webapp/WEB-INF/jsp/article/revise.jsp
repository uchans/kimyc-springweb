
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>게시판</title>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/header.jsp"%>
	<h2>글 수정</h2>
	<form action="./app/article/update" method="post">
		<p>제목 :</p>
		<p>
			<input type="text" name="title" value="${article.title }" maxlength="100"
				style="width: 100%;" required>
		</p>
		<p>내용 :</p>
		<p>
			<textarea name="content" style="width: 100%; height: 200px;" required>${article.content }</textarea>
		</p>
		<p>
			<button type="submit">등록</button>
			<button type="button" onclick="history.back();">취소</button>
		</p>
		<input type="hidden" name="articleId" value="${article.articleId }" />
	</form>
</body>
</html>