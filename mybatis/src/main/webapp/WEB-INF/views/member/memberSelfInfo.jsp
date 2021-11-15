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
    	let selfInfoLi = document.getElementById('selfInfoLi');
    	selfInfoLi.setAttribute('class', 'active');
	}
</script>
<body>
<jsp:include page="../home/header.jsp"/>
	<div id="area1" align="center">
	<div><h1>내 정보</h1></div>
		<div id="innerArea1">
			<table border="1" style="text-align:center;">
				<tr>
					<th width="110px" height="30px">아이디</th>
					<td width="300px">${memberInfo.id }</td>
				</tr>
				<tr>
					<th width="110px" height="30px">비밀번호</th>
					<td>${memberInfo.password }</td>
				</tr>
				<tr>
					<th width="110px" height="30px">이름</th>
					<td>${memberInfo.name }</td>
				</tr>
				<tr>
					<th width="110px" height="30px">주소</th>
					<td>${memberInfo.address }</td>
				</tr>
				<tr>
					<th width="110px" height="30px">전화번호</th>
					<td>${memberInfo.tel }</td>
				</tr>
				<tr>
					<th width="110px" height="30px">권한</th>
					<td>${memberInfo.author }</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>