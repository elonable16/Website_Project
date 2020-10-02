$(document).ready(function(){
    $(".intro").hover(function(){
        $("#dropdown_menu").stop().slideDown(200);
        $("#intro_items").css("display","block");
        $("#menu_item1").css("z-index","200");
    },function(){
        $("#menu_item2").css("z-index","-100");
        $("#menu_item3").css("z-index","-100");
        $("#menu_item4").css("z-index","-100");
        $("#menu_item1").hover(function(){
            $("#dropdown_menu").css("display","block");
            $("#intro_items").show();
        },function(){
            $("#dropdown_menu").stop().slideUp(200);
            $("#intro_items").hide();
            $("#menu_item1").css("z-index","-100");
        });
    });


    $(".business").hover(function(){
        $("#dropdown_menu").stop().slideDown(200);
        $("#business_items").css("display","block");
        $("#menu_item2").css("z-index","200");
    },function(){
        $("#menu_item1").css("z-index","-100");
        $("#menu_item3").css("z-index","-100");
        $("#menu_item4").css("z-index","-100");
        $("#menu_item2").hover(function(){
            $("#dropdown_menu").css("display","block");
            $("#business_items").show()
        },function(){
            $("#dropdown_menu").stop().slideUp(200);
            $("#business_items").hide();
            $("#menu_item2").css("z-index","-100");
        });
    });


    $(".shop").hover(function(){
        $("#dropdown_menu").stop().slideDown(200);
        $("#shop_items").css("display","block");
        $("#menu_item3").css("z-index","200");
    },function(){
        $("#menu_item1").css("z-index","-100");
        $("#menu_item2").css("z-index","-100");
        $("#menu_item4").css("z-index","-100");
        $("#menu_item3").hover(function(){
            $("#dropdown_menu").css("display","block");
            $("#shop_items").show();
        },function(){
            $("#dropdown_menu").stop().slideUp(200);
            $("#shop_items").hide();
            $("#menu_item3").css("z-index","-100");
        });
    });

    
    $(".cs").hover(function(){
        $("#dropdown_menu").stop().slideDown(200);
        $("#cs_items").css("display","block");
        $("#menu_item4").css("z-index","200");
    },function(){
        $("#menu_item1").css("z-index","-100");
        $("#menu_item2").css("z-index","-100");
        $("#menu_item3").css("z-index","-100");
        $("#menu_item4").hover(function(){
            $("#dropdown_menu").css("display","block");
            $("#cs_items").show();
        },function(){
            $("#dropdown_menu").stop().slideUp(200);
            $("#cs_items").hide();
            $("#menu_item4").css("z-index","-100");
        });
    });

});