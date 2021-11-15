<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
    window.onload = function(){
    	let loginLi = document.getElementById('loginLi');
		loginLi.setAttribute('class', 'active');
	}
</script>
<body>
<jsp:include page="../home/header.jsp" />
	<div id="innerArea1" align="center">
		<div>
			<h1>${message }</h1>
		</div>
	</div>
</body>
</html>