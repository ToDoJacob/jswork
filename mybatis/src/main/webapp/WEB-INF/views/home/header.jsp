<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/menu.css">
</head>
<body>
	<div align="center">
		<div>
			<!-- 메뉴부분 -->
			<ul id="headerList">
				<li id="homeLi" class="homeLi" style="background:'yellow';"><a href="home.do">홈</a></li>
				<c:if test="${empty id }">
					<li id="joinLi" class="joinLi"><a href="memberJoinForm.do">회원가입</a></li>
					<li id="loginLi" class="loginLi"><a href="memberLoginForm.do">로그인</a></li>
				</c:if>
				<c:if test="${not empty id }">
					
					<li id="noticeLi" class="noticeLi"><a href="noticeList.do">공지사항</a></li>
<!-- 					<li><a href="#">About</a></li>
					<li><a href="#">Product</a></li> -->
					<li id="selfInfoLi" class="selfInfoLi"><a href="memberSelfInfo.do">내 정보</a></li>
					<c:if test="${author == 'admin' }">
						<li id="listLi" class="listLi"><a href="memberSelectList.do">회원목록</a></li>
					</c:if>
					<c:if test="${author != 'admin' }">
						<li><a href="javascript:void(0)">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
					</c:if>
					<li id="logoutLi" class="logoutLi"><a href="memberLogout.do">로그아웃</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</body>
</html>