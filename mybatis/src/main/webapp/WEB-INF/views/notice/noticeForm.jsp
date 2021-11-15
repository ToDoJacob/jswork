<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항작성</title>
</head>
<script>
	window.onload = function() {
		let noticeLi = document.getElementById('noticeLi');
		noticeLi.setAttribute('class', 'active');
		setInterval(getTime,1000);
	}
	function getTime() {
	let timeNow = new Date();
	let month = timeNow.getMonth()+1;
	if(month<10)month=0+month;
	let day = timeNow.getDate();
	if(day<10)day=0+day;
	let hours = timeNow.getHours();
	if(hours<10)hours=0+hours;
	let minutes = timeNow.getMinutes();
	if(minutes<10)minutes=0+minutes;
	let seconds = timeNow.getSeconds();
	if(seconds<10)seconds=0+seconds;
	let timeString = month+"월 "+day+"일 <br>"+hours+" : "+minutes+" : "+seconds;
	timeTd.innerHTML = timeString;
	}
</script>
<body>
	<jsp:include page="../home/header.jsp" />
	<div id="area1" align="center">
		<div>
			<h1>새 공지사항</h1>
		</div>
		<form id="frm" action="noticeInsert.do" method="post">
			<div id="innerArea1">
				<table border="1">
					<tr>
						<th width="120">아이디</th>
						<td width="150"><input type="text" id="id" name="id"
							required="required" readonly value="${id }"></td>
						<th width="120">작성자</th>
						<td width="150"><input type="text" id="name" name="name"
							required="required" readonly value="${name }"></td>
						<th width="120">작성일</th>
						<td width="150" id="timeTd" height="36">--월 --일<br>-- : -- : --</td>
					</tr>
					<tr>
						<th>제목</th>
						<td colspan="5"><input type="text" id="title" name="title"
							style="width: 99%;" required="required"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="5"><textarea id="contents" name="contents"
								rows="18" style="width: 99%;"></textarea></td>
					</tr>
				</table>

			</div>
			<br>
			<div id="foot">
				<input style="zoom: 1.3" type="button" value="목록"
					onclick="location.href='noticeList.do'">
					<input style="zoom: 1.3" type="submit" value="저장">
					<input style="zoom: 1.3" type="reset" value="취소">
			</div>
		</form>
	</div>
</body>
<script>
let timeTd = document.getElementById('timeTd');
getTime();
</script>
</html>