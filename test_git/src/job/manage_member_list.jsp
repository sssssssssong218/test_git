<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page info="공지사항 메인" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html lang="ko"><head>
<meta charset="utf-8">
<meta name="viewport" content="width=1200, user-scalable=no">
<meta http-equiv="imagetoolbar" content="no">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>회원관리 1 페이지 | </title>
<!-- bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="https://www.ncyok.or.kr:443/theme/basic/css/default.css?ver=1697535328">
<link rel="stylesheet" href="https://www.ncyok.or.kr:443/skin/board/basic/style.css">
<!--[if lte IE 8]>
<script src="https://www.ncyok.or.kr:443/js/html5.js"></script>
<![endif]-->
<script>
// 자바스크립트에서 사용하는 전역변수 선언
var g5_url       = "https://www.ncyok.or.kr:443";
var g5_bbs_url   = "https://www.ncyok.or.kr:443/bbs";
var g5_is_member = "";
var g5_is_admin  = "";
var g5_is_mobile = "";
var g5_bo_table  = "5010";
var g5_sca       = "";
var g5_editor    = "smarteditor2";
var g5_cookie_domain = "";
</script>
<script src="https://www.ncyok.or.kr:443/js/jquery-1.8.3.min.js"></script>
<script src="https://www.ncyok.or.kr:443/js/jquery.menu.js"></script>
<script src="https://www.ncyok.or.kr:443/js/common.js"></script>
<script src="https://www.ncyok.or.kr:443/js/wrest2.js"></script>
<script src="https://www.ncyok.or.kr:443/js/printThis.js"></script>
<meta name="naver-site-verification" content="8e74a1f533fc95526c71b92c12475d0129bcdd32">
<meta name="robots" content="index,follow">
<meta name="author" content="www.ncyok.or.kr"> 
<meta name="description" content="연구 및 연수활동, 정보지원활동, 국제교류활동, 대회협력활동, 청협사이버평생교육원">
<meta name="title" content="한국청소년단체협의회">
<meta name="og:title" content="한국청소년단체협의회"> 
<meta name="og:description" content="연구 및 연수활동, 정보지원활동, 국제교류활동, 대회협력활동, 청협사이버평생교육원">
<meta property="og:image" content="/img/meta.jpg">
<link rel="canonical" href="https://ncyok.or.kr/index.php">

</head>
<body cz-shortcut-listen="true">
<div id="_overLayer_"></div>


<link rel="stylesheet" href="https://www.ncyok.or.kr:443/theme/basic/css/sub.css">

<!-- } 상단 끝 -->

<hr>


<div id="wrapper">
	<div class="wrap">
        <div id="container">
                        
             
            <!--div class="conTit_tt">
                                                        <span>
                        공지사항
                    </span>
                            </div-->

	
		<div class="scontA">
            <!--  서브상단 이미지 및 로케이션 단  시작 -->
                <div id="sVisualA" class="svbgc0 svbg_1050">

    <div class="svisTxt">
        <span></span>
        <p></p>
    </div>

    <div id="container_title">
 
        <div class="conTit_tt">
            <span>회원관리</span>
						<span style="padding-left:30px;font-size:.9em;font-weight:normal;">

						</span>

        </div>
        <div class="right_wrap">
                        				
        </div>
    </div>
    <script>
        $('.btn_print').on('click',function(){
            $('#container').printThis();				
        })
    </script>
</div>            <!--  서브상단 이미지 및 로케이션 단 끝 -->
						<!-- me_code : 105010-->
<h2 id="container_title">자유게시판<span class="sound_only"> 목록</span></h2>

