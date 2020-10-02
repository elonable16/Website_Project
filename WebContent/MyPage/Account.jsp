<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Kufam:wght@600&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script src = "${pageContext.request.contextPath}/dropdown_menu.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/account.css">
<title>Insert title here</title>
<script>
        function chk_pay(num){
            $('input:radio[name=how_pay]').attr("checked",false);
            $('input:button.pay').css({'backgroundColor':'black',color:"white"});
            switch(num){
                case "1": $('input:radio[name=how_pay]:input[value=card]').attr("checked",true);
                        $('input:button.card_btn').css({"backgroundColor":"#dddddd",color:"black"});
                        
                    break;
                case "2": $('input:radio[name=how_pay]:input[value=deposit]').attr("checked",true);
                        $('input:button.depo_btn').css({"backgroundColor":"#dddddd",color:"black"});
                    break;
                case "3": $('input:radio[name=how_pay]:input[value=phone]').attr("checked",true);
                        $('input:button.pho_btn').css({"backgroundColor":"#dddddd",color:"black"});
                    break;
                case "4": $('input:radio[name=how_pay]:input[value=b_transfer]').attr("checked",true);
                        $('input:button.trans_btn').css({"backgroundColor":"#dddddd",color:"black"});
                    break;
                default: break; 
            }
        }
    </script>
