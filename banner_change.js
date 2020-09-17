var bn_count = 99;
function banner_change_left(){
    if(bn_count==3){
        bn_count=99;
    }
    var src;
    bn_count--;
    src = "./img/banner" + (bn_count%3+1) + ".jpeg"
    $('.main_banner').attr("src",src);
    
}
function banner_change_right(){
    var src;
    bn_count++;
    src = "./img/banner" + (bn_count%3+1) + ".jpeg"
    $('.main_banner').attr("src",src);
}