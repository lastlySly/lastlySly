$(function(){
    loginoperation();
})

function loginoperation(){
    //验证码刷新
    $("#yzm").click(function(){
        var image = document.getElementById("imgId");
        // alert("5555")
        image.src = "/lastlySly/adminController/refreshVerCode.action?"+new Date().getTime();
    })
    //验证码比对
    $("#loginbtn").click(function(){
        var vercode = $("#inpyzm").val();
        $.post("/lastlySly/adminController/checkVerCode.action",{"inputvercode":vercode},function(data){
            var data = JSON.parse(data);
            if(data.code == "1"){
                loginc();
            }else{
                alert("验证码错误");
            }
        })
    })
    //提交登录
    function loginc(){
        var username = $("#logusername").val();
        var pwd = $("#logpwd").val();
        $.post("/lastlySly/adminController/adminLogin.action",{"username":username,"password":pwd},function(data){
            var daa = JSON.parse(data);
            if (daa.code == "1") {
                alert(daa.tip);
                window.location.href="add-article.html";
            } else{
                alert(daa.tip);
            }
        })
    }
}
