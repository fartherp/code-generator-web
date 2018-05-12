<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>代码生成工具</title>
</head>
<body>
<table id="list"></table>
<div id="toolbar">
    <form id="queryForm" class="easyui-form">
        <div>
            类路径<input class="easyui-textbox" type="text" name="classpath" id="classpath" data-options="required:true,prompt:'com.github.fartherp'" value="com.juzix.juice"/>
            项目名<input class="easyui-textbox" type="text" name="projectName" id="projectName" data-options="required:true,prompt:'code'" value="developer"/>
            <%--数据源<input class="easyui-textbox" type="text" name="path" id="path" value="sqlSessionFactory"/>--%>
            分隔符<input class="easyui-combobox" name="isColumnNameDelimited" id="isColumnNameDelimited" style="width:50px;"/>
            项目<input class="easyui-combobox" name="generatorType" id="generatorType" style="width:100px;"/>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="doSearch()">查询表名</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="doCode(1);">生成代码</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="doCode(2);">生成项目</a>
            <a href="https://github.com/fartherp/code-generator-web.git" class="easyui-linkbutton" target="_blank">源码</a>
        </div>
        <div>
            用户名<input class="easyui-textbox" type="text" name="user" id="user" data-options="required:true,prompt:'root'" value="openservice"/>
            密&nbsp;&nbsp;&nbsp;码<input class="easyui-textbox" type="text" name="password" id="password" data-options="required:true,prompt:'root'" value="openservice"/>
            U&nbsp;R&nbsp;L<input class="easyui-textbox" type="text" name="url" id="url" size="50" value="jdbc:mysql://192.168.9.71:3306/juice_developer_v_2_0" data-options="required:true,prompt:'jdbc:mysql://localhost:3306/code_test'"/>
        </div>
    </form>
</div>
</body>
</html>
<script type="text/javascript" src="<c:url value="/"/>js/page/code/action.js"></script>
<script type="text/javascript" src="<c:url value="/"/>js/page/code/model.js"></script>