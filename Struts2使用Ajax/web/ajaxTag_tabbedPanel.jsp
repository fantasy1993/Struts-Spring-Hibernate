<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<head>  <sx:head/>  </head>

<body>
    <div style="float: right">
        <sx:tabbedpanel id="test" closeButton="tab" cssStyle="width:300px">
            <sx:div id="one" label="静态内容" theme="ajax" closable="true">
                这是第一个tab页<br/>
                <s:form>
                    <s:textfield name="userName" label="帐号"/>  <br/>
                    <s:password name="userPassword" label="密码"/>
                    <s:submit value="登录"/>
                </s:form>
            </sx:div>
            <sx:div id="two" label="动态内容" theme="ajax" href="ajaxTest.action" >
                该页面内容是由ajaxTest.action获取的。
            </sx:div>
        </sx:tabbedpanel>
    </div>
</body>
