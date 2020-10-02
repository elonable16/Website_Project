<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Kufam:wght@600&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script src = "${pageContext.request.contextPath}/dropdown_menu.js"></script>
<script src = "${pageContext.request.contextPath}/banner_change.js"></script>
<link rel="stylesheet" href ="${pageContext.request.contextPath}/CSS/Login.css">
<meta charset="UTF-8">
<title>ElocuenTe</title>
<script>
	$(document).ready(function(){
		$('.logininput').click(function(){
			$(this).val('');
		});
	});
	$(document).ready(function(){
		if("${error}"!=null){
			if("${error}"==1){
				alert("아이디/패스워드가 틀렸습니다.");
			}else if("${error}"==2){
				alert("중복된 아이디 입니다.");
			}
		}
	});
	$(document).ready(function(){
		if("${param.notice}"!=null){
			if("${param.notice}"==1){
				alert("회원가입되었습니다.");
			}
		}
	});
	function validate(){
		var name = document.getElementById("name");
		var email = document.getElementById("email");
		var phone = document.getElementById("phone");
		
		if(isName(name.value)==false){
			alert("이름을 영문 또는 한글로 작성해주세요.");
			name.focus();
			return false;
		}
		if(isMobile(phone.value)==false){
			alert("숫자를 -/공백 없이 작성해주세요."+"\n"+"ex)01011112222");
			phone.focus();
			return false;
		}
		if(emailCheck(email.value)==false){
			alert("이메일 형식이 잘못되었습니다.");
			email.focus();
			return false;
		}
		return true;
	};
	
	function isName(Name) { 
		var regExp =/^[가-힣a-zA-Z\s]+$/; 
		if(regExp.test(Name)){ 
			return true;
		}else {
			return false; 
		}
	};
	
	function isMobile(phoneNum) { 
		var regExp =/(01[016789])([0-9]{1}[0-9]{2,3})([0-9]{4})$/;
		if(regExp.test(phoneNum)){ 
			return true;
		}else {
			return false; 
		}
	};
	
	function emailCheck(email) { 
		var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/; 
		if(exptext.test(email) == false) { 
			// 이메일 형식이 아닐경우
			return false; 
		}
		return true; 
	};
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
            <div id = "contents_left">
                <div id = Sign_in>
                    <p>SIGN IN</p>
                    <form action ="LoginServlet" method="post">
                    <input type="hidden" name = "cmd" value="loginOk">
                        <p><input class="logininput" type="text" name = "id" value="ID" ></p>
                        <p><input class="logininput" type="password" name = "passwd" value="PASSWORD"></p>
                        <p><a id="passwd_Finder" href="#">Find password</a></p>
                        <p><input type="submit" value = "SIGN IN"></p>
                    </form>
                </div>
            </div>
            <div id = "contents_right">
                <div id = Sign_up>
                    <p>CREATE AN ACCOUNT</p>
                    <form action="LoginServlet" method="post" onsubmit="return validate();">
                    	<input type="hidden" name ="cmd" value="signup">
                    	<c:choose>
	                    	<c:when test="${error eq '2'}">
		                        <p><input class="logininput" type="text" name = "id" value="${param.id}"></p>
		                        <p><input class="logininput" type="password" name = "passwd" value="${param.passwd}"></p>
		                        <p><input class="logininput" id="name" type="text" name = "u_name" value="${param.u_name}"></p>
		                        <p><input class="logininput" id="phone" type="text" name = "phone"  value="${param.phone}"></p>
		                        <p><input class="logininput" id="email" type="text" name = "email"  value="${param.email}" ></p>
		                    </c:when>
		                    <c:otherwise>
		                        <p><input class="logininput" type="text" name = "id" value="ID"></p>
		                        <p><input class="logininput" type="password" name = "passwd" value="PASSWORD"></p>
		                        <p><input class="logininput" id="name" type="text" name = "u_name" value="NAME"></p>
		                        <p><input class="logininput" id="phone" type="text" name = "phone" value="PHONE"></p>
		                        <p><input class="logininput" id="email" type="text" name = "email" value="E-mail" ></p>
	                        </c:otherwise>
                        </c:choose>
                        <p><input type="submit" value = "SIGN UP"></p>
                        <p>By clicking here. I agree to the <a href="">privacy policy</a> and terms and condition provided by 0000</p>
                    </form>
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