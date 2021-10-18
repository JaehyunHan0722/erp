<%@page import="multi.erp.board.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript">
	//자바스크립트
	category = "${category}";
	//alert(category);
	$(document).ready(function(){
		$("#category").val(category).attr("selected", "selected")
		$("#category").change(function(){
			location.href="/erp/board/list.do?category="+encodeURI($(this).val())
		});
	});
</script>
</head>
<body>
   <% ArrayList<BoardVO> boardlist = (ArrayList<BoardVO>) request.getAttribute("boardlist");
		int size = boardlist.size();
	%>
	<h1>게시판</h1>
	<div style="padding-top: 30px">
		<div class="col-md-3" style="padding-bottom: 10px">
		    구분:
			<form >
				<select name="category"  id="category">
					<option value="all">전체게시물</option>
					<option value="경조사">경조사</option>
					<option value="사내소식">사내소식</option>
					<option value="게시판">게시판</option>
				</select>
			</form>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>성명</th>
					<th>작성 날짜</th>
				</tr>
			</thead>
			<tbody>
				<% for(int i=0; i<size; i++){
					BoardVO board = boardlist.get(i);	
				%>
					<tr>
						<td><%= board.getBoard_no() %></td>
						<td><a href="/erp/board/read.do?board_no=<%= board.getBoard_no() %>&state=READ"><%= board.getTitle()%></a></td>
						<td><%= board.getId() %></td>
						<td><%= board.getWrite_date() %></td>
					</tr>
				<%} %>
			</tbody>
		</table>
	</div>
	<form action="/erp/board/search.do">
		<select name="tag">
			<option value="id">작성자</option>
			<option value="title">제목</option>
			<option value="content">본문</option>
			<option value="write_date">작성일</option>
		</select> <input type="text" name="search" /> <input type="submit" value="검색">
		<ul class="nav navbar-nav navbar-right">
			<li><a href="/erp/board/insertPage.do" style="text-align: right;">글쓰기</a></li>
		</ul>
	</form>
</body>
</html>