<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>

<html>
<head>
<base href="${pageContext.request.contextPath }/" />

<title>편지 내용</title>
<script type="text/javascript">
	function confirmDelete() {
		if (confirm("삭제하시겠습니까?"))
			return true;
		else
			return false;
	}
</script>
</head>
<body>
<p>
<a href="./app/main">[홈]</a>
<a href="./app/letter/delete?letterId=${letter.letterId }"
onclick="return confirmDelete();">[글삭제]</a>
</p>
	
    <p>
		<span style="font-weight: bold;">보낸 사람: ${letter.senderName }</span> | <span style="font-weight: bold;">번 호: ${letter.senderId }</span>|
	</p>
	<p>
	 	<span style="font-weight: bold;">제 목:${letter.title }</span>
	</p>
	<p>
		<span style="font-weight: bold;">받는 사람: ${letter.receiverName }</span>
	</p>
	<p>
		<span style="font-weight: bold;">날 짜: ${letter.cdate }</span>
	</p>
	<hr />
	<p>${letter.contentHtml }</p>
	<hr />
</body>
</html>