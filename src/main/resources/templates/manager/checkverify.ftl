<html>
<head>
    <meta charset="utf-8">
    <title>核销员审核</title>
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
                        <form action="/scancode/manager/checkverifyupdate" method="post">
                            <div class="forms">
                                <h3>请赋予该人权限,只能填BOSS或者PLAYER,瑾记BOSS可以查看核销券码</h3>
                                <input type="text" name="staff">
                                <input type="hidden" name="openid" value="${openid}">
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