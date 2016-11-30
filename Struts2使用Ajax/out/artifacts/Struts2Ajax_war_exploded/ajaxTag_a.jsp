<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<head>
  <sx:head debug="true"/>
</head>

<div id="div1">Div 1</div>
<s:url id="ajaxTest" value="/ajaxTest.action"/>
<sx:a id="link1" href="%{ajaxTest}" targets="div1">
     点击即可更新Div 1区域的内容！
</sx:a>
