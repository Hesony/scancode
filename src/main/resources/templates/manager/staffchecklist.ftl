<html>
<head>
    <meta charset="utf-8">
    <title>核销员信息列表</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/static/css/style.css">
    <link href="https://cdn.bootcss.com/bootstrap-fileinput/4.4.7/css/fileinput.min.css" media="all" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <h2 class="text-center">
                电子券后台管理系统
            </h2>
            <#include "../common/menu.ftl">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>店铺名称</th>
                    <th>昵称</th>
                    <th>openid</th>
                    <td>地区</td>
                    <td>角色</td>
                    <th colspan="2">操作</th>
                </tr>
                </thead>
                <tbody>
                <#list stafflist as staffinfo>
                <tr>
                    <td>${staffinfo.shopName}</td>
                    <td>${staffinfo.nickname}</td>
                    <td>${staffinfo.openid}</td>
                    <td>${staffinfo.province}——${staffinfo.city}</td>
                    <td>${staffinfo.staff}</td>
                    <td>
                        <#if staffinfo.staff == "NOTYET">
                            <a href="/scancode/manager/checkverify?openid=${staffinfo.openid}">审核通过</a>
                        </#if>
                    </td>
                    <td>
                        <a href="/scancode/manager/deleteverify?openid=${staffinfo.openid}">    删除</a>
                    </td>
                </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>