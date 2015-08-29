<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Request new reminder</title>
</head>
<body>

<form action="add" method = "post">

Subject : <input type="text" name="subject"/> <br />
Description: <textarea rows="3" cols="20" name = "description"></textarea> <br />
Who do you want to send to <input type="text"  name="member" /> <br />
reminder start day : <input type="text" name = "startDay"/> <br />
reminder end day : <input type="text" name = "endDay"/> <br />
Repeat ? <input type="checkbox" name = "repeat"  checked="checked"/>
<br />

Daily : <input type="checkbox"  name="daily" />
Weekly : <input type="checkbox"  name="weekly" />
Monthly : <input type="checkbox"  name="monthlyByDate" />

Who do you want to send to
<input type="submit">
</form>
</body>
</html>