<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2022/10/12
  Time: 13:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}">好物二手店后台</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li ><a href="${pageContext.request.contextPath}/admin/order_list">订单管理</a></li>
                <li ><a href="${pageContext.request.contextPath}/admin/user_list">客户管理</a></li>
                <li ><a href="${pageContext.request.contextPath}/admin/goods_list">商品管理</a></li>
                <li ><a href="${pageContext.request.contextPath}/admin/type_list">类目管理</a></li>
                <li><a href="${pageContext.request.contextPath}/user_logout">退出</a></li>
            </ul>
        </div>
    </div>
</nav>
