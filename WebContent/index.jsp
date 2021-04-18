<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My JavaToEmail App</title>
<link rel="stylesheet" type="text/css" href="css/app.css" >
</head>
<body>
<div class="app">
<div class="msg-div">
<c:if test="${not empty param.msg}">
			<c:if test="${param.msg == 'success' }">
			<div class="return-msg success">Email Successfully sent.</div>
		    </c:if>
			<c:if test="${param.msg == 'error'}">
			<div class="return-msg error">Email was not sent, please try again.</div>
		    </c:if>
	    </c:if>
</div>
<form action="<%= request.getContextPath() %>/sendMessage" method="post">
<h1>Send Email Message</h1>
		<div class="form-input">
			<input type="text" name="fname" value="<c:out value='${not empty fname ? fname : "" }' />" placeholder="Enter your name" />
		</div>
		<div class="form-input">
			<input type="email" name="email" value="<c:out value='${not empty email ? email : "" }' />" placeholder="Enter your email" required="required"  />
		</div>
		<div class="form-input">
			<input type="text" name="subject" value="<c:out value='${not empty subject ? subject : "" }' />" placeholder="Enter message subject" required="required"  />
		</div>

		<div class="form-input">
			<textarea name="msg" placeholder="Enter Message." required="required"><c:out value='${not empty msg ? msg : "" }'  /></textarea>
		</div>
		<div class="form-btn">
			<input type="submit" name="sbmtBtn" value="Send" />
		</div>
</form>
</div>
</body>
</html>