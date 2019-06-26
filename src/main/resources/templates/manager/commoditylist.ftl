<html>
<head>
    <meta charset="utf-8">
    <title>商品编码列表</title>
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
                    <th>店铺ID(邀请码)</th>
                    <th>店铺名称</th>
                    <th>商品编码</th>
                    <th>商品名称</th>
                    <th><a href="/scancode/manager/addcommodity">新增电子券商品</a></th>
                </tr>
                </thead>
                <tbody>
                <#list list as ShopCommodityModel>
                <tr>
                    <td>${ShopCommodityModel.shopId}</td>
                    <td>${ShopCommodityModel.shopName}</td>
                    <td>${ShopCommodityModel.outerItemId}</td>
                    <td>${ShopCommodityModel.goodsTitle}</td>
                    <td><a href="/scancode/manager/deletecommodity?outerItemId=${ShopCommodityModel.outerItemId}">删除商品</a> </td>
                </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>