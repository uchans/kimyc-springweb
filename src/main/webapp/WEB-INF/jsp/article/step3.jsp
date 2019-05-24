<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>

<html>
<head>
<base href="${pageContext.request.contextPath }/" />

<title>글 조회</title>

</head>
<body>
	<table>
        <tr>
				<td>글번호 : </td><td>${step3.articleId}</td></tr>
        		<td>학번 :</td><td>${step3.userId}</td></tr>
           	<td>이름 :</td><td>${step3.name}</td></tr>
          		<td>글제목 : </td><td>${step3.title}</td></tr>
          		<td>등록시간 : </td><td>${step3.udate}</td>
        </tr>
        <tr>
            <td>글내용 : </td><td>${step3.contentHtml}</td>
        </tr>
	</table>
		<a href="./app/main">[메인]</a>
		<a href="./app/list">[목록]</a>
</body>
</html>