<html>
<head>
    <meta charset="utf-8">
    <title>成功</title>
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
                        <div class="alert alert-dismissable alert-danger">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                            <h4>
                                错误!
                            </h4> <strong>${msg}</strong>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
</body>
</html>