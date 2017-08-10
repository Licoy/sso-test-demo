<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
</head>
<body>
<div style="margin: 50px auto">
    <#--<form action="http://account.com:8080/check?url=http://a.com:8080" method="post">
        <input placeholder="用户名" type="text" name="username" />
        <br>
        <input type="password" placeholder="密码" name="password"/>
        <br>
        <button type="submit">登录</button>
    </form>-->
    <script>location = "http://account.com:8080/?url="+window.location.protocol+"//"+window.location.host</script>
</div>
</body>
</html>