<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form method="post" action="/updatePw">
	<!--  ȸ�� ���̵� ��������... -->
	<input type="hidden" name="customerId" value= "${loginCustomerId}">
	<div>���� ��й�ȣ</div>
	<input type="password" name="customerPw">
	<div>�� ��й�ȣ</div>
	<input type="password" name="newCustomerPw">
	<button type="submit">����</button>
	</form>
</body>
</html>