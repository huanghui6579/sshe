<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script type="text/javascript">
	$(function() {
		$('#admin_usermanage_datagrid').datagrid({
			url : '',
			columns : [ [ {
				field : 'id',
				title : '编号',
				width : 150
			}, {
				field : 'username',
				title : '登陆名',
				width : 150
			}, {
				field : 'createDate',
				title : '创建时间',
				width : 150
			}, {
				field : 'modifyDate',
				title : '修改时间',
				width : 150
			} ] ],
			fit: true,
			border: false
		});
	});
</script>

<!-- <table id="admin_usermanage_datagrid"></table> -->
    <table class="easyui-datagrid" style="width:400px;height:250px"
    data-options="url:'datagrid_data.json',fitColumns:true,singleSelect:true">
    <thead>
    <tr>
    <th data-options="field:'code',width:100">Code</th>
    <th data-options="field:'name',width:100">Name</th>
    <th data-options="field:'price',width:100,align:'right'">Price</th>
    </tr>
    </thead>
    </table>