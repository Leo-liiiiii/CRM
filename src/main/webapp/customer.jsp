<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>客户信息管理</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/skin/css/base.css">
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>


    <script type="application/javascript">
        $(function () {
            search(1);
        });

        function search(obj) {
            $.ajax({
                type: 'GET',
                url: '${pageContext.request.contextPath}/cus/showInfo',
                data: {
                    "currentpage": obj,
                    "keyindex": $("#mt").val(),
                    "keyCode": "%" + $("#info").val() + "%",
                    "num": $("#mtime").val()
                },
                dataType: 'json',
                success: function (rs) {
                    // 给表单添加数据之前去删除表单数据 rs我们pageInfo
                    $(".datatr").remove();
                    $(rs.list).each(function (index, cus) {
                        var date = new Date(cus.addtime);
                        var newtime = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate();
                        var tr = "<tr class='datatr' align='center' bgcolor='#FFFFFF'onMouseMove='javascript:this.bgColor='#FCFDEE';' onMouseOut='javascript:this.bgColor='#FFFFFF';' height='22' >\n" +
                            "<td><input name='id' type='checkbox' id='id' value='" + cus.id + "'class='ck'></td>\n" +
                            "        <td>" + cus.id + "</td>\n" +
                            "        <td>" + cus.companyperson + "</td>\n" +
                            "        <td align=\"center\">" + cus.comname + "</td>\n" +
                            "        <td>" + newtime + "</td>\n" +
                            "        <td>" + cus.comphone + "</td>\n" +
                            "        <td><a href=\"${pageContext.request.contextPath}/customer-edit.jsp?id=" + cus.id + "\">编辑</a> | <a href=\"${pageContext.request.contextPath}/customer-look.jsp?id=" + cus.id + "\">查看详情</a></td>" +
                            "    </tr>";

                        $("#tr2").after(tr);
                    });

                    $("#mm").each(function () {
                        $(this).find("td").remove();   //通过循环每一个tr，得到各自下的td
                    });
                    var td = "<td height=\"28\" colspan=\"12\">&nbsp;\n" +
                        " <a href=\"javascript:zheng()\" class=\"coolbg\">全选</a>\n" +
                        "<a href=\"javascript:fan()\" class=\"coolbg\">反选</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                        "<a href=\"javascript:batchDelete()\" class=\"coolbg\">&nbsp;删除&nbsp;</a>\n" +
                        "<a href=\"\" class=\"coolbg\">&nbsp;导出Excel&nbsp;</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;                                     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                        "当前是第" + rs.pageNum + "页\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                        "<a href=\"javascript:search(1)\" class=\"coolbg\">首页</a>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                        "<a href=\"javascript:search(" + rs.prePage + ")\" class=\"coolbg\">上一页</a>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                        "<a href=\"javascript:search(" + rs.nextPage + ")\" class=\"coolbg\">下一页</a>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                        "<a href=\"javascript:search(" + rs.pages + ")\" class=\"coolbg\">尾页</a>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                        "共有" + rs.pages + "页";
                    $("#mm").append(td);

                },
                error: function () {
                    alert("查询出现异常");
                }
            });
        }

        function zheng() {
            var arr = $(".ck");
            for (var i = 0; i < arr.length; i++) {
                arr[i].checked = true;
            }
        }

        function fan() {
            var arr = $(".ck");
            for (var i = 0; i < arr.length; i++) {
                arr[i].checked = !arr[i].checked;
            }
        }
//批量删除的方法
        function batchDelete() {
            var idarr = new Array();
            // 获取选中状态的复选框
            var arr = $("[name='id']:checked");
            for (var i = 0; i < arr.length; i++) {
                var val = arr[i].value;
                idarr[i] = val;// 集合了我们选中的所有项的id值
            }
            if (idarr.length > 0) {
                $.ajax({
                        type: 'POST',
                        url: '${pageContext.request.contextPath}/cus/bachDelete',
                        data: {
                            "ids": idarr.toString()
                        },
                        dataType: 'json',
                        success: function (resultData) {
                            if (resultData.flag) {
                                window.location.href = "${pageContext.request.contextPath}/customer.jsp";
                            }
                        }
                    })
            } else {
                alert("选中删除的数据");
            }
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
                    <td>
                        当前位置:客户信息管理>>客户信息
                    </td>
                    <td>
                        <input type='button' class="coolbg np" onClick="location='customer-add.jsp';" value='添加客户信息'/>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>

<!--  搜索表单  -->

<table width='98%' border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center" style="margin-top:8px">
    <tr bgcolor='#EEF4EA'>
        <td background='skin/images/wbg.gif' align='center'>
            <table border='0' cellpadding='0' cellspacing='0'>
                <tr>
                    <td width='90' align='center'>搜索条件：</td>
                    <td width='160'>
                        <select id="mt" name='cid' style='width:150px'>
                            <option value='0'>选择类型...</option>
                            <option value='1'>客户所在公司名称</option>
                            <option value='2'>联系人姓名</option>
                        </select>
                    </td>
                    <td width='70'>
                        关键字：
                    </td>
                    <td width='160'>
                        <input type='text' id="info" name='keyCode' style='width:120px'/>
                    </td>
                    <td width='110'>
                        <select id="mtime" name='num' style='width:120px'>
                            <option value='0'>排序...</option>
                            <option value='1'>编号</option>
                        </select>
                    </td>
                    <td>
                        &nbsp;&nbsp;&nbsp;<input name="imageField" onclick="search(1)" type="image"
                                                 src="${pageContext.request.contextPath}/skin/images/frame/search.gif"
                                                 width="45" height="20" border="0" class="np"/>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>

<!--  内容列表   -->
<form name="form2">

    <table id="infotb" width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center"
           style="margin-top:8px">
        <tr bgcolor="#E7E7E7">
            <td height="24" colspan="12" background="skin/images/tbg.gif">&nbsp;需求列表&nbsp;</td>
        </tr>
        <tr align="center" bgcolor="#FAFAF1" height="22" id="tr2">
            <td width="4%">选择</td>
            <td width="6%">序号</td>
            <td width="10%">联系人</td>
            <td width="10%">公司名称</td>
            <td width="8%">添加时间</td>
            <td width="8%">联系电话</td>
            <td width="10%">操作</td>
        </tr>


        <%--
         <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
                <td><input name="id" type="checkbox" id="id" value="101" class="np"></td>
                <td>1</td>
                <td>李彦宏</td>
                <td align="center">百度</td>
                <td>2015-02-03</td>
                <td>13257634888</td>
                <td><a href="customer-edit.jsp">编辑</a> | <a href="customer-look.jsp">查看详情</a></td>
            </tr>

            --%>


        <tr bgcolor="#FAFAF1" id="mm">
            <%--
              <td height="28" colspan="12">
                 <!-- 分页代码 -->
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 当前是第1页
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 <a href="javascript:search(1)" class="coolbg">首页</a>
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 <a href="javascript:search(1)" class="coolbg">上一页</a>
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 <a href="javascript:search(2)" class="coolbg">下一页</a>
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 <a href="javascript:search(2)" class="coolbg">尾页</a>
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 共有3页
             </td>--%>
        </tr>

    </table>

</form>


</body>
</html>