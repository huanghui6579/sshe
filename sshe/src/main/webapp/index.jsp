<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.3.6/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.3.6/themes/icon.css">
<script type="text/javascript" src="js/jquery-easyui-1.3.6/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.3.6/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.3.6/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
    <body class="easyui-layout">
	    <div data-options="region:'north', split:true" style="height:100px;"></div>
	    <div data-options="region:'south', split:true" style="height:20px;">dsafdsf</div>
	    <div data-options="region:'east',title:'East',split:true" style="width:100px;"></div>
	    <div data-options="region:'west',split:false" style="width:200px;">
			<div class="easyui-panel" data-options="title:'west', fit:true, border:false"></div>
		</div>
	    <div data-options="region:'center',title:'center title'" style="background:#eee;"></div>
	    
	    <!-- 登录窗口 -->
	    <div class="easyui-dialog" data-options="title:'用户登录', closable:false, modal:true, 
	    	draggable:false, buttons:[{
				text:'Save',
				handler:function(){}
			},{
				text:'Close',
				handler:function(){}
			}]">
	    	<table>
	    		<tr>
	    			<th>账号：</th>
	    			<td><input type="text" name="username" /></td>
	    		</tr>
	    		<tr>
	    			<th>密码：</th>
	    			<td><input type="password" name="password" /></td>
	    		</tr>
	    	</table>
	    </div>
    </body>
</body>
</html>