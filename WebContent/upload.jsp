<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form name="Form1" action="user/springUpload.do" method="post"  enctype="multipart/form-data">
		<h1>使用spring mvc提供的类的方法上传文件</h1>
		<input type="file" name="file">
		<input type="submit" value="upload"/>
	</form>
	
	<form name="Form2" action="user/fileUpload2.do" method="post"  enctype="multipart/form-data">
		<h1>采用multipart提供的file.transfer方法上传文件</h1>
		<input type="file" name="file">
		<input type="submit" value="upload"/>
	</form>
	
	<form name="Form3" action="user/fileUploads.do" method="post"  enctype="multipart/form-data">
		<h1>采用multipart提供的file.transfer方法上传文件</h1>
		<input type="file" name="file">
		<input type="file" name="file">
		<input type="file" name="file">
		<input type="submit" value="upload"/>
	</form>
	
</body>
</html>