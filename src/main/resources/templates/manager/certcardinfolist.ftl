<html>
<head>
    <meta charset="utf-8">
    <title>卡密列表</title>
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
                    <th>序列号</th>
                    <th>兑换码</th>
                    <th>面值</th>
                    <th>创建时间</th>
                    <th>卡片有效期</th>
                    <th><a href="/scancode/manager/addcertcardinfo">新增卡密</a></th>
                </tr>
                </thead>
                <tbody>
                <#list list as certcardinfo>
                <tr>
                    <td>${certcardinfo.serialNumber}</td>
                    <td>**********</td>
                    <td>${certcardinfo.value}</td>
                    <td>${certcardinfo.createTime}</td>
                    <td>${certcardinfo.validity}</td>
                    <td><a href="/scancode/manager/deletecertcardinfo?serialNumber=${certcardinfo.serialNumber}"/>删除卡密</td>
                </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>