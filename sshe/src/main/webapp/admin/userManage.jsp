<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(function() {
		$('#admin_usermanage_datagrid').datagrid({
			url : '',
			columns : [ [ {
				field : 'id',
				title : '编号',
				width : 150,
				align: 'center'
			}, {
				field : 'username',
				title : '登陆名',
				width : 150,
				align: 'center'
			}, {
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
			border: false
		});
	});
</script>

<table id="admin_usermanage_datagrid"></table>