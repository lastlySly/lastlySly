
$(function () {
    $(".head").load("common.html header");
    $(".custom-footer").load("common.html footer");
    article_items();
})


/*置顶文章*/
function content_top() {
    $.post("")
}
/*置顶文章End*/

/*展示处理*/
function article_items() {
    var pagecount = 8;
    var dqpage = 1;
    var articlescount = 10;
    var pagesize = 1;

    /*文章数量处理*/
    function getCount() {
        // pagecount = 6;
        $.post("/lastlySly/stageController/getArticlesCount.action",{},function (data) {
            // data = JSON.parse(data);
            // console.log(data);
            if(data.code == 1){
                // alert(data.data);
                articlescount = data.data;
                pagecount = Math.ceil(articlescount / pagesize);

                custom_paging(pagecount);
                getPage(pagecount);

            }else{
                alert(data.tip);
            }
        });
    }
    /*文章数量处理End*/

    /*分页处理*/
    getCount();

    function getPage(pagecount) {
        // alert(pagecount)
        // pagecount = 5;
        $(".custom-paging-btn").click(function () {
            /*当前页按钮*/
            /*pageclick为被点击页码*/
            var pageclick = Number($(this).text());
            $(".custom-paging-btn-choose").text(pageclick);
            /*下一页按钮*/
            var next = pageclick+1;
            if(next > pagecount){
                $(".custom-paging-btn-next").text(1);
            }else{
                $(".custom-paging-btn-next").text(next);
            }
            /*上一页按钮*/
            var prev = pageclick-1;
            if(prev < 1){
                $(".custom-paging-btn-prev").text(pagecount);
            }else{
                $(".custom-paging-btn-prev").text(prev);
            }

            sendPageIndex(pageclick);

        })
    }
    /*获取当前页文章目录*/
    function sendPageIndex(pageclick) {
       console.log(pageclick+" "+pagesize);
        $.post("/lastlySly/stageController/getArticlesCatalog.action",{"dqy":pageclick,"pagesize":pagesize},function (data) {
            if(data.code == 1){
                var len = data.data.length;
                $("#article_items").empty();
                console.log(data)
                for (var i = 0;i<len;i++){
                    var YearAndMonth = data.data[i].pubdate.split(' ');
                    // alert(YearAndMonth[0]);
                    var date = YearAndMonth[0].split("-");
                    var str = "";
                    str = '<div class="row custom-timeline-item"><div class="col-md-2 col-sm-2 col-xs-2 timeline">' +
                        '<div class="custom-time"><span class="time-circle"></span>' +
                        '<span class="custom-month-day">' + date[1] + '-' + date[2] + '</span>' +
                        '<span class="custom-year">'+date[0]+'</span> </div> </div>' +
                        ' <div class="col-md-8 col-sm-8 col-xs-8 custom-timeline-content">' +
                        ' <div class="custom-triangle"></div> <div class="row"> <div class="col-md-12 custom-title-right">' +
                        '<a href="#">'+ data.data[i].articleTitle+'</a>' +
                        ' </div> </div> <div class="row">' +
                        '<div class="col-md-4 col-sm-4 col-xs-4 custom-img-div">' +
                        '<img class="img-responsive" src="'+data.data[i].titleImgurl+'"  alt=""> </div>' +
                        '<div class="col-md-8 col-sm-8 col-xs-8">' +
                        '<span class="custom-content-div">'+ data.data[i].articleDescribe+
                        '</span>' +
                        '<div class="row">' +
                        '<div class="col-md-6 col-sm-6 col-xs-6 custom-label">'+ data.data[i].categorysheet.category +
                        '</div> <div class="col-md-4 col-md-offset-2 col-sm-4 col-sm-offset-2 col-xs-4 col-xs-offset-2">' +
                        '<input class="btn btn-default btn-block custom-btn" type="button" data-num="'+ data.data[i].articleid +'" value="阅读全文>>">' +
                        '</div></div></div></div></div></div>';

                    $("#article_items").append(str);
                    detail_btn()
                }
            }else{
                alert(data.tip);
            }
        })
    }
    /*获取当前页文章目录 End*/

    sendPageIndex(1)/*首次刷新获取文章目录*/

    /*分页处理End*/


    function detail_btn() {
        $(".custom-btn").click(function () {
            var articleid = $(this).data("num");
            location.href = "../MyBolg/Detail.html?articleid="+articleid;
        });
    }


}
/*展示处理*/

