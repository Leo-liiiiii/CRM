<%@ page language="java"  import="com.ujiuye.usual.bean.Baoxiao,java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<title>报销修改</title>
	<link rel="stylesheet" type="text/css" href="skin/css/base.css">
	<script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>


	<script type="application/javascript">
        $(function () {
            $.ajax({
                type:'GET',
                url:'${pageContext.request.contextPath}/baoxiao/showBaoxiaoAndEx',
                data:{"bxid":${param.bxid}},
                dataType:'json',
                success:function (rs) {
                    $("#bxid").val(rs.bxid);
                    $("#totalmoney").val(rs.totalmoney);
                    $("#bxtime").val('2020-07-10');
                    $("#bxremark").val(rs.bxremark);
                    //处理历史批注
                    if(rs.baoxiaoreplies.length>0){
                        var info = "";
                        $(rs.baoxiaoreplies).each(function (index,item) {
                            var date = new Date(item.replytime);
                            var time = date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+":"+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
                            info += "审批时间：	"+time+":"+"	审批意见		"+item.content+"\n";
                        });
                        $("#pizhu").append(info);
                    }
                }
            });
            //获取全部的支付方式
            $.ajax({
                type:'GET',
                url:'${pageContext.request.contextPath}/exp/showExp',
                dataType:'json',
                success:function (rs) {
                    $(rs).each(function (index,item) {
                        var option = "<option value="+item.etid+">"+item.etname+"</option>";
                        $("#paymode").append(option);
                    });
                }
            });
        });

        function commit() {
            $("#form11").submit();
        }
	</script>

</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>


<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
	<tr>
		<td height="26" background="skin/images/newlinebg3.gif">
			<table width="58%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td >
						当前位置:报销管理>>修改报销单内容
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>

<form name="form2" id="form11" action="${pageContext.request.contextPath}/baoxiao/updateBaoxiao" method="post">
	<input type="hidden" id="bxid" name="bxid">
	<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
		<tr bgcolor="#E7E7E7">
			<td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;添加新的报销单&nbsp;</td>
		</tr>

		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">支出类型：</td>
			<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">

				<select name="paymode" id="paymode">

				</select>
			</td>
		</tr>
		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">总金额：</td>
			<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<input size="26"  id="totalmoney" name="totalmoney"/>
			</td>
		</tr>
		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">使用时间：</td>
			<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<input size="52" name="bxtime" id="bxtime"/>
			</td>
		</tr>
		<tr >
			<td align="right" bgcolor="#FAFAF1" >备注：</td>
			<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
				<textarea rows=10 cols=130  id="bxremark" name="bxremark"></textarea>
			</td>
		</tr>
		<tr >
			<td align="right" bgcolor="#FAFAF1" >历史批注：</td>
			<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
				<textarea rows=3 cols=130 name="result" id="pizhu" readonly="true"></textarea>
			</td>
		</tr>

		<tr bgcolor="#FAFAF1">
			<td height="28" colspan=4 align=center>
				&nbsp;
				<a href="javascript:commit(0)" class="coolbg">保存</a>
				<a href="project-file.jsp" class="coolbg">返回</a>
			</td>
		</tr>
	</table>

</form>


</body>
</html>