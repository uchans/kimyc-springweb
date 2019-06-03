<!doctype html>

<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>글 쓰기</title>
</head>
<body>
<%@include file ="/WEB-INF/jsp/header.jsp" %>
	<form action="./app/letter/add" method="post">
	 <p>받는사람 :
     <input name="receiverName" value="${param.receiverName}" type="text" readonly="readonly"/></p>
	 <p>받는사람 번호 :
     <input name="receiverId" value="${param.receiverId}" type="text" readonly="readonly"/></p>
       <p>제목 :</p>
		<p>
			<input type="text" name="title" maxlength="100" style="width: 100%;" required>
		</p>
		<p>내용 :</p>
		<p>
			<textarea name="content" style="width: 100%; height: 200px;" required></textarea>
		</p>
		<p>
		<button type="submit">등록</button>
		</p>
		</form>
</body>
</html>