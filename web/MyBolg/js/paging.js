

/*分页按钮*/



/*生成按钮*/
function custom_paging(pagecount) {
    /*count为数据量*/
    /*pagesize为每页显示数量*/
    /*pagecount页数*/
    var str = "";
    if(pagecount==1){
        $(".custom-paging-btns").empty();
        str = '<li class="btn custom-paging-btn custom-paging-btn-choose">1</li>';
        $(".custom-paging-btns").append(str);
    }else if(pagecount==2){
        $(".custom-paging-btns").empty();
        str = '<li class="btn custom-paging-btn custom-paging-btn-choose">1</li>'+
        '<li class="btn custom-paging-btn custom-paging-btn-next">2</li>';
        $(".custom-paging-btns").append(str);
    }else{
        $(".custom-paging-btns").empty();
        str =' <li class="btn custom-paging-btn custom-paging-btn-prev">'+ pagecount +'</li>' +
            '<li class="btn custom-paging-btn custom-paging-btn-choose">1</li>' +
            '<li class="btn custom-paging-btn custom-paging-btn-next">2</li>';
        $(".custom-paging-btns").append(str);
    }

}


/*分页按钮点击事件*/
// function getPage(pagecount) {
//     // pagecount = 5;
//     $(".custom-paging-btn").click(function () {
//         /*当前页按钮*/
//         /*pageclick为被点击页码*/
//         var pageclick = Number($(this).text());
//         $(".custom-paging-btn-choose").text(pageclick);
//         /*下一页按钮*/
//         var next = pageclick+1;
//         if(next > pagecount){
//             $(".custom-paging-btn-next").text(1);
//         }else{
//             $(".custom-paging-btn-next").text(next);
//         }
//         /*上一页按钮*/
//         var prev = pageclick-1;
//         if(prev < 1){
//             $(".custom-paging-btn-prev").text(pagecount);
//         }else{
//             $(".custom-paging-btn-prev").text(prev);
//         }
//
//         sendPageIndex(pageclick);
//
//     })
// }


/*AJAX提交当前页页码到处理程序*/
// function sendPageIndex(pageclick) {
//     alert(pageclick)
//     $.post("",{"pageindex":pageclick},function (data) {
//         data = JSON.parse(data);
//         if(data.code == 1){
//
//         }else{
//             alert(data.tip);
//         }
//     })
// }


/*分页按钮End*/