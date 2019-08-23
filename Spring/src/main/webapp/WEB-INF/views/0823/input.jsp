<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%-- 0823/input.jsp --%>
<body>
  <h3>입력폼</h3>
  <hr>
  <!-- <form action="/Spring/0823/result" method="post"> -->
  <form action="result" method="post">
     이름: <input type="text" name="name">
     <input type="submit" value="전송">
  </form>
  <hr>
  <h3>GET,POST테스트</h3>
  <form action="good" method="post">
     <input type="submit" value="전송">
  </form>
</body>
</html>





