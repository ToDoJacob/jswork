<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
	window.onload = function() {
		let joinLi = document.getElementById('joinLi');
		joinLi.setAttribute('class', 'active');
	}
	function CallValidation() {
		var pw = frm.password.value;
		var pw1 = frm.password1.value;
//		if (frm.name.value == "") {
//			alert('이름');
//			frm.name.focus();
//			return;
//		}
		if (pw == pw1) {
			frm.submit();
		} else {
			alert("비밀번호 확인하세용");
			frm.password.value = '';
			frm.password1.value = '';
			frm.password.focus();
			return false;
		}
	}
</script>
<body>
	<jsp:include page="../home/header.jsp" />
	<div id="area1" align="center">
		<div>
			<h1>회원가입</h1>
		</div>
		<div>
			<form id="frm" action="memberJoin.do" method="post">
				<div id="innerArea1">
					<table border="1">
						<tr>
							<th width="100">아이디</th>
							<td width="200"><input size="35" type="text" id="id"
								name="id" required="required"></td>
						</tr>
						<tr>
							<th width="100">비밀번호</th>
							<td width="200"><input size="35" type="password"
								id="password" name="password" required="required"></td>
						</tr>
						<tr>
							<th width="150">비밀번호확인</th>
							<td width="200"><input size="35" type="password"
								id="password1" name="password1" required="required"></td>
						</tr>
						<tr>
							<th width="100">이름</th>
							<td width="200"><input size="35" type="text" id="name"
								name="name" required="required"></td>
						</tr>
						<tr>
							<th width="100">주소</th>
							<td width="200"><input size="35" type="text" id="address"
								name="address"></td>
						</tr>
						<tr>
							<th width="100">전화번호</th>
							<td width="200"><input size="35" type="text" id="tel"
								name="tel"></td>
						</tr>
					</table>
				</div>
				<br>
				<div id="foot">
					<input type="hidden" id="author" name="author" value="user">
					<input type="reset" value="초기화" style="zoom: 1.3">
					<input type="button" value="회원가입" onclick="CallValidation()" style="zoom: 1.3">
				</div>
			</form>
		</div>
	</div>
</body>
</html>