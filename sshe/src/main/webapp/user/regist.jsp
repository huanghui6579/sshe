<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<!-- 注册窗口,默认隐藏 -->
    <div id="user_reg_dialog" style="width: 250px;" class="easyui-dialog" data-options="title:'用户注册',
		closable:false, 
		modal:true, 
    	draggable:false, 
    	closed: true,
    	buttons:[
    	{
			text:'取消',
			iconCls:'icon-cancel',
			handler:function(){
				$('#user_reg_dialog').dialog('close');
			}
		},{
			text:'提交',
			iconCls:'icon-save',
			handler:function(){
				if( $('#user_reg_form').form('validate')) {
					//ajax提交的方式
					$.ajax({
						url: '${pageContext.request.contextPath}/userAction!regist.action',
						type: 'POST',
						dataType: 'json',
						data: $('#user_reg_form').serialize(),
						success: function(data) {
							if(data.success) {
								$('#user_reg_dialog').dialog('close');
								$('#user_login_dialog').dialog('close');
								$.messager.show({
									title:'提示',
									msg: data.msg
								});
							} else {
								$.messager.alert('提示', data.msg,'warning', function() {
									var nameinput = $('#user_reg_form [name=username]');
									nameinput.focus();
									nameinput.select();
								});
							}
						},
						error: function(xhr) {
							$.messager.alert('提示', xhr.responseText,'error');
						}
					});
				}
			}
		}]">
    	<form id="user_reg_form" method="post">
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
    			<td><input type="password" class="easyui-validatebox" data-options="required:true,validType: 'equals[\'#password\']', missingMessage:'确认密码必须输入'" /></td>
    		</tr>
    	</table>
    	</form>
    </div>