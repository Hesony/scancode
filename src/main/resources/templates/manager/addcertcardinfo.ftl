<html>
<head>
    <meta charset="utf-8">
    <title>新增卡密</title>
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
                        <form action="#" method="post">
                            <div class="forms">
                                <h3>请输入卡密信息</h3>
                                <h6>卡密信息:</h6><input type="text" name="certcardinfo"
                            style="height: 100px;width: 100px;">
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