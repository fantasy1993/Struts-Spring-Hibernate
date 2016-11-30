<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<title><s:text name="lable.text.regist"/></title>
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
				url: '<s:url action="user" method="checkUser.action" />',
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
	<s:actionerror/>
	<s:form name="registForm" method="POST" action="/regist|regist.action" validate="true">
		
		<s:token />
		<s:textfield name="userName" id="userName" key="lable.text.userName" onblur="checkUserName()"></s:textfield><span id="userNameSpan"></span><br />
		<s:password name="password" key="lable.text.password"></s:password><br />
		<s:textfield name="email" key="lable.text.email"></s:textfield>
		<s:submit type="input" action="regist" method="regist" key="lable.text.regist"></s:submit>
	</s:form>
</body>
</html>
