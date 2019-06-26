<html>
<head>
    <meta charset="utf-8">
    <title>电子券核销记录</title>
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
                    <th>商品编码</th>
                    <th>核销员openid</th>
                    <th>核销员昵称</th>
                    <th>订单号</th>
                    <th>二维码券号</th>
                    <th>电子券码</th>
                    <th>核销时间</th>
                </tr>
                </thead>
                <tbody>
                <#list verifyloglist as verifylog>
                <tr>
                    <td>${verifylog.shopName}</td>
                    <td>${verifylog.outerItemId}</td>
                    <td>${verifylog.openid}</td>
                    <td>${verifylog.nickname}</td>
                    <td>${verifylog.tid}</td>
                    <td>${verifylog.scanCode}</td>
                    <td>${verifylog.ticketCode}</td>
                    <td>${verifylog.createTime}</td>
                </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>