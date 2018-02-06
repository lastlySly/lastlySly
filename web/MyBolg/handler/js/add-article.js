
$(function(){

    var isLogin = $.cookie("admin");
    if(isLogin != null){
        $("#custom-user").text(isLogin);
    }else{
        alert("请先登录");
        window.location.href = "AdminLogin.html";
    }


    $('#edit').froalaEditor({
        language: 'zh_cn',
        height: 200,
        imageUpload: true,
        imageUploadMethod :'POST',
        imageUploadURL :'/lastlySly/adminController/uploadImgEditor.action',
        imageManagerDeleteURL :'/lastlySly/adminController/deleteImg.action'
    });

    custom_getdate();
    setInterval( custom_getdate,1000);
    getCategory();
});

/*获取系统当前时间*/
function custom_getdate() {
    var date1 = new Date();
    var y = date1.getFullYear();
    var m = date1.getMonth()+1;
    var d = date1.getDate();
    var h = date1.getHours();
    var f = date1.getMinutes();
    var s = date1.getSeconds();

    if (m<10) {
        m = ""+"0"+m;
    }
    if (d<10) {
        d = ""+"0"+d;
    }
    if (h<10) {
        h = ""+"0"+h;
    }
    if (f<10) {
        f = ""+"0"+f;
    }
    if (s<10) {
        s = ""+"0"+s;
    }
    var datetime = y + "-" + m + "-" + d + " "+ h + ":" + f + ":" + s;
    $("#pubdate").text(datetime);

}
/*获取系统当前时间End*/

/*获取栏位，分类*/
function getCategory() {
    // var arr = new Array("前端技术","后端技术","异常处理");
    //
    // $("#categorys").empty();
    // for (var i = 0;i<arr.length;i++){
    //     $("#categorys").append('<li><label>' +
    //         '<input type="radio" name="category" value="'+i+'">' + arr[i] +
    //         '<span><small>（栏目ID：'+ i +'）</small></span>' +
    //         '</label></li>');
    // }

    $.post("/lastlySly/adminController/getCategory.action",{},function (data) {
        // data = JSON.parse(data);
        console.log(data)
        if(data.code == 1){
            $("#categorys").empty();
            for (var i = 0;i<data.data.length;i++){
                $("#categorys").append('<li><label>' +
                    '<input type="radio" name="category" value="'+data.data[i].categoryid+'">' + data.data[i].category +
                    '<span><small>（栏目ID：'+ data.data[i].categoryid +'）</small></span>' +
                    '</label></li>');
            }
        }else if(data.code == 2){
            $("#categorys").empty();
            $.append('<li>暂无分类</li>');
        }else{
            alert(data.tip())
        }
    });
}
/*获取栏位，分类End*/

/*添加文章*/
function AddarticleFun() {

    /*文章上传*/
    function Addarticle() {
        // img_upload();
        $("#pub_btn").click(function () {
            var article_title = $("#article_title").val();
            var article_describe = $("#describe").val();
            var article_content = $("#edit").froalaEditor('html.get');

            // document.write("<script src=''></script>");

            var keyword = $("#keyword").val();
            var category = $('#categorys input[name="category"]:checked ').val();
            var tags = $("#tags").val();

            //获取文件二进制流
            var formdata = new FormData($("#img_form")[0]);
            var pubdate = $("#pubdate").text();

            // console.log(article_title + " " + article_describe + " " +article_content + " " +
            // keyword + " " + category + " " + tags + " "  + " " + pubdate);
            formdata.append("article_title",article_title);
            formdata.append("pubdate",pubdate);
            formdata.append("article_describe",article_describe);
            formdata.append("article_content",article_content);
            formdata.append("keyword",keyword);
            formdata.append("category",category);
            formdata.append("tags",tags);

            $.ajax({
                url: '/lastlySly/adminController/addArticle.action',
                type: 'POST',
                data: formdata,
                async: true,//异步请求
                // cache: false,缓存，get请求有效，true缓存
                contentType: false,
                processData: false,
                success: function (data) {
                    if(data.code == 1){
                        alert(data.tip)
                    }else{
                        alert(data.tip);
                    }
                },
                error: function (err) {
                    alert(err);
                }
            });

            // $.post("/lastlySly/adminController/addArticle.action",imgformdata,{"article_title":article_title,"article_describe":article_describe,
            //     "article_content":article_content,"keyword":keyword,"category":category,
            //     "tags":tags,"title_img":imgdata,"pubdate":pubdate},function (data) {
            //     // data = JSON.parse(data);
            //     if(data.code == 1){
            //         alert(data.tip)
            //     }else{
            //         alert(data.tip)
            //     }
            // });
        })
    }
    Addarticle()
    /*文章上传End*/
}
AddarticleFun();
/*添加文章End*/