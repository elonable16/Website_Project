<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Kufam:wght@600&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script src = "${pageContext.request.contextPath}/dropdown_menu.js"></script>
<script src = "${pageContext.request.contextPath}/banner_change.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/shop.css">
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
            <div id = "intro_contents_left">
                <div id = "left_nav">
                    <ul>
                        <li><a href="./ShopServlet?cmd=shop_list&p_class=0">Shop</a></li>
                        <li><a href="./ShopServlet?cmd=shop_list&p_class=200">shoes</a></li>
                        <li><a href="./ShopServlet?cmd=shop_list&p_class=300">clothes</a></li>
                        <li><a href="./ShopServlet?cmd=shop_list&p_class=100">pants</a></li>
                        <li><a href="./ShopServlet?cmd=shop_list&p_class=400">outer</a></li>
                        <li><a href="./ShopServlet?cmd=shop_salelist">Sale</a></li>
                        <li><a href="./ShopServlet?cmd=shop_bestlist">BEST</a></li>
                    </ul>
                </div>
            </div>
            <div id = "intro_contents_right">
                <div id="shop_title">
                    <p>SHOP</p>
                </div>
                <div id = "shop_main_item">
                    <a href ="#"><img src="./img/event3.jpg" width="100%" alt=""></a>
                </div>
                <div id="shop_item_list">
                    <div id = "shop_contents">
                        <c:forEach var = "item" items = "${list}">
	                        <div id = "shop_contents_itemview">
	                            <div id = "shop_item">
	                                <a href="./ShopServlet?cmd=product_view&p_code=${item.p_code}">
	                                	<img src="./shop/img/${item.p_image1}.jpg" alt="">
	                                	<div id="item_info">
	                                        <p class ="product_name">${item.p_name}</p>
	                                        <p class ="product_price">${item.p_price}</p>
	                                        <c:forEach var="i" begin ="1" end="${item.p_grade/1}">
			                            		<p class ="product_review">★</p>
				                            </c:forEach>
				                            <c:if test="${item.p_grade%1>=0.5}">
					                            	<p class ="product_review">☆</p>
				                            </c:if>
	                                    </div>
	                                </a>
	                            </div>
	                        </div>
                  		</c:forEach>
               		</div>
                    <div id= shop_item_pagenum>
	                    <c:if test="${page.startpage>1}">
							<span><a href="./ShopServlet?cmd=shop_list&p_class=${list.p_class}&pagenum=${page.startpage- page.groupsize }">◀</a></span>
						</c:if>
						<c:forEach var="i" begin="${page.startpage}" end ="${page.endpage}">
							<c:if test="${page.lastpage>=i}">
								<span><a href="./ShopServlet?cmd=shop_list&p_class=${p_class}&pagenum=${i}">${i}</a></span>
							</c:if>
						</c:forEach>
						<c:if test="${page.endpage<page.lastpage}">
							<a href="./ShopServlet?cmd=shop_list&p_class=${list.p_class}&pagenum=${page.startpage+ page.groupsize }">▶</a>
						</c:if>
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