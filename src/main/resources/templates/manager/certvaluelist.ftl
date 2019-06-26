<html>
<head>
    <meta charset="utf-8">
    <title>商品编码对应面值列表</title>
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
                    <th>商品编码</th>
                    <th>面值</th>
                    <th><a href="/scancode/manager/addcertvalue">新增商品编码对应面值</a></th>
                </tr>
                </thead>
                <tbody>
                <#list list as certvalueinfo>
                <tr>
                    <td>${certvalueinfo.outerItemId}</td>
                    <td>${certvalueinfo.outerCertCardValue}</td>
                    <td><a href="/scancode/manager/deletecertvalue?outerItemId=${certvalueinfo.outerItemId}"/>删除商品编码对应面值</td>
                </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>