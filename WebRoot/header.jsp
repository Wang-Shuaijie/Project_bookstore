<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<table width="100" border="0" cellspacing="0" cellpadding="0"
	align="center">
	<tr>
		<td width="5%"></td>
		<td width="10%"><a href="index.jsp"
			onMouseOut="MM_swapImgRestore()"
			onMouseOver="MM_swapImage('Image1','','images/index_on.gif',1)">
				<img name="Image1" border="0" src="images/index.gif" width="90"
				height="36">
		</a></td>
		<td width="10%"><a href="user/userinfo.jsp"
			onMouseOut="MM_swapImgRestore()"
			onMouseOver="MM_swapImage('Image2','','images/reg_on.gif',1)"> <img
				name="Image2" border="0" src="images/reg.gif" width="92" height="36"></a></td>
		<td width="10%"><a href="user/shopcart.jsp"
			onMouseOut="MM_swapImgRestore()"
			onMouseOver="MM_swapImage('Image4','','images/carts_on.gif',1)">
				<img name="Image4" border="0" src="images/cart.gif" width="92"
				height="36">
		</a></td>
		<td width="10%"><a href="user/orderSer"
			onMouseOut="MM_swapImgRestore()"
			onMouseOver="MM_swapImage('Image5','','images/order_on.gif',1)">
				<img name="Image5" border="0" src="images/order.gif" width="92"
				height="36">
		</a></td>
		<td width="10%"><a href="exitSer"
			onMouseOut="MM_swapImgRestore()"
			onMouseOver="MM_swapImage('Image6','','images/exit_on.gif',1)"> <img
				name="Image6" border="0" src="images/exit.gif" width="92"
				height="36"></a></td>
	</tr>
</table>
