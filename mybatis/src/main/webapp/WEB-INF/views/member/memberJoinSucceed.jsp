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
		let homeLi = document.getElementById('homeLi');
		console.log(homeLi);
		homeLi.setAttribute('class', 'active');
		console.log('hi');
	}
</script>
<body>
	<jsp:include page="../home/header.jsp" />
	<div align="center">
		<div>
			<h1>${message }</h1>
			<button type="button" onclick="location.href='memberLoginForm.do'">로그인</button>
		</div>
	</div>
</body>
</html>