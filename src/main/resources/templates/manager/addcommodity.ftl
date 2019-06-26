<html>
<head>
    <meta charset="utf-8">
    <title>新增店铺</title>
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

            <div class="container">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <form action="/scancode/manager/addcommoditydetail" method="post">
                            <div class="forms">
                                <h3>请输入商品</h3>
                                <h6>店铺名称</h6><input type="text" name="shopname">
                                <h6>商品编码</h6><input type="text" name="outerItemId">
                                <h6>商品名称</h6> <input type="text" name="goodsTitle">
                                <h1></h1>
                                <div class="submission">
                                    <input type="submit">
                                </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
</body>
</html>