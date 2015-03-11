<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"
					+request.getServerName()+":"
					+request.getServerPort()+path+"/";
%>
<meta charset="UTF-8">
<base href="<%=basePath%>">
<link rel="stylesheet" href="public/css/style.css" type="text/css">
<script src="public/js/jquery-1.11.0.min.js" type="text/javascript">
</script>
<script type="text/javascript" src="public/js/common.js"></script>