<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>업로드할 파일을 선택하세요.</h1>
<form action="fileUpload" enctype="multipart/form-data" method="post">
	작성자 : <input type="text" name="author"><br/>
	업로드 파일 : <input type="file" name="filename"><br/>
	<input type="submit" value="업로드" />	
</form>
</body>
</html>