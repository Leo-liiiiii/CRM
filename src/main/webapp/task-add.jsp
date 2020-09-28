<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<title>创建任务</title>
	<link rel="stylesheet" type="text/css" href="skin/css/base.css">
	<script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>

	<script type="application/javascript">

        $(function () {
            //显示项目：有模块，模块下有功能，功能没有被分配
            $.ajax({
                type:'GET',
                url:'${pageContext.request.contextPath}/pro/showProWithFunction',
                dataType:'json',
                success:function (resultData) {
                    $(resultData).each(function (index,item) {
                        var option = "<option value="+item.pid+">"+item.pname+"</option>";
                        $("#pro").append(option);
                    });
                }
            });




            //获取执行员工的信息
            $.ajax({
                type:'GET',
                url:'${pageContext.request.contextPath}/emp/showEmp',
                dataType:'json',
                success:function (resultData) {
                    $(resultData).each(function (index,item) {
                        var option = "<option value="+item.eid+">"+item.ename+"</option>";
                        $("#emp").append(option);
                    });
                }
            });
        });



        //需求与模块随着项目改变而改变
        function addayalisys(obj) {
            $.ajax({
                type:'GET',
                url:'${pageContext.request.contextPath}/analysis/getAnaInfo',
                data:{"pid":obj},
                dataType:'json',
                success:function (resultData) {
                    $("#anid").val(resultData.title);
                    //清除原数据（第二条开始）
                    $("option[class='opt']").remove();
                    $(resultData.modules).each(function (index,item) {
                        var option = "<option class='opt' value="+item.id+">"+item.modname+"</option>";
                        $("#mod").append(option)
                    });
                }
            });
        }

        function addfunc(obj) {
            $.ajax({
                type:'GET',
                url:'${pageContext.request.contextPath}/function/getFuncByMid',
                data:{"mid":obj},
                datatType:'json',
                success:function (resultData) {
                    $("option[class='opt1']").remove();
                    $(resultData).each(function (index,item) {
                        var option = "<option class='opt1' value="+item.id+">"+item.functionname+"</option>";
                        $("#fun").append(option);
                    });

                }
            });
        }

        function commit() {
            $("#form7").submit();
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
						当前位置:任务管理>>创建任务
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>

<form name="form2" id="form7" action="${pageContext.request.contextPath}/task/addInfo" method="post">

	<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
		<tr bgcolor="#E7E7E7">
			<td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;创建任务&nbsp;</td>
		</tr>
		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">参考位置：</td>
			<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<select id="pro" onchange="addayalisys(this.value)">
					<option>请选择项目</option>
				</select>-
				<input type="text" id="anid">
				-<select id="mod" onchange="addfunc(this.value)"><option>请选择模块</option></select>-
				<select id="fun" name="funFk"><option value=1>请选择功能</option></select>
			</td>
		</tr>
		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">任务标题：</td>
			<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input name="tasktitle"/></td>
		</tr>
		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">开始时间：</td>
			<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input type="date" name="starttime"/></td>
		</tr>
		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">结束时间：</td>
			<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input type="date" name="endtime"/></td>
		</tr>
		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">执行者：</td>
			<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<select id="emp" name="empFk2">
					<option>任务的执行者</option>
				</select>
			</td>
		</tr>
		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">优先级：</td>
			<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<select name="level"><option value="高">高</option><option value="中">中</option><option value="低">低</option></select></td>
		</tr>

		<tr >
			<td align="right" bgcolor="#FAFAF1" >详细说明：</td>
			<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
				<textarea rows=10 cols=130 name="remark"></textarea>
			</td>
		</tr>


		<tr bgcolor="#FAFAF1">
			<td height="28" colspan=4 align=center>
				&nbsp;
				<a href="javascript:commit()" class="coolbg">保存</a>
			</td>
		</tr>
	</table>

</form>


</body>
</html>