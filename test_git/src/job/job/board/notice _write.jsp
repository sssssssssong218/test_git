<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page info=""%>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=1200, user-scalable=no">
    <meta http-equiv="imagetoolbar" content="no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>공지사항 - 글쓰기</title>
    <link rel="stylesheet" href="https://www.ncyok.or.kr:443/theme/basic/css/default.css?ver=1697644684">
    <link rel="stylesheet" href="https://www.ncyok.or.kr:443/skin/board/basic/style.css">
    <!--[if lte IE 8]>
    <script src="https://www.ncyok.or.kr:443/js/html5.js"></script>
    <![endif]>
    <script>
        // 자바스크립트에서 사용하는 전역변수 선언
        var g5_url       = "https://www.ncyok.or.kr:443";
        var g5_bbs_url   = "https://www.ncyok.or.kr:443/bbs";
        var g5_is_member = "1";
        var g5_is_admin  = "";
        var g5_is_mobile = "";
        var g5_bo_table  = "5025";
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
<div id="hd_login_msg">니크닉님 로그인 중 <a href="https://www.ncyok.or.kr:443/bbs/logout.php">로그아웃</a></div>
<link rel="stylesheet" href="https://www.ncyok.or.kr:443/theme/basic/css/sub.css">
<!-- 상단 끝 -->
<hr>
<div id="wrapper">
    <div class="wrap">
        <div id="container">
            <!--div class="conTit_tt">
                <span>
                    청소년 마당
                </span>
            </div-->
            <div class="scontA">
                <!-- 서브상단 이미지 및 로케이션 단 시작 -->
                <div id="sVisualA" class="svbgc0 svbg_1050">
                    <div class="svisTxt">
                        <span></span>
                        <p></p>
                    </div>
                    <div id="container_title">
                        <div class="conTit_tt">
                            <span>공지사항</span>
                        </div>
                    </div>
                    <script>
                        $('.btn_print').on('click', function () {
                            $('#container').printThis();
                        })
                    </script>
                </div>
                <!-- 서브상단 이미지 및 로케이션 단 끝 -->
                <!-- 게시물 작성/수정 시작 -->
                <section id="bo_w">
                    <h2 id="container_title">청소년 마당 글쓰기</h2>
                    <form name="fwrite" id="fwrite" action="https://www.ncyok.or.kr:443/bbs/write_update.php"
                        onsubmit="return fwrite_submit(this);" method="post" enctype="multipart/form-data" autocomplete="off"
                        style="width:100%">
                        <input type="hidden" name="uid" value="23101900580438">
                        <input type="hidden" name="w" value="">
                        <input type="hidden" name="bo_table" value="5025">
                        <input type="hidden" name="wr_id" value="0">
                        <input type="hidden" name="sca" value="">
                        <input type="hidden" name="sfl" value="">
                        <input type="hidden" name="stx" value="">
                        <input type="hidden" name="spt" value="">
                        <input type="hidden" name="sst" value="">
                        <input type="hidden" name="sod" value="">
                        <input type="hidden" name="page" value="">
                        <input type="hidden" value="html1" name="html">
                        <div class="tbl_frm01 tbl_wrap">
                            <table>
                                <tbody>
                                    <tr>
                                        <th scope="row"><label for="wr_subject">구분<strong class="sound_only">필수</strong></label>
                                        </th>
                                        <td>
                                            <div id="autosave_wrapper">
                                                <select>
                                                    <option>===구분===</option>
                                                    <option>공지사항</option>
                                                    <option>뉴스</option>
                                                    <option>자주 찾는 질문</option>
                                                </select>
                                                <script src="https://www.ncyok.or.kr:443/js/autosave.js"></script>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th scope="row"><label for="wr_subject">제목<strong
                                                class="sound_only">필수</strong></label></th>
                                        <td>
                                            <div id="autosave_wrapper">
                                                <input type="text" name="wr_subject" value="" id="wr_subject" required=""
                                                    class="frm_input required" size="80" maxlength="255">
                                                <script src="https://www.ncyok.or.kr:443/js/autosave.js"></script>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th scope="row"><label for="wr_content">내용<strong class="sound_only">필수</strong></label>
                                        </th>
                                        <td class="wr_content">
                                            <span class="sound_only">웹에디터 시작</span>
                                            <div class="cke_sc"></div>
                                            <script
                                                src="https://www.ncyok.or.kr:443/plugin/editor/smarteditor2/js/HuskyEZCreator.js">
                                            </script>
                                            <script>
                                                var g5_editor_url = "https://www.ncyok.or.kr:443/plugin/editor/smarteditor2";
                                                var oEditors = [];
                                                var ed_nonce = "361cffd816";
                                            </script>
                                            <script
                                                src="https://www.ncyok.or.kr:443/plugin/editor/smarteditor2/config.js">
                                            </script>
                                            <script>
                                                $(function () {
                                                    $(".btn_cke_sc").click(function () {
                                                        if ($(this).next("div.cke_sc_def").length) {
                                                            $(this).next("div.cke_sc_def").remove();
                                                            $(this).text("단축키 일람");
                                                        } else {
                                                            $(this).after("<div class='cke_sc_def' />").next("div.cke_sc_def").load(
                                                                "https://www.ncyok.or.kr:443/plugin/editor/smarteditor2/shortcut.html");
                                                            $(this).text("단축키 일람 닫기");
                                                        }
                                                    });
                                                    $(document).on("click", ".btn_cke_sc_close", function () {
                                                        $(this).parent("div.cke_sc_def").remove();
                                                    });
                                                });
                                            </script>
                                            <textarea id="wr_content" name="wr_content" class="smarteditor2" maxlength="65536"
                                                style="width: 100%; height: 300px; display: none;"></textarea>
                                            <iframe frameborder="0" scrolling="no" style="width: 100%; height: 327px;"
                                                src="https://www.ncyok.or.kr:443/plugin/editor/smarteditor2/SmartEditor2Skin.html"></iframe>
                                            <span class="sound_only">웹 에디터 끝</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th scope="row">파일첨부 관련안내</th>
                                        <td>
                                            * 한 파일당 1MB (1,024kb) 이내 <br>
                                            * 작성일 기준 3개월 뒤 관리자가 첨부파일을 삭제 할수 있습니다.
                                            (서버 용량 문제로 인한 양해부탁드립니다.)
                                        </td>
                                    </tr>
                                    <tr>
                                        <th scope="row">파일 #1</th>
                                        <td>
                                            <input type="file" name="bf_file[]"
                                                title="파일첨부 1 : 용량 1,048,576 바이트 이하만 업로드 가능"
                                                class="frm_file frm_input">
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="btn_confirm">
                            <input type="submit" value="작성완료" id="btn_submit" accesskey="s" class="btn_submit">
                            <a href="./board.php?bo_table=5025" class="btn_cancel">취소</a>
                        </div>
                    </form>
                    <script>
                        function html_auto_br(obj) {
                            if (obj.checked) {
                                result = confirm("자동 줄바꿈을 하시겠습니까?\n\n자동 줄바꿈은 게시물 내용중 줄바뀐 곳을<br>태그로 변환하는 기능입니다.");
                                if (result)
                                    obj.value = "html2";
                                else
                                    obj.value = "html1";
                            } else
                                obj.value = "";
                        }

                        function fwrite_submit(f) {
                            var wr_content_editor_data = oEditors.getById['wr_content'].getIR();
                            oEditors.getById['wr_content'].exec('UPDATE_CONTENTS_FIELD', []);
                            if (jQuery.inArray(document.getElementById('wr_content').value.toLowerCase().replace(/^\s*|\s*$/g, ''), ['&nbsp;', '<p>&nbsp;</p>', '<p><br></p>', '<div><br></div>', '<p></p>', '<br>', '']) != -1) {
                                document.getElementById('wr_content').value = '';
                            }
                            if (!wr_content_editor_data || jQuery.inArray(wr_content_editor_data.toLowerCase(), ['&nbsp;', '<p>&nbsp;</p>', '<p><br></p>', '<p></p>', '<br>']) != -1) {
                                alert("내용을 입력해 주십시오.");
                                oEditors.getById['wr_content'].exec('FOCUS');
                                return false;
                            }
                            var subject = "";
                            var content = "";
                            $.ajax({
                                url: g5_bbs_url + "/ajax.filter.php",
                                type: "POST",
                                data: {
                                    "subject": f.wr_subject.value,
                                    "content": f.wr_content.value
                                },
                                dataType: "json",
                                async: false,
                                cache: false,
                                success: function (data, textStatus) {
                                    subject = data.subject;
                                    content = data.content;
                                }
                            });
                            if (subject) {
                                alert("제목에 금지단어('" + subject + "')가 포함되어있습니다");
                                f.wr_subject.focus();
                                return false;
                            }
                            if (content) {
                                alert("내용에 금지단어('" + content + "')가 포함되어있습니다");
                                if (typeof (ed_wr_content) != "undefined")
                                    ed_wr_content.returnFalse();
                                else
                                    f.wr_content.focus();
                                return false;
                            }
                            if (document.getElementById("char_count")) {
                                if (char_min > 0 || char_max > 0) {
                                    var cnt = parseInt(check_byte("wr_content", "char_count"));
                                    if (char_min > 0 && char_min > cnt) {
                                        alert("내용은 " + char_min + "글자 이상 쓰셔야 합니다.");
                                        return false;
                                    } else if (char_max > 0 && char_max < cnt) {
                                        alert("내용은 " + char_max + "글자 이하로 쓰셔야 합니다.");
                                        return false;
                                    }
                                }
                            }
                            document.getElementById("btn_submit").disabled = "disabled";
                            return true;
                        }
                    </script>
                </section>
                <!-- 게시물 작성/수정 끝 -->
            </div>
        </div>
    </div>
</div>
<!-- 하단 끝 -->
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
</body>
</html>
