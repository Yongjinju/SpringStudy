<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이름입력</title>
</head>
<%--  0822/name_input.jsp --%>
<body>
   <h3>이름폼</h3>
   <!-- <form action="/Spring/you/result" method="post"> -->
   <form action="result2" method="post">
          이름: <input type="text" name="username">
           <button type="submit">전송</button>
   </form>
</body>
</html>

