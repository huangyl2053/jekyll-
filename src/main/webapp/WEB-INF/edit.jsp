<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>main view</title>
<link rel="stylesheet" type="text/css" href="css/main.css"/>
<link rel="stylesheet" type="text/css" href="css/edit.css"/>
</head>
<body>
	<br />
	<br />
	<br />
	<form method="post" action="save" id="center">
		标题：<input type="text" name="title" id="title" />
		 <br />
		  内容：<textarea name="content" id="content"></textarea>
		<br /> <input type="submit">
	</form>
</body>
</html>