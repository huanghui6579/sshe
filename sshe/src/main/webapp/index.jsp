<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.3.6/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.3.6/themes/icon.css">

<style type="text/css">
	.dialog-button {
	    text-align: center;
	}
	.dialog-button .l-btn{
	    margin-left: 10px;
	    margin-right: 10px;
	}
	table {
		margin: auto;
	}
	table tr th {
		text-align: right;
		float: right;
	}
</style>

<script type="text/javascript" src="js/jquery-easyui-1.3.6/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.3.6/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.3.6/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/common/my-util.js"></script>

<script type="text/javascript">
	$(function() {
		$("#index_reg_dialog").dialog({
			title:'用户注册',
			closable:false, 
			modal:true, 
	    	draggable:false, 
	    	buttons:[
	    	{
				text:'取消',
				iconCls:'icon-cancel',
				handler:function(){
					$('#index_reg_dialog').dialog('close');
				}
			},{
				text:'提交',
				iconCls:'icon-save',
				handler:function(){
					$("#index_reg_form").form("submit", {
						 url: '${pageContext.request.contextPath}/userAction!regist.action',
						 success:function(data){
						 	alert(data);
						 }
					});
				}
			}]
		}).dialog('close');
		
	});
</script>

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
	    	draggable:false, buttons:[
	    	{
				text:'注册',
				iconCls:'icon-add',
				handler:function(){
					var regDialog = $('#index_reg_dialog');
					regDialog.dialog('open');
				}
			},{
				text:'登录',
				iconCls:'icon-ok',
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
	    
	    <!-- 注册窗口,默认隐藏 -->
	    <div id="index_reg_dialog">
	    	<form id="index_reg_form" method="post">
	    	<table>
	    		<tr>
	    			<th>账号：</th>
	    			<td><input type="text" class="easyui-validatebox" data-options="required:true, missingMessage:'账号必须输入'" name="username" /></td>
	    		</tr>
	    		<tr>
	    			<th>密码：</th>
	    			<td><input type="password" id="password" class="easyui-validatebox" data-options="required:true, missingMessage:'密码必须输入'" name="password" /></td>
	    		</tr>
	    		<tr>
	    			<th>确认密码：</th>
	    			<td><input type="password" class="easyui-validatebox" data-options="required:true,validType: 'equals[\'#password\']', missingMessage:'确认密码必须输入'" name="repassword" /></td>
	    		</tr>
	    	</table>
	    	</form>
	    </div>
    </body>
</body>
</html>