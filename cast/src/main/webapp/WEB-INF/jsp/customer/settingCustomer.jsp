<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<a href="/updatePw?customerId=${loginCustomerId}">��й�ȣ ����</a>
	
	<form method="post" action="/deleteCustomer">
	<div>Id</div>
	<input type="text" name="customerId" value="${loginCustomerId}" readonly="readonly">
	<div>Pw</div>
	<input type="password" name="customerPw">
	<button type="submit">ȸ��Ż��</button>
	</form>
</body>
</html>