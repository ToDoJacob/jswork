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
    window.onload = function(){
		let listLi = document.getElementById('listLi');
		listLi.setAttribute('class', 'active');
	}
</script>
<body>
<jsp:include page="../home/header.jsp"/>
	<div align="center">
		<div>
			<h1>회원 목록</h1>
		</div>
		<div>
			<table border="1">
				<tr>
					<th width="150">아이디</th>
					<th width="150">비밀번호</th>
					<th width="150">이름</th>
					<th width="200">주소</th>
					<th width="200">전화번호</th>
					<th width="150">권한</th>
				</tr>
				<c:forEach items="${members }" var="member">
					<tr>
						<td align="center">${member.id }</td>
						<td align="center">${member.password }</td>
						<td align="center">${member.name }</td>
						<td align="center">${member.address }</td>
						<td align="center">${member.tel }</td>
						<td align="center">${member.author }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>