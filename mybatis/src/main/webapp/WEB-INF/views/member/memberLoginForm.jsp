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
//		loginLi.className = 'active '+ loginLi.className;
		loginLi.className = 'active';
	}
</script>
<body>
<jsp:include page="../home/header.jsp"/>
	<div id="area1" align="center">
		<div>
			<h1>로그인</h1>
		</div>
		<form id="frm" name="frm" action="memberLogin.do" method="post">
			<div id="innerArea1">
				<div>
					<table border="1">
						<tr>
							<th width="150">아이디</th>
							<td>
							<input size="35" type="text" id="id" name="id" required="required" placeholder="아이디">
							</td>
						</tr>
						<tr>
							<th width="150">비밀번호</th>
							<td>
							<input size="35" type="password" id="password" name="password" required="required" placeholder="비밀번호">
							</td>
						</tr>
					</table>
				</div>
			</div><br>
			<div id="foot">
				<input type="reset" value="초기화" style="zoom: 1.3">
				<input type="submit" value="로그인" style="zoom: 1.3">
			</div>
		</form>
	</div>
</body>
</html>