<!doctype html>

<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>글 등록</title>
</head>
<body>
	<h2>글 정보 입력</h2>
	<form action="./app/article/step2" method="post">
			<p>
			제목:<br> <input type="text" name="title" value="${param.title }">
		</p>
		<p>
			내용:<textarea name="content" style="width: 100%; height: 200px;" required></textarea>
		</p>

		<button type="submit">글 등록</button>
	</form>
</body>
</html>