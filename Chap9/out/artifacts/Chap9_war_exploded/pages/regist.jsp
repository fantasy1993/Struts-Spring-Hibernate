<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html>
<head>
	<title><bean:message key="lable.text.userlist"/></title>
	<html:javascript formName="/regist"/>
	<script type="text/javascript" src='<c:url value="/scripts/common/jquery.js" />' type="text/javascript"></script>
	<script type="text/javascript">
		function checkUserName() {
			var userNameInput = document.getElementById("userName");
			var userName = userNameInput.value;
			if(jQuery.trim(userName) == "") {
				document.getElementById("userNameSpan").innerHTML = "";
				return false;
			}
			var isNameValid = true;
			jQuery.ajax({
				type: "POST",
				url: '&lt;c:url value="/users.do?method=checkUser" />',
				data: "userName=" + userName,
				dataType: "json", 
				cache: false,
				async: false,
				success: function (data, textStatus) {
					isNameValid = data['isNameValid'];
					if(isNameValid) {
						document.getElementById("userNameSpan").innerHTML = "该用户名可以使用";
					} else {
						document.getElementById("userNameSpan").innerHTML = "该用户名已经被占用";
						userNameInput.focus();
					}
				}
			});
			return isNameValid;
		}
	</script>
</head>
<body>
	
<html:form action="/regist.do?method=regist" method="POST" onsubmit="javascript:if(validateUserForm(this)){return checkUserName(this);}else{return false;}">
		<bean:message key="lable.text.userName"/><bean:message key="lable.text.colon"/><html:text property="userName" styleId="userName" onblur="checkUserName()"></html:text><span id="userNameSpan"></span><br />
		<bean:message key="lable.text.password"/><bean:message key="lable.text.colon"/>&nbsp;&nbsp;&nbsp;&nbsp;<html:password property="password"></html:password><br />
		<bean:message key="lable.text.email"/><bean:message key="lable.text.colon"/>&nbsp;&nbsp;&nbsp;&nbsp;<html:text property="email"></html:text>
		<html:submit><bean:message key="lable.text.regist"/></html:submit>
	</html:form>
</body>
</html:html>
