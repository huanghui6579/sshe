<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui-1.3.6/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui-1.3.6/themes/icon.css">
<style type="text/css">
.dialog-button {
	text-align: center;
}

.dialog-button .l-btn {
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
<script type="text/javascript" src="js/jquery-easyui-1.3.6/jquery.validatebox.fixed.js"></script>
<script type="text/javascript" src="js/common/my-util.js"></script>

<script type="text/javascript">
	function addTab(opts) {
		var t = $('#index_center_tab');
		if(t.tabs('exists', opts.title)) {	//如果存在，就选中
			t.tabs('select', opts.title);
		} else {
			t.tabs('add', opts);
		}
	}
</script>

</head>
<body>
<body class="easyui-layout">
	<div data-options="region:'north', split:false" style="height: 100px;"></div>
	<div data-options="region:'south', split:false" style="height: 20px;">dsafdsf</div>
	<div data-options="region:'east',title:'East',split:true"
		style="width: 100px;"></div>
	<div data-options="region:'west',split:false" style="width: 200px;">
		<div class="easyui-panel"
			data-options="title:'功能导航', fit:true, border:false">
			<div id="aa" class="easyui-accordion" data-options="fit:true, border:false">
				<div title="系统菜单" data-options="iconCls:'icon-save'" >
					<ul class="easyui-tree" 
					data-options="url:'${pageContext.request.contextPath }/menuAction!treeAll.action',
					parentField:'pid', lines:true, 
					onLoadSuccess: function(node, data) {
						$(this).tree('collapseAll');
					},
					onClick: function(node){
						if(node.attributes.url) {
							var url = '${pageContext.request.contextPath }/' + node.attributes.url;
							addTab({
								title: node.text,
								href: url,
								loadingMessage: '正在加载，请稍后...',
								closable: true
							});
						}
					}"></ul>
				</div>
				<div title="Title2" data-options="iconCls:'icon-reload'">
					content2
				</div>
				<div title="Title3">content3</div>
			</div>
		</div>
	</div>
	<div data-options="region:'center',title:'系统测试'"
		style="background: #eee;">
		<div id="index_center_tab" class="easyui-tabs" data-options="fit:true, border:false">
		   <div title="首页">
			    tab1
		   </div>
	   </div>	
		
	</div>

	<!-- 登录页面 -->
	<jsp:include page="user/login.jsp"></jsp:include>
	<jsp:include page="user/regist.jsp"></jsp:include>

</body>
</body>
</html>