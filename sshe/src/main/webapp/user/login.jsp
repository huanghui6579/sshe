<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<!-- 登录窗口 -->
    <div id="user_login_dialog" class="easyui-dialog" data-options="title:'用户登录', closable:false, modal:true, 
    	draggable:false, buttons:[
    	{
			text:'注册',
			iconCls:'icon-add',
			handler:function(){
				$('#user_reg_form input').val('');
				var regDialog = $('#user_reg_dialog');
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