<!-- 게시판 목록 시작 { -->
<div id="bo_list" style="width:100%">



 <!-- 게시판 페이지 정보 및 버튼 시작 { -->
<div class="bo_fx">

    <!-- 게시판 카테고리 시작 { -->
        <!-- } 게시판 카테고리 끝 -->



<!-- 게시판 검색 시작 { -->
    <fieldset id="bo_sch">
        <legend>게시물 검색</legend>
        <form name="fsearch" method="get">
        <input type="hidden" name="bo_table" value="5010">
        <input type="hidden" name="sca" value="">
        <input type="hidden" name="sop" value="and">
        <label for="sfl" class="sound_only">검색대상</label>
        
        <select name="sfl" id="sfl">
            <!--option value="wr_subject">제목</option>
            <option value="wr_content">내용</option-->
            <option value="wr_subject||wr_content">이름</option>
            
            <!--option value="mb_id,0">회원아이디(코)</option>
            <option value="wr_name,1">글쓴이</option>
            <option value="wr_name,0">글쓴이(코)</option-->
        </select>
        <label for="stx" class="sound_only">검색어<strong class="sound_only"> 필수</strong></label>
        <input type="text" name="stx" value="" required="" id="stx" class="frm_input required" size="15" maxlength="20" "="" placeholder="검색어를 입력해주세요">
        <input type="submit" value="검색" class="btn_search">
        </form>
    </fieldset>
<!-- } 게시판 검색 끝 -->
    <!--div id="bo_list_total">
        <span>Total 2,584건</span>
        1 페이지
    </div-->
</div>
<!-- } 게시판 페이지 정보 및 버튼 끝 -->


    <form name="fboardlist" id="fboardlist" action="./board_list_update.php" onsubmit="return fboardlist_submit(this);" method="post">
    <input type="hidden" name="bo_table" value="5010">
    <input type="hidden" name="sfl" value="">
    <input type="hidden" name="stx" value="">
    <input type="hidden" name="spt" value="">
    <input type="hidden" name="sca" value="">
    <input type="hidden" name="sst" value="wr_datetime desc">
    <input type="hidden" name="sod" value="">
    <input type="hidden" name="page" value="1">
    <input type="hidden" name="sw" value="">

    <div class="tbl_head01 tbl_wrap">
        <table>
        <caption>자유게시판 목록</caption>
        <colgroup><col class="colnum"><col class="coltit" style="width:150px"><col class="colname" style="width:250px"><col class="coldate" style="width:150px">
        </colgroup>
        <thead>
        <tr>
            <th scope="col">회원번호</th>
            <th scope="col">이름</th>
            <th scope="col">아이디</th>
            <th scope="col"><a href="/bbs/board.php?bo_table=5010&amp;sop=and&amp;sst=wr_datetime&amp;sod=desc&amp;sfl=&amp;stx=&amp;page=1">가입일</a></th>
        </tr>
        </thead>
        <tbody style="text-align:center">
            <tr class="bo_notice" bgcolor="#ffffff" onmouseover="this.style.backgroundColor='#fafafa'" onmouseout="this.style.backgroundColor='#ffffff'" style="background-color: rgb(250, 250, 250);">
            <td class="td_num">
            <strong>2584</strong></td>
            <td class="td_name sv_use"><span class="sv_member">김동동</span></td>
            <td class="td_mdm_id">hihi</td>
            <td class="td_datetime">2023-10-10</td>
            </tr>
            
            <tr class="bo_notice" bgcolor="#ffffff" onmouseover="this.style.backgroundColor='#fafafa'" onmouseout="this.style.backgroundColor='#ffffff'" style="background-color: rgb(255, 255, 255);">
            <td class="td_num">
            <strong>2583</strong></td>
            <td class="td_name sv_use"><span class="sv_member">김나나</span></td>
            <td class="td_id">abcd</td>
            <td class="td_datetime">2023-10-05</td>
            </tr>
            
            <tr class="bo_notice" bgcolor="#ffffff" onmouseover="this.style.backgroundColor='#fafafa'" onmouseout="this.style.backgroundColor='#ffffff'" style="background-color: rgb(255, 255, 255);">
            <td class="td_num">
            <strong>2582</strong></td>
            <td class="td_name sv_use"><span class="sv_member">송송송</span></td>
            <td class="td_id">song</td>
            <td class="td_datetime">2023-10-04</td>
            </tr>
            
            <tr class="bo_notice" bgcolor="#ffffff" onmouseover="this.style.backgroundColor='#fafafa'" onmouseout="this.style.backgroundColor='#ffffff'" style="background-color: rgb(255, 255, 255);">
            <td class="td_num">
            <strong>2581</strong></td>
            <td class="td_name sv_use"><span class="sv_member">송지하</span></td>
            <td class="td_id">songsong2</td>
            <td class="td_datetime">2023-09-26</td>
            </tr>
            
            <tr class="bo_notice" bgcolor="#ffffff" onmouseover="this.style.backgroundColor='#fafafa'" onmouseout="this.style.backgroundColor='#ffffff'" style="background-color: rgb(255, 255, 255);">
            <td class="td_num">
            <strong>2580</strong></td>
            <td class="td_name sv_use"><span class="sv_member">강다연</span></td>
            <td class="td_id">swing</td>
            <td class="td_datetime">2023-09-18</td>
            </tr>
            
            <tr class="bo_notice" bgcolor="#ffffff" onmouseover="this.style.backgroundColor='#fafafa'" onmouseout="this.style.backgroundColor='#ffffff'" style="background-color: rgb(255, 255, 255);">
            <td class="td_num">
            <strong>2579</strong></td>
            <td class="td_name sv_use"><span class="sv_member">박상준</span></td>
            <td class="td_id">javano</td>
            <td class="td_datetime">2023-09-12</td>
            </tr>
            
            <tr class="bo_notice" bgcolor="#ffffff" onmouseover="this.style.backgroundColor='#fafafa'" onmouseout="this.style.backgroundColor='#ffffff'" style="background-color: rgb(255, 255, 255);">
            <td class="td_num">
            <strong>2578</strong></td>
            <td class="td_name sv_use"><span class="sv_member">홍찬영</span></td>
            <td class="td_id">htmlno</td>
            <td class="td_datetime">2023-09-07</td>
            </tr>
            
            <tr class="bo_notice" bgcolor="#ffffff" onmouseover="this.style.backgroundColor='#fafafa'" onmouseout="this.style.backgroundColor='#ffffff'" style="background-color: rgb(255, 255, 255);">
            <td class="td_num">
            <strong>2577</strong></td>
            <td class="td_name sv_use"><span class="sv_member">김선경</span></td>
            <td class="td_id">jdbcno</td>
            <td class="td_datetime">2023-02-24</td>
            </tr>
            
            <tr class="" bgcolor="#ffffff" onmouseover="this.style.backgroundColor='#fafafa'" onmouseout="this.style.backgroundColor='#ffffff'" style="background-color: rgb(255, 255, 255);">
            <td class="td_num">
            <strong>2576</strong>
            </td><td class="td_name sv_use"><span class="sv_member">서효민</span></td>
            <td class="td_id">javascript</td>
            <td class="td_datetime">2023-09-12</td>
            </tr>
            
            <tr class="" bgcolor="#ffffff" onmouseover="this.style.backgroundColor='#fafafa'" onmouseout="this.style.backgroundColor='#ffffff'" style="background-color: rgb(255, 255, 255);">
            <td class="td_num">
            <strong>2575</strong>
            </td><td class="td_name sv_use"><span class="sv_member">이승우</span></td>
            <td class="td_id">byebye</td>
            <td class="td_datetime">2023-09-01</td>
            </tr>
            
            <tr class="" bgcolor="#ffffff" onmouseover="this.style.backgroundColor='#fafafa'" onmouseout="this.style.backgroundColor='#ffffff'" style="background-color: rgb(255, 255, 255);">
            <td class="td_num">
            <strong>2574</strong>
            </td><td class="td_name sv_use"><span class="sv_member">차준식</span></td>
            <td class="td_id">where</td>
            <td class="td_datetime">2023-08-07</td>
            </tr>
                                
            <tr class="" bgcolor="#ffffff" onmouseover="this.style.backgroundColor='#fafafa'" onmouseout="this.style.backgroundColor='#ffffff'" style="background-color: rgb(255, 255, 255);">
            <td class="td_num">
            <strong>2573</strong>
            </td><td class="td_name sv_use"><span class="sv_member">이동원</span></td>
            <td class="td_id">are</td>
            <td class="td_datetime">2023-07-14</td>
            </tr>
            
            <tr class="" bgcolor="#ffffff" onmouseover="this.style.backgroundColor='#fafafa'" onmouseout="this.style.backgroundColor='#ffffff'" style="background-color: rgb(255, 255, 255);">
            <td class="td_num">
            <strong>2572</strong>
            </td><td class="td_name sv_use"><span class="sv_member">임태균</span></td>
            <td class="td_id">you</td>
            <td class="td_datetime">2023-07-07</td>
            </tr>
                                
            <tr class="" bgcolor="#ffffff" onmouseover="this.style.backgroundColor='#fafafa'" onmouseout="this.style.backgroundColor='#ffffff'" style="background-color: rgb(255, 255, 255);">
            <td class="td_num">
            <strong>2571</strong>
            </td><td class="td_name sv_use"><span class="sv_member">정민교</span></td>
            <td class="td_id">from</td>
            <td class="td_datetime">2023-07-07</td>
            </tr>
            
            <tr class="" bgcolor="#ffffff" onmouseover="this.style.backgroundColor='#fafafa'" onmouseout="this.style.backgroundColor='#ffffff'" style="background-color: rgb(255, 255, 255);">
            <td class="td_num">
            <strong>2570</strong>
            </td><td class="td_name sv_use"><span class="sv_member">곽우신</span></td>
            <td class="td_id">okay</td>
            <td class="td_datetime">2023-07-07</td>
            </tr>
            
        </tbody>
        </table>
    </div>

        </form>
</div>







<!-- 페이지 -->
<nav class="pg_wrap"><span class="pg"><span class="sound_only">열린</span><strong class="pg_current">1</strong><span class="sound_only">페이지</span>
<a href="./board.php?bo_table=5010&amp;page=2" class="pg_page">2<span class="sound_only">페이지</span></a>
<a href="./board.php?bo_table=5010&amp;page=3" class="pg_page">3<span class="sound_only">페이지</span></a>
<a href="./board.php?bo_table=5010&amp;page=4" class="pg_page">4<span class="sound_only">페이지</span></a>
<a href="./board.php?bo_table=5010&amp;page=5" class="pg_page">5<span class="sound_only">페이지</span></a>
<a href="./board.php?bo_table=5010&amp;page=6" class="pg_page">6<span class="sound_only">페이지</span></a>
<a href="./board.php?bo_table=5010&amp;page=7" class="pg_page">7<span class="sound_only">페이지</span></a>
<a href="./board.php?bo_table=5010&amp;page=8" class="pg_page">8<span class="sound_only">페이지</span></a>
<a href="./board.php?bo_table=5010&amp;page=9" class="pg_page">9<span class="sound_only">페이지</span></a>
<a href="./board.php?bo_table=5010&amp;page=10" class="pg_page">10<span class="sound_only">페이지</span></a>
<a href="./board.php?bo_table=5010&amp;page=11" class="pg_page pg_next">다음</a>
<a href="./board.php?bo_table=5010&amp;page=173" class="pg_page pg_end">맨끝</a>
</span></nav>


<!-- } 게시판 목록 끝 -->
    </div>
		</div>
    </div>
</div>

<!-- } 콘텐츠 끝 -->

<hr>

<!-- 하단 시작 { -->








<!-- } 하단 끝 -->

<script>
$(function() {
    // 폰트 리사이즈 쿠키있으면 실행
    //font_resize("container", get_cookie("ck_font_resize_rmv_class"), get_cookie("ck_font_resize_add_class"));
});
</script>



<!-- ie6,7에서 사이드뷰가 게시판 목록에서 아래 사이드뷰에 가려지는 현상 수정 -->
<!--[if lte IE 7]>
<script>
$(function() {
    var $sv_use = $(".sv_use");
    var count = $sv_use.length;

    $sv_use.each(function() {
        $(this).css("z-index", count);
        $(this).css("position", "relative");
        count = count - 1;
    });
});
</script>
<![endif]-->








</body></html>