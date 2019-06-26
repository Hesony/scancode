<html>
<head>
    <meta charset="utf-8">
    <title>店铺列表</title>
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
                    <th>店铺ID(邀请码)</th>
                    <th><a href="/scancode/manager/addshop">新增店铺</a></th>
                </tr>
                </thead>
                <tbody>
                <#list shopInfoList as shopinfo>
                <tr>
                    <td>${shopinfo.shopName}</td>
                    <td>${shopinfo.shopId}</td>
                    <td><a href="/scancode/manager/deleteshop?shopid=${shopinfo.shopId}"/>删除店铺</td>
                </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>