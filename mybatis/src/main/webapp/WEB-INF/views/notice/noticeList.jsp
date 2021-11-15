<%@ 
page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<script>
    window.onload = function(){
    	let noticeLi = document.getElementById('noticeLi');
    	noticeLi.setAttribute('class', 'active');
	}
	function CallNotice(n){
		frm.nid.value = n;
		frm.action = "noticeSelect.do";
		frm.submit();
	}
	
//	function tdClick(e,n){
//		//e.cancelBubble=true;
//		e.stopPropagation();
//		let thisCheckBox = document.getElementById('noticeNum'+n);
//		//thisCheckBox.click();
//		thisCheckBox.checked = !thisCheckBox.checked 
//	}
	
	function checkBoxTdClicked(e,t){
		e.stopPropagation();
		t.childNodes[1].checked = !t.childNodes[1].checked;
	}
	function checkBoxClicked(t){
		t.checked = !t.checked;
	}
	
	function deleteSelected(){
		console.log('d');
		let checkedArray = new Array();
		let checkBoxes = document.getElementsByClassName('noticeNum');
		for(let i = 0; i < checkBoxes.length; i++){
			if(checkBoxes[i].checked){
				checkedArray.push(checkBoxes[i].id.substring(9));
				console.log("'"+checkBoxes[i].id.substring(9)+"'");
			}
		}
		
		frm.nid.value = checkedArray;
		frm.action = "noticeDeleteSelected.do";
		frm.submit();
	}
	
	function mouseOver(t){
		t.parentNode.childNodes[1].setAttribute('style','background-color:rgb(240, 240, 240)');
		t.parentNode.childNodes[3].setAttribute('style','background-color:rgb(240, 240, 240)');
		t.parentNode.childNodes[5].setAttribute('style','background-color:rgb(240, 240, 240)');
		t.parentNode.childNodes[7].setAttribute('style','background-color:rgb(240, 240, 240)');
		t.parentNode.childNodes[9].setAttribute('style','background-color:rgb(240, 240, 240)');
		t.parentNode.childNodes[11].setAttribute('style','background-color:rgb(240, 240, 240)');
		t.setAttribute('style','background-color:rgb(210, 210, 210)');
	}
	
	function mouseOut(t){
		t.parentNode.childNodes[1].setAttribute('style','background-color:white');
		t.parentNode.childNodes[3].setAttribute('style','background-color:white');
		t.parentNode.childNodes[5].setAttribute('style','background-color:white');
		t.parentNode.childNodes[7].setAttribute('style','background-color:white');
		t.parentNode.childNodes[9].setAttribute('style','background-color:white');
		t.parentNode.childNodes[11].setAttribute('style','background-color:white');
		t.setAttribute('style','background-color:white');
	}
</script>
</head>
<body>
	<jsp:include page="../home/header.jsp" />
	<div id="area1" align="center">
		<div>
			<h1>공지사항</h1>
		</div>
		<div id="innerArea0">
			<form id="noticeListForm" name="noticeListForm" method="get">
				<table border="1">
					<thead>
						<tr>
							<th width="50">번호</th>
							<th width="360">제목</th>
							<th width="120">작성자</th>
							<th width="120">작성일</th>
							<th width="60">조회수</th>
							<th width="32"></th>
							<th width="5"></th>
						</tr>
					</thead>
					<c:forEach items="${notices }" var="notice">
						<tbody>
							<tr style="cursor: pointer;" onclick="CallNotice(${notice.nid})">
								<td onmouseover="mouseOver(this)" onmouseout="mouseOut(this)" id="nidTd" align="center">${notice.nid }</td>
								<td onmouseover="mouseOver(this)" onmouseout="mouseOut(this)" align="center">${notice.title }</td>
								<td onmouseover="mouseOver(this)" onmouseout="mouseOut(this)" align="center">${notice.name }</td>
								<td onmouseover="mouseOver(this)" onmouseout="mouseOut(this)" align="center">${notice.writeDate }</td>
								<td onmouseover="mouseOver(this)" onmouseout="mouseOut(this)" align="center">${notice.hit }</td>
								<td onmouseover="mouseOver(this)" onmouseout="mouseOut(this)" id="checkBoxTd" align="center"
								onclick="checkBoxTdClicked(event,this)">
								<c:if test="${(sessionScope.id eq notice.id) or (sessionScope.author eq 'admin') }">
									<input class="noticeNum" id="noticeNum${notice.nid}"
									name="noticeNum${notice.nid}" style="zoom: 1.3;"
									type="checkbox" onclick="checkBoxClicked(this)">
								</c:if>
								</td>
							</tr>
						</tbody>
					</c:forEach>
				</table>
			</form>
		</div>
		<br>
		<div id="foot">
		<div>
		<form id="searchForm" name="searchForm" method="post" action="noticeSearch.do">
			<select style="zoom: 1.6;" name="method">
				<option>제목</option>
				<option>글번호</option>
			</select>
			<input type="text" style="zoom: 1.3;" name="keyword">
			<input type="submit" value="검색" style="zoom: 1.4;">
			</form>
			</div>
			<button type="button" onclick="location.href='noticeForm.do'">글쓰기</button>
			<button type="button" onclick="deleteSelected()">삭제</button>
		</div>
		<div>
			<form id="frm" action="" method="post">
				<input type="hidden" id="nid" name="nid">
			</form>
		</div>
	</div>
</body>
</html>