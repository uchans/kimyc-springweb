<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>삭제</title>
</head>
<body>
	<p>${sessionScope.MEMBER.name }님의 글이 삭제되었습니다.</p>
	<p>
		<a href="./app/list">게시판으로 가기</a>
	</p>
</body>
<body>