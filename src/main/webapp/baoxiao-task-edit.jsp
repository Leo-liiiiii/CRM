<%@ page import="com.ujiuye.usual.bean.Baoxiao,java.util.*" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<title>编辑附件</title>
	<link rel="stylesheet" type="text/css" href="skin/css/base.css">
	<script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>


	<script type="application/javascript">

        $(function () {
            $.ajax({
                type:'GET',
                url:'${pageContext.request.contextPath}/baoxiao/getOneBaoXiaoByid',
                data:{"bxid":${param.bxid}},
                dataType:'json',
                success:function (rs) {
                    $("#money").val(rs.totalmoney);
                    $("#usetime").val('2020-7-9');
                    $("#bz").val(rs.bxremark);
                   $("#lspizhu").css("display","table-row");
                    var info = "";
                    $(rs.baoxiaoreplies).each(function (index,item) {
                        var date = new Date(item.replytime);
                        var time = date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+":"+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
                        info += "审批时间：	"+time+":"+"	审批意见		"+item.content+"\n";
                    });
                    $("#lspizhu").append(info);
                }
            });
        });

        function commit(obj){
            $.ajax({
                type:"GET",
                url:"${pageContext.request.contextPath}/baoxiao/shenpi",
                data:{"bxstatus":obj,"bxid":${param.bxid},"content":$("#pizhu").val()},
                dataType:"json",
                success:function(resultData){
                    if (resultData.flag){
                        window.location.href="${pageContext.request.contextPath}/baoxiao-task.jsp";
                    }
                }
            });
        }
	</script>


</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

<%--<%--%>
<%--String bxid = request.getParameter("bxid");--%>
<%--System.out.println(bxid+"++++++++++++++++++++++++++++");--%>
<%--Baoxiao nbx = null;--%>
<%--List<Baoxiao> list = (List<Baoxiao>)session.getAttribute("udobaoxiao");--%>
<%--for(Baoxiao bx : list){--%>
<%--if(bx.getBxid().equals(bxid)){--%>
<%--nbx = bx;--%>
<%--}--%>
<%--}--%>
<%--System.out.println(nbx+"=============="+list.size());--%>
<%--request.setAttribute("nbx",nbx);--%>
<%--%>--%>




<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
	<tr>
		<td height="26" background="skin/images/newlinebg3.gif">
			<table width="58%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td >
						当前位置:项目管理>>报销审批
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>

<form name="form2" id="form10">

	<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">

		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">金额：</td>
			<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<input id="money" readonly="true"/></td>
		</tr>
		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">使用时间</td>
			<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">

				<input id="usetime" readonly="true" /></td>
		</tr>
		<tr >
			<td align="right" bgcolor="#FAFAF1" >备注：</td>
			<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
				<textarea rows=10 cols=130 readonly="true" id="bz"></textarea>
			</td>
		</tr>
		<tr >
			<td align="right" bgcolor="#FAFAF1" >历史批注：</td>
			<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
				<!-- 批注信息 -->
				<textarea rows=10 id="lspizhu" cols=130   readonly="true"></textarea>
			</td>
		</tr >
		<tr >
			<td align="right" bgcolor="#FAFAF1" >批准信息：</td>
			<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
				<!-- 批注信息 -->
				<textarea rows=10 id="pizhu" cols=130 name="result"></textarea>
			</td>
		</tr >

		<tr bgcolor="#FAFAF1">
			<td height="28" colspan=4 align=center>
				&nbsp;
				<a href="javascript:commit(1)" class="coolbg">同意</a>
				<a href="javascript:commit(2)" class="coolbg">驳回</a>
			</td>
		</tr>
	</table>

</form>


</body>
</html>