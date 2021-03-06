<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		
        <script language="javascript">
           function down1(fujianPath,fujianYuashiMing)
           {
               var url="<%=path %>/updown/updown.jsp?fujianPath="+fujianPath+"&fujianYuashiMing="+fujianYuashiMing;
		       url=encodeURI(url); 
               url=encodeURI(url); 
               window.open(url,"_self");
           }
        </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="5" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="10%">实验项目名称</td>
					<td width="10%">实验项目描述</td>
					<td width="10%">申请表</td>
					<td width="10%">试验时间</td>
					<td width="12%">申请时间</td>
					<td width="12%">申请结果</td>
					<td width="12%">实验室管理员回复信息</td>
		        </tr>	
				<c:forEach items="${requestScope.shiyanshenqingList}" var="shiyanshenqing">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${shiyanshenqing.name}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${shiyanshenqing.beizhu}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<c:if test="${shiyanshenqing.fujian==''}">
						    没有上传申请表
						</c:if>
						<c:if test="${shiyanshenqing.fujian !=''}">
						     ${shiyanshenqing.fujianYuanshiming}
						     &nbsp;&nbsp;
						     <a href="#" onclick="down1('${shiyanshenqing.fujian}','${shiyanshenqing.fujianYuanshiming}')" style="font-size: 10px;color: red">down</a>
						</c:if>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${shiyanshenqing.shiyanshijian}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${shiyanshenqing.shenqingshijian}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<c:if test="${shiyanshenqing.del=='shenhezhong'}">
						    等待审核
						</c:if>
						<c:if test="${shiyanshenqing.del=='pass'}">
						    审核通过
						</c:if>
						<c:if test="${shiyanshenqing.del=='nopass'}">
						    审核未通过
						</c:if>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${shiyanshenqing.huifu}
					</td>
				</tr>
				</c:forEach>
			</table>
	</body>
</html>
