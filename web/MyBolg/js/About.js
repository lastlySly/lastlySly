
$(function () {
    $(".head").load("common.html header");
    $(".custom-footer").load("common.html footer");
    custom_aboutpro();
})


function custom_aboutpro() {
    var str = "<p>在这几年里，我光顾着低头前行，只想着得到那无法得到的东西，但是又不知道那究竟是什么。</p>\n" +
        "                            <p>而这个不知从何而来的想法逐渐地变成一种压迫，让我只能靠不停工作来解脱。\n" +
        "                                等我惊觉之时，逐渐僵硬的心只能感觉到痛苦。</p>\n" +
        "                            <p>然后在某一天的早晨，我察觉到那曾经如此真切的情感，就这样干干净净地消失殆尽。\n" +
        "                                时间带着鲜明的恶意，从我身上慢慢流走；我深知，这以后的将来，我们无法一起走过。\n" +
        "                            </p>\n" +
        "                            <p>\n" +
        "                                对于命途多舛的人生，以及渺茫的时间，阻隔在我们之间的这一事实，我们无可奈何。\n" +
        "                                如果樱花飘落的速度是每秒5厘米的话，那两颗心要多久才能靠近？\n" +
        "                            </p>";
    $("#custom-about-pro").append(str);
}