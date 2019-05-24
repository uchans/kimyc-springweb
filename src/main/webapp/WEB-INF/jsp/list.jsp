<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<!-- 
게시글  목록
-->
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>게시글  목록</title>
</head>
<body>
	<p>전체 ${totalCount }건</p>
	
	<form action="./app/list">
		<input type="number" name="page" value="${param.page }" placeholder="페이지"
			min="1" max="${totalCount / 100 + 1 }" step="1" style="width: 50px;">
		<button type="submit">조회</button>
		</form>
	<form action="./app/article/step1">
		<button type="submit">글 등록</button>
		</form>
	<table>
		<thead>
			<tr>
				<td>글번호</td>
				<td>학번</td>
				<td>제목</td>
				<td>이름</td>
				<td>등록일시</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="article" items="${list}">
				<tr>
					<td>${article.articleId }</td>
					<td>${article.userId }</td>
					<td><a href="./app/article/step3?articleId=${article.articleId}">${article.title }</a></td>
					<td>${article.name }</td>
					<td>${article.cdate }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</head>
</html>