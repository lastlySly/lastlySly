
$(function () {
    $(".head").load("common.html header");
    $(".custom-footer").load("common.html footer");
    getArticle();
})

function getArticle() {
    var lourl = location.href;
    var datt = lourl.split("=");
    // alert(datt[1]);
    $.post("/lastlySly/stageController/getArticleDetail.action",{"nid":datt[1]},function (data) {
        // data = JSON.parse(data);
        console.log(data);
        if(data.code == 1){
            $("#custom-article-title").text(data.data.articleTitle);
            $("#custom-article-date").text(data.data.pubdate);

            $("#article_content").append(data.data.articleContent);
            // $("#article_content").text(data.data.articleContent);

            var keywordArr = data.data.keyword.split(",");
            var str = "关键字词：";
            for (var i = 0;i<keywordArr.length;i++){
                str = str + keywordArr[i] + " ";
            }
            $("#keyword").text(str);
        }else{
            alert(data.tip)
        }
    })
}