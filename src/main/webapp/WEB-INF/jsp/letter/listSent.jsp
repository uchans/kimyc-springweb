<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>

<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>받은 편지함</title>
<style type="text/css">
table {
	margin-top: 10px;
	border-collapse: collapse;
	border-top: 1px solid gray;
	border-bottom: 1px solid gray;
	width: 100%;
}
th, td {
	padding: 5px 0;
}
th {
	border-bottom: 1px solid gray;
}
</style>
</head>
<body>
<%@include file ="/WEB-INF/jsp/header.jsp" %>
	<p>전체 ${count }건</p>
	<form action="./app/letter/listSent">
		<input type="number" name="page" value="${param.page }" placeholder="페이지"
			min="1" max="${count / 20 + 1 }" step="1" style="width: 50px;">
		<button type="submit">조회</button>
	</form>

	<table>
		<thead>
			<tr>
				<th>편지번호</th>
				<th>받은 사람</th>
				<th>받은 사람 번호</th>
				<th>제목</th>
				<th>등록일시</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="letter" items="${letters}">
				<tr>
					<th>${letter.letterId}</th>
					<th>${letter.receiverId}</th>
					<th>${letter.receiverName}</th>
					<th><a href="./app/letter/view?letterId=${letter.letterId}">${letter.title}</a></th>
					<th>${letter.cdate}</th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</head>
</html>