<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
	window.onload = function() {
		let homeLi = document.getElementById('homeLi');
		homeLi.setAttribute('class', 'active');
	}
</script>

<body>
	<jsp:include page="../home/header.jsp" />
	<div id="area1" align="center">
		<h1>여기가 홈페이지</h1>
		<div id="innerArea1">
		<h6>ㅇㅅㅇ</h6>
		</div>
	</div>
</body>

</html>