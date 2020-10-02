<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Kufam:wght@600&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script src = "${pageContext.request.contextPath}/dropdown_menu.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/myPage.css">
<title>Insert title here</title>
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
            <div id = "mypage_contents">
                <div id = "mypage_title">
                    <p>MY PAGE</p>
                </div>
                <div id = "mypage_cart">
                    <div class = "mypage_title_txt">
                        <div><span>장바구니</span></div>
                    </div>
                    <div id = "mypage_contents_box">
                        <div class = "mypage_cart_table" >
                        	<form action="./Account.jsp">
	                            <table>
	                                <tr class = "table_cart_header">
	                                    <td class = "table_cart_contents1">선택</td>
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
	                                
	                                <tr class="table_cart_total">
	                                    <td colspan="3" class="table_cart_content_big">총계</td>
	                                    <td class ="table_cart_contents4">4</td>
	                                    <td class ="table_cart_contents5">000000</td>
	                                </tr>
	                            </table>
	                            <input type="submit" value="주문하기" class = "buy_btn">
                            </form>
                        </div>
                    </div>
                </div>
                <div id = "mypage_delivery">
                    <div class = "mypage_title_txt">
                        <div><span>배송현황</span></div>
                    </div>
                    <div id = "mypage_contents_box">
                        <div class = "mypage_table" >
                            <table>
                                <tr class = "table_header">
                                    <td class = "table_contents1">구매일자</td>
                                    <td class = "table_contents2">제품명</td>
                                    <td class = "table_contents3">수량</td>
                                    <td class = "table_contents4">가격</td>
                                    <td class = "table_contents5">배송현황</td>

                                </tr>
                                <tr class = "table_body_contents">
                                    <td class ="table_contents1">1</td>
                                    <td class ="table_contents2">1</td>
                                    <td class ="table_contents3">1</td>
                                    <td class ="table_contents4">1</td>
                                    <td class ="table_contents5">1</td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                <div id = "mypage_recently">
                    <div class = "mypage_title_txt">
                        <div><span>최근 구매내역</span></div>
                    </div>
                    <div id = "mypage_contents_box">
                        <div class = "mypage_table" >
                            <table>
                                <tr class = "table_header">
                                    <td class = "table_contents1">구매일자</td>
                                    <td class = "table_contents2">제품명</td>
                                    <td class = "table_contents3">수량</td>
                                    <td class = "table_contents4">가격</td>
                                    <td class = "table_contents5">배송현황</td>
                                </tr>
                                <tr class = "table_body_contents">
                                    <td class ="table_contents1">1</td>
                                    <td class ="table_contents2">2</td>
                                    <td class ="table_contents3">3</td>
                                    <td class ="table_contents4">4</td>
                                    <td class ="table_contents5">5</td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
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