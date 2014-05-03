<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(function() {
		$('#admin_usermanage_datagrid').datagrid({
			url : '${pageContext.request.contextPath}/userAction!datagrid.action',
			frozenColumns: [[{
				field : 'username',
				title : '登陆名',
				width : 150,
				align: 'center',
				sortable: true
			}]],
			columns : [ [{
				field : 'createDate',
				title : '创建时间',
				width : 150,
				align: 'center'
			}, {
				field : 'modifyDate',
				title : '修改时间',
				width : 150,
				align: 'center'
			} ] ],
			fit: true,
			border: false,
			pagination:true,
			idField: 'id',
			fitColumns: true,
			toolbar: [{
				text: '添加',
				iconCls: 'icon-add',
				handler: function(){}
			},'-',{
				text: '删除',
				iconCls: 'icon-remove',
				handler: function(){}
			}]
		});
	});
	
	function searchUser() {
		$('#admin_usermanage_datagrid').datagrid('load', {
			 username: $('#admin_usermanage_layout input[name=username]').val()
		});
	}
	
	function clearParam() {
		$('#admin_usermanage_datagrid').datagrid('load', {});
		$('#admin_usermanage_layout input[name=username]').val('');
	}
</script>

<div id="admin_usermanage_layout" class="easyui-layout" data-options="fit:true, border:false" >
	<div data-options="region:'north', title:'用户查询', border:false" style="height:100px;">
		<input type="text" name="username" />
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search', plain:true" onclick="searchUser()">搜索</a>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel', plain:true" onclick="clearParam()">清空</a>
	</div>
	<div data-options="region:'center', border:false">
		<table id="admin_usermanage_datagrid"></table>
	</div>
</div>