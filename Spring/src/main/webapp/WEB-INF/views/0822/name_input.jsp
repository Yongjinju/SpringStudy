<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- 0822/name_input.jsp -->
<body>
	<h3>이름폼</h3>
	<form action="result2" method="post">
	<!-- 원래 action을 Spring/you/result 로 가야 하지만, 경로 일치함으로 result만 적어도 된다. -->
	<!-- method get을 하면 action이 안됨, 브라우저가 서버 준비하는 html 가져오는것이고, action은 
	데이터를 주는거기 때문에 null값으로 전달 안됨, post여야 전달되는 것 -->
		이름 : <input type="text" name = "username">
		<button type="submit">전송</button>
	</form>
</body>
</html>