</head>
<body>
<div id = "header">
        <div id = header_deco>
            <p>Welcome to website</p>
        </div>
        <div id = "main_header">
            <div id = "header_title">
                <p><a href="./HomeServlet?cmd=main">ElocuenTe</a></p>
            </div>
            <div id = "go_home">
                <a href="./HomeServlet?cmd=main"><img src="./" alt="">home</a>
            </div>
            <div id = "person_nav">
                <ul>
                	<c:choose>
		                <c:when test="${empty sessionScope.id}">
	                    	<li><a href="./LoginServlet?cmd=loginform">Sign in</a></li>
	                    </c:when>
	                    <c:otherwise>
		                	<li><a href="./LoginServlet?cmd=logout">Logout</a></li>
		                </c:otherwise>
                	</c:choose>
                    <li><a href="./MyPage/myPage.jsp">My page</a></li>
                </ul>
            </div>
            <div id="main_gnb">
                <ul>
                    <li><a class="intro" href="./InfoServlet?cmd=operation">기업소개</a></li>
                    <li><a class="business" href="./InfoServlet?cmd=business">사업소개</a></li>
                    <li><a class="shop" href="./ShopServlet?cmd=shop_bestlist">BEST</a></li>
                    <li><a class="shop" href="./ShopServlet?cmd=shop_salelist">SALE</a></li>
                    <li><a class="shop" href="./ShopServlet?cmd=shop_list&p_class=0">SHOP</a></li>
                    <li><a class="cs" href="#">고객지원</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div id = "contents">
        <div id = "dropdown_menu">
            <div id = menu_item1>
                <div id ="intro_items">
                    <p><a href="./InfoServlet?cmd=operation"> 경영철학 </a></p>
                    <p><a href="./InfoServlet?cmd=value"> 핵심가치 </a></p>
                    <p><a href="./InfoServlet?cmd=vision"> 비&nbsp&nbsp전 </a></p>
                </div>
            </div>
            <div id = menu_item2>
                <div id = "business_items">
                    <p><a href="./InfoServlet?cmd=business"> 본&nbsp&nbsp사 </a></p>
                    <p><a href="./InfoServlet?cmd=factory"> 공&nbsp&nbsp장 </a></p>
                    <p><a href="./InfoServlet?cmd=research"> 연 구 소 </a></p>
                </div>
            </div>
            <div id = menu_item3>
                <div id = "shop_items">
                    <p><a href="./ShopServlet?cmd=shop_salelist"> SALE </a></p>
                    <p><a href="./ShopServlet?cmd=shop_list&p_class=200"> SHOES </a></p>
                    <p><a href="./ShopServlet?cmd=shop_list&p_class=300"> CLOTHES </a></p>
                    <p><a href="./ShopServlet?cmd=shop_list&p_class=100"> PANTS </a></p>
                    <p><a href="./ShopServlet?cmd=shop_list&p_class=400"> OUTER </a></p>
                    <p><a href="./ShopServlet?cmd=shop_bestlist"> BEST </a></p>
                </div>
            </div>
            <div id = menu_item4>
                <div id = cs_items>
                    <p><a href="#"> 공지사항 </a></p>
                    <p><a href="#"> Q n A </a></p>
                    <p><a href="#"> 게 시 판 </a></p>
                </div>
            </div>
        </div>
        <div id = "main_contents">
            <div id = "payment_contents">
                <div id = "payment_title">
                    <p>결제하기</p>
                </div>
                
                <form action="./guestbook.html" method="post">
                    <div id = "payment_receiver_info">
                        <div class = "payment_title_txt">
                            <div><span>받는 분 정보</span></div>
                        </div>
                        
                        <div id = "payment_contents_box">
                            <div class = "payment_table" >
                                <table>
                                    <tr class="table_rows1">
                                        <td class="table_col1">
                                            <p>이름</p>
                                            <p>전화번호</p>
                                            <p>주소</p>
                                        </td>
                                        <td class="table_col2">
                                            <p><input type="text" name = "rc_name" style="width: 85px;"></p>
                                            <p>
                                                <input type="text" name = "rc_phone" maxlength="3" style="width: 30px;">
                                                -<input type="text" name = "rc_phone2" maxlength="4"style="width: 40px;">
                                                -<input type="text" name = "rc_phone3"maxlength="4"style="width: 40px;">
                                            </p>
                                            <p><input type="text" name = "rc_addr" style="width: 400px;"></p>
                                        </td>
                                    </tr>
                                    <tr class="table_rows2">
                                        <td class="table_col1">
                                            <p>택배배송 요청사항</p>
                                        </td>
                                        <td class="table_col2">
                                            <p><input type="text" name = "rc_cmt" style="width: 400px;"></p>
                                        </td>
                                    </tr>
                                    <tr class="table_rows3">
                                        <td class="table_col1">
                                            <p>주문자명</p>
                                            <p>주문자 이메일</p>
                                        </td>
                                        <td class="table_col2">
                                            <p><input type="text" name = "s_name" style="width: 85px;"></p>
                                            <p><input type="text" name = "s_email" style="width: 300px;"></p>
                                        </td>
                                    </tr>
                                </table>
                            
                            </div>
                        </div>
                    </div>
                    <div id = "payment_cart">
                        <div class = "payment_title_txt">
                            <div><span>주문상품</span></div>
                        </div>
                        <div id = "payment_contents_box">
                            <div class = "payment_cart_table" >
                                <table>
                                    <tr class = "table_cart_header">
                                        <td class = "table_cart_contents1">번호</td>
                                        <td class = "table_cart_contents2">이미지</td>
                                        <td class = "table_cart_contents3">제품명</td>
                                        <td class = "table_cart_contents4">수량</td>
                                        <td class = "table_cart_contents5">가격</td>
                                    </tr>
                                    <tr class = "table_cart_body_contents">
                                        <td class ="table_cart_contents1">1</td>
                                        <td class ="table_cart_contents2"><img src="http://placeimg.com/50/50/clothes"></td>
                                        <td class ="table_cart_contents3">1</td>
                                        <td class ="table_cart_contents4">1</td>
                                        <td class ="table_cart_contents5">1</td>
                                    </tr>
                                    <tr class = "table_cart_body_contents">
                                        <td class ="table_cart_contents1">1</td>
                                        <td class ="table_cart_contents2"><img src="http://placeimg.com/50/50/clothes"></td>
                                        <td class ="table_cart_contents3">1</td>
                                        <td class ="table_cart_contents4">1</td>
                                        <td class ="table_cart_contents5">1</td>
                                    </tr>
                                    
                                    <tr class="table_cart_total">
                                        <td colspan="3" class="table_cart_content_big">총계</td>
                                        <td class ="table_cart_contents4">4</td>
                                        <td class ="table_cart_contents5">000000</td>
                                    </tr>
                                </table>
                                
                            </div>
                        </div>
                    </div>
                    <div id = "payment_method">
                        <div class = "payment_title_txt">
                            <div><span>결제 수단</span></div>
                        </div>
                        <div id = "payment_contents_box">
                            <div class = "payment_table" >
                                <input class="how_pay" type="radio" name="how_pay" value="card">
                                <input class="how_pay" type="radio" name="how_pay" value="deposit">
                                <input class="how_pay" type="radio" name="how_pay" value="phone">
                                <input class="how_pay" type="radio" name="how_pay" value="b_transfer">
                                <input type="button" class="card_btn pay" onclick="chk_pay('1')" value="신용카드">
                                <input type="button" class="depo_btn pay" onclick="chk_pay('2')" value="무통장 입금">
                                <input type="button" class="pho_btn pay" onclick="chk_pay('3')" value="휴대폰">
                                <input type="button" class="trans_btn pay" onclick="chk_pay('4')" value="실시간 계좌이체">
                            </div>
                        </div>
                    </div>
                    <div id = payment_ok>
                        <div>
                            <input type="submit" value="결제하기">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div id = "footer">
        <div id = "main_footer">
            <div id="sub_info">
                <div id="sub_link">
                    <ul>
                        <li><a href="#">사이트맵</a></li>
                        <li><a href="#">저작권 안내</a></li>
                        <li><a href="#">이용약관</a></li>
                    </ul>
                </div>
                <div>
                    <p class="subinfo_text">고객센터 : 041-000-0000</p>
                </div>
                <div>
                    <p class="subinfo_text"> © 2020 elon All Rights Reserved</p>
                </div>
            </div>
            <div id="footer_title">
                <p>ElocuenTe</p>
            </div>
        </div>
    </div>
</body>
</html>