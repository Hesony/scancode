<html>
<head>
    <meta charset="utf-8">
    <title>您店铺下已核销电子券</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/static/css/style.css">
    <link href="https://cdn.bootcss.com/bootstrap-fileinput/4.4.7/css/fileinput.min.css" media="all" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <h2 class="text-center">
            </h2>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>核销人昵称</th>
                    <th>电子券码</th>
                    <th>商品名称</th>
                    <th>核销时间</th>
                </tr>
                </thead>
                <tbody>
                <#list list as VerifyLogModel>
                <tr>
                    <td><h2>${VerifyLogModel.nickname}</h2></td>
                    <td><h2>${VerifyLogModel.ticketCode}</h2></td>
                    <td><h2>${VerifyLogModel.goodsTitle}</h2></td>
                    <td><h2>${VerifyLogModel.createTime}</h2></td>
                </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>