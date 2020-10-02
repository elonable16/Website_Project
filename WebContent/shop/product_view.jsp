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
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/product_view.css">
<title>Insert title here</title>
<script>
	$(document).ready(function(){
		$('span.select_image1>a').click(function(){
			$('#product_image_item>a>img').attr("src","${pageContext.request.contextPath}/shop/img/${product.p_image1}.jpg");
		})
		$('span.select_image2>a').click(function(){
			$('#product_image_item>a>img').attr("src","${pageContext.request.contextPath}/shop/img/${product.p_image2}.jpg");
		})
		$('span.select_image3>a').click(function(){
			$('#product_image_item>a>img').attr("src","${pageContext.request.contextPath}/shop/img/${product.p_image3}.jpg");
		})
		$('span.select_image4>a').click(function(){
			$('#product_image_item>a>img').attr("src","${pageContext.request.contextPath}/shop/img/${product.p_image4}.jpg");
		})
	});
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
            <div id="contents_top">
                <div id = "contents_left">
                    <div id = "product_image">
                        <div id = "product_image_item">
                            <a href=""><img src="./shop/img/${product.p_image1}.jpg" alt=""></a>
                        </div>
                        <div id = "product_image_select">
                            <span class="select_image1"><a href="#">◦</a></span>
                            <span class="select_image2"><a href="#">◦</a></span>
                            <span class="select_image3"><a href="#">◦</a></span>
                            <span class="select_image4"><a href="#">◦</a></span>
                        </div>
                    </div>
                </div>
                <div id = "contents_right">
                    <div id = "product_contents">
                        <form action="">
                        	<c:choose>
	                        	<c:when test="${product.p_class/100 == 1}">
	                            	<p class="prod_tag">Pants</p>
	                            </c:when>
	                        	<c:when test="${product.p_class/100 == 2}">
	                            	<p class="prod_tag">Shoes</p>
	                            </c:when>
	                        	<c:when test="${product.p_class/100 == 3}">
	                            	<p class="prod_tag">Clothes</p>
	                            </c:when>
	                        	<c:when test="${product.p_class/100 == 4}">
	                            	<p class="prod_tag">Outer</p>
	                            </c:when>
                            </c:choose>
                            <p class="prod_name">${product.p_name}</p>
<!--별점체크   -->
                            <c:forEach var="i" begin ="1" end="${product.p_grade/1}">
                           		<p class ="prod_review">★</p>
                            </c:forEach>
                            <c:if test="${product.p_grade%1>=0.5}">
	                            	<p class ="prod_review">☆</p>
                            </c:if>
                            <p class="prod_price">
                            	${product.p_price}
                            </p>
<!--수량 체크   -->
                            <select name="prod_cnt" class="prod_cnt">
                            	<c:choose>
	                           		<c:when test="${product.p_stock>=15}">
		                            	<c:forEach var="i" begin="1" end="15">
		                                	<option value="${i}">${i}</option>
		                                </c:forEach>
	                               </c:when>
	                           		<c:when test="${product.p_stock>=1}">
		                            	<c:forEach var="i" begin="1" end="${product.p_stock}">
		                                	<option value="${i}">${i}</option>
		                                </c:forEach>
	                               </c:when>
	                               <c:otherwise>
	                               		<option value="0">sold out</option>
	                               </c:otherwise>
                                </c:choose>
                            </select>
                            <input type="submit" value="ADD TO CART" class="prod_cart_btn">
                        </form>
                    </div>
                </div>
            </div>
            <div id = "contents_bottom">
                <div id = "product_detail_info">
                    <P><img src="./shop/img/${product.p_detail}.jpg" width="100%"></P>
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