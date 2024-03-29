<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="${pageContext.request.contextPath}/img/user13.jpg"
					class="img-circle" alt="User Image">
			</div>
			<div class="pull-left info">
				<p>Admin</p>
				<a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
			</div>
		</div>

		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header">菜单</li>
			<li id="admin-index"><a
				href="${pageContext.request.contextPath}/pages/main.jsp"><i
					class="fa fa-dashboard"></i> <span>首页</span></a></li>


			<li class="treeview"><a href="#"> <i class="fa fa-cube"></i>
					<span>数据管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">

					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/product/findAll.do?paga=1&size=5">
							<i class="fa fa-circle-o"></i> 产品管理
					</a></li>
					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/orders/findAll.do?paga=1&size=20"> <i
							class="fa fa-circle-o"></i> 订单管理
					</a></li>
					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/traveller/findAll.do?paga=1&size=5"> <i
							class="fa fa-circle-o"></i> 旅客管理
					</a></li>
					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/guide/findAll.do?paga=1&size=5"> <i
							class="fa fa-circle-o"></i> 导游管理
					</a></li>
					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/hotel/findAll.do?paga=1&size=5"> <i
							class="fa fa-circle-o"></i> 酒店管理
					</a></li>
				</ul></li>



			<li class="treeview"><a href="#"> <i class="fa fa-cogs"></i>
					<span>系统管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>


			</a>
				<ul class="treeview-menu">

					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/user/findAll.do"> <i
							class="fa fa-circle-o"></i> 用户管理
					</a></li>
					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/role/findAll.do"> <i
							class="fa fa-circle-o"></i> 职位管理
					</a></li>
					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/permission/findAll.do">
							<i class="fa fa-circle-o"></i> 资源权限管理
					</a></li>
				</ul></li>

		</ul>
	</section>
	<!-- /.sidebar -->
</aside>