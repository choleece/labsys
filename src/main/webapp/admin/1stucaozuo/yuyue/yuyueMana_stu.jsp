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
        </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="5" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="10%">预约老师</td>
					<td width="10%">预约时间</td>
					<td width="10%">备注信息</td>
					<td width="10%">提交时间</td>
					
					<td width="12%">老师回复信息</td>
		        </tr>	
				<c:forEach items="${requestScope.yuyueList}" var="yuyue">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${yuyue.tea_name}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${yuyue.yuyueshijian}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${yuyue.beizhu}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${yuyue.shijian}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${yuyue.huifu}
					</td>
				</tr>
				</c:forEach>
			</table>
	</body>
</html>
