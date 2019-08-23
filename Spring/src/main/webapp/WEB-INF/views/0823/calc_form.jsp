<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산기폼</title>
</head>
<%-- 0823/calc_form.jsp --%>
<body>
  <h3>Spring계산기</h3>
  <hr>
  <form method="post">
     <input type="text" size="4" name="su1">
     <select name="oper">
        <option>+</option>
        <option>-</option>
        <option>*</option>
        <option>/</option>
     </select>
     <input type="text" size="4" name="su2">
     <button>계산</button>
  </form>
  <hr>
  ${result }
</body>
</html>



