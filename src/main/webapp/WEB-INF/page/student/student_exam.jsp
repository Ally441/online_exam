<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width">
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7">
    <title>${exam.examName}考试</title>
    <meta name="description" content="C语言">
    <link href="/css/base.css" rel="stylesheet" type="text/css">
    <link href="/css/mcen-top.css" rel="stylesheet" type="text/css">
    <link href="/css/main.css" rel="stylesheet" type="text/css">
    <link href="/css/tk_navleft.css" rel="stylesheet" type="text/css">
    <link href="/css/side2.css" rel="stylesheet" type="text/css">
    <link href="/css/practice.css" rel="stylesheet" type="text/css">
    <link href="/css/p_dis.css" rel="stylesheet" type="text/css">
    <link href="/css/moni-paper.css" rel="stylesheet" type="text/css">
    <link href="/css/ui-dialog.css" rel="stylesheet" type="text/css">
    <link href="/css/common.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="/css/pub-dialog.css">
    <script type="text/javascript" charset="utf-8" defer="" async="" src="/js/tongji.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/common.js"></script>
    <script>
    var ghead={
        linkurl:window.location.href,
        kctimeout:null,
        apptimeout:null,
        usertimeout:null,
        helptimeout:null,
        login:function(){
            var redirect="http://passport.233.com/login/?redirecturl="+escape(this.linkurl);
            window.location.replace(redirect);return false
        },
        register:function(){
            var redirect="http://passport.233.com/register/?redirecturl="+escape(this.linkurl);
            window.location.replace(redirect);
            return false
        },
        logout:function(){
            var redirect="http://wx.233.com/account/logout/?redirecturl="+escape(this.linkurl);
            window.location.replace(redirect);
            return false
        },
        getElement:function(_id){
            return document.getElementById(_id)
        },
        show:function(_obj){
            _obj.style.display="block"
        },
        sinalogin:function(){
            var redirect="http://passport.233.com/oauth/login?referer=qq&bind=true&returnUrl="+escape(this.linkurl);
            window.location.replace(redirect);
            return false
        },
        qqlogin:function(){
            var redirect="http://passport.233.com/oauth/login?referer=sina&bind=true&returnUrl="+escape(this.linkurl);
            window.location.replace(redirect);
            return false
        },
        wenxinlogin:function(){
            var redirect="http://passport.233.com/oauth/login?referer=wechat&bind=true&returnUrl="+escape(this.linkurl);
            window.location.replace(redirect);
            return false
        },
        hide:function(_obj){
            _obj.style.display="none"
        },
        getCookie:function(name){
            var cookieValue="";
            var csearch=name+"=";
            if(document.cookie.length>0){
                offset=document.cookie.indexOf(csearch);
                if(offset!=-1){
                    offset+=csearch.length;
                    end=document.cookie.indexOf(";",offset);
                    if(end==-1)
                        end=document.cookie.length;
                    cookieValue=unescape(document.cookie.substring(offset,end)
                    )}
            }
            return unescape(cookieValue)
        }
    };
    function gshowuserinfo(_id,_tag){
        switch(_tag){
            case 1:ghead.kctimeout&&window.clearTimeout(ghead.kctimeout);
            break;
            case 2:ghead.apptimeout&&window.clearTimeout(ghead.apptimeout);
            break;
            case 3:ghead.usertimeout&&window.clearTimeout(ghead.usertimeout);
            break;
            case 4:ghead.helptimeout&&window.clearTimeout(ghead.helptimeout);
            break
        }
        ghead.show(ghead.getElement(_id))
    }
    function ghideuserinfo(_id,_tag){
        switch(_tag){
            case 1:ghead.kctimeout=window.setTimeout(function(){ghead.hide(ghead.getElement(_id))},100);
            break;
            case 2:ghead.apptimeout=window.setTimeout(function(){ghead.hide(ghead.getElement(_id))},100);
            break;
            case 3:ghead.usertimeout=window.setTimeout(function(){ghead.hide(ghead.getElement(_id))},100);
            break;
            case 4:ghead.helptimeout=window.setTimeout(function(){ghead.hide(ghead.getElement(_id))},100);
            break
        }
    }
    function gzhideuserinfo(_id){
        ghead.hide(ghead.getElement(_id))
    }
    function useinfowx233(redt){
        if(redt.s==10006){
            ghead.getElement("smallheadfacebox").src=redt.list.avatar;
            ghead.getElement("bigheadfacebox").src=redt.list.avatar;
            var userninfo='<a href="http://wx.233.com/uc" target="_blank">'+redt.list.nickName+'</a>';
            userninfo+=redt.list.isSign?'<em class="ynamek" style="display:none">已签到</em>':'<a href="http://wx.233.com/uc" target="_blank" class="namek">签到领积分</a>';
            ghead.getElement("username-qiandao-box").innerHTML=userninfo;if(redt.list.isbindmobile){
                ghead.getElement("shoujirenzhenbox").className="ico-email ico-email-done"
            }
            if(redt.list.isbindemail){
                ghead.getElement("emailrenzhenbox").className="ico-phone ico-phone-done"
            }
            ghead.hide(ghead.getElement("nologinbox"));
            ghead.show(ghead.getElement("uloginedbox"));
            ghead.hide(ghead.getElement("loginwaybox"));
            ghead.show(ghead.getElement("logoutbtbox"));
            var tmpobj=ghead.getElement("umesnumbox");
            tmpobj.innerHTML=redt.list.unreadMessageNum;
            redt.list.unreadMessageNum>0&&ghead.show(tmpobj);
            var tmpobj=ghead.getElement("ucartnumbox");
            tmpobj.innerHTML=redt.list.eartNum;
            redt.list.eartNum>0&&ghead.show(tmpobj);
            var tmpobj=ghead.getElement("urecordnumbox");
            tmpobj.innerHTML=redt.list.learningRecordNum;
            redt.list.learningRecordNum>0&&ghead.show(tmpobj)}}setTimeout(function(){
                if(typeof jQuery=='undefined'){
                    var jqLoadFlag=null;
                    var jqueryurl="js/jquery.min.js";
                    var jqscript=document.createElement("script");
                    jqscript.src=jqueryurl;
                    ghead.getElement("wx233headerbox").appendChild(jqscript);
                    jqscript.onload=jqscript.onreadystatechange=function(){
                        if(!this.readyState||this.readyState=='loaded'||this.readyState=='complete'){
                            if((youhuiquanclose==""||youhuiquanclose=="undefined")&&!jqLoadFlag)
                            {
                                jQuery.getJSON("http://wx.233.com/uc/api/coupon/push?callback=?",function(redt){
                                    jQuery("#wx233headerwidth").append(redt.list.message);
                                    jqLoadFlag=1})
                            }
                        }
                    }
                }
                else{
                    if(youhuiquanclose==""||youhuiquanclose=="undefined"){
                        jQuery.getJSON("http://wx.233.com/uc/api/coupon/push?callback=?",
                            function(redt){
                            jQuery("#wx233headerwidth").append(redt.list.message)
                            }
                        )
                    }
                }
    },2000);
    var auth=ghead.getCookie("Auth");
    if(auth!=""&&auth!="undefined"){
        var checklink="http://api.233.com/v1/basic/userinfo/login?token="+auth+"&callback=useinfowx233";
        var _jsscript=document.createElement("script");
        _jsscript.src=checklink;
        ghead.getElement("wx233headerbox").appendChild(_jsscript)
    }
    var youhuiquanclose=ghead.getCookie("youhuiquan_close");
    </script>
    <script type="text/javascript">
        function get_answer(){
            var multi_answer=new Array();
            var fill_answer=new Array();
            var judge_answer=new Array();
            var program_answer=new Array();

            <c:forEach items="${multiquestionList}" var="multiquestion">
                if($("input[name='${multiquestion.questionId}']:checked").val()==null){
                }else{
                    var answer=$("input[name='${multiquestion.questionId}']:checked").val();
                    multi_answer.push(${multiquestion.questionId}+":"+answer);
                }
            </c:forEach>
            <c:forEach items="${fillquestionList}" var="fillquestion">
                if(document.getElementById(${fillquestion.questionId}).value!=""){
                    fill_answer.push(${fillquestion.questionId}+":"+document.getElementById(${fillquestion.questionId}).value);
                }else {
                }
            </c:forEach>
            <c:forEach items="${judgequestionList}" var="judgequestion">
                if($("input[name='${judgequestion.questionId}']:checked").val()==null){

                }else{
                    var answer=$("input[name='${judgequestion.questionId}']:checked").val();
                    judge_answer.push(${judgequestion.questionId}+":"+answer);
                }
            </c:forEach>
            <c:forEach items="${programquestionList}" var="programquestion">
                if(document.getElementById(${programquestion.questionId}).value!=""){
                    program_answer.push(${programquestion.questionId}+":"+document.getElementById(${programquestion.questionId}).value);
                }else{
                }
            </c:forEach>
            console.log(multi_answer);
            console.log(fill_answer);
            console.log(judge_answer);
            console.log(program_answer);
            var data={
                multiAnswer:multi_answer,
                fillAnswer:fill_answer,
                judgeAnswer:judge_answer,
                programAnswer:program_answer
            }
            $.ajax({
                url:"/student/submit_answer",
                dataType:'json',
                data:data,
                traditional:true,
                type:"post",
                success:function (data) {
                    if(data==true){
                        alert("考试结束");
                        window.location.replace("/student/to_student");
                    }else{
                        console.log("upload failed");
                    }
                }
            });
        }

        var time="${time}";
        window.setInterval(function () {
            time=time-1;
            if(time==0){
                get_answer();
            }
            var reg=/^\d{2}$/;
            var hour=parseInt(time/60/60);
            hour=!reg.test(hour)?"0"+hour:hour;
            var minute=parseInt(time/60%60);
            minute=!reg.test(minute)?"0"+minute:minute;
            var second=parseInt(time%60);
            second=!reg.test(second)?"0"+second:second;
            $("#timer").html("距离考试时间结束:"+hour+"时"+minute+"分"+second+"秒");
        },1000);
    </script>
</head>
        <div class="pracontent clearfix">
            <div class="ui-progress f-shadow clearfix" >
                <div id="m__ruleInfo" class="ui-progress-sub"  data-spy="scroll" data-target=".navbar-example">
                    <div class="navBox">
                        <c:if test="${multiquestionList.size()!=0}">
                        <a href="#choose" class="btn this" data-ruleid="1747372">选择题</a>
                        </c:if>
                        <c:if test="${fillquestionList.size()!=0}">
                        <a href="#fill" class="btn" data-ruleid="1747373">填空题</a>
                        </c:if>
                        <c:if test="${judgequestionList.size()!=0}">
                        <a href="#mistake" class="btn" data-ruleid="1747374">判断题</a>
                        </c:if>
                        <c:if test="${programquestionList.size()!=0}">
                        <a href="#design" class="btn" data-ruleid="1747375">程序编程题</a>
                        </c:if>
                    </div>
                </div>
            </div>
            <div class="dopra-con clearfix">
                <div class="pra-left-con pra-right-font16">
                    <div id="questionModule" class="" >
                        <c:if test="${multiquestionList.size()!=0}">
                        <div class="m__ruleTitle" data-ruleid="1747372">
                            <div  id="choose" class="m-secpart"> 一、选择题</div>
                        </div>
                        <c:forEach items="${multiquestionList}" var="multiquestion">
                        <ul class="m__ruleQuest" data-ruleid="1747372" data-loadstate="notget">
                            <li style="">
                                <div class="subject-con bor clearfix m-question " data-examid="3940684" data-examtype="1" data-rulesid="1747372" data-answer="B" data-useranswer="" data-orderid="8" style="">
                                    <div class="subject-con">
                                        <div class="sub-content ">
                                            <i class="subjec-daan" style="display: none;"></i>
                                            <div class="sub-dotitle">
                                                    ${multiquestion.questionContext}<span>(${multiquestion.score}分)</span>
                                            </div>
                                            <form id="radioform" class="sub-answer">
                                                <label class="radio-inline">
                                                    <input type="radio" name="${multiquestion.questionId}" class="m-question-option "   value="A"><span>A.</span>${multiquestion.questionA}<br/>
                                                </label>
                                                <label class="radio-inline">
                                                    <input type="radio" name="${multiquestion.questionId}" class="m-question-option "  value="B"><span>B.</span>${multiquestion.questionB}<br/>
                                                </label>
                                                <label class="radio-inline">
                                                    <input type="radio" name="${multiquestion.questionId}" class="m-question-option "   value="C"><span>C.</span>${multiquestion.questionC}<br/>
                                                </label>
                                                <label class="radio-inline">
                                                    <input type="radio" name="${multiquestion.questionId}" class="m-question-option " value="D"><span>D.</span>${multiquestion.questionD}<br/>
                                                </label>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </li>
                        </ul>
                        </c:forEach>
                        </c:if>
                        <c:if test="${fillquestionList.size()!=0}">
                        <div id="fill" class="m__ruleTitle" data-ruleid="1747373">
                            <div  class="m-secpart"> 二、填空题</div>
                        </div>
                        <c:forEach items="${fillquestionList}" var="fillquestion">
                        <ul class="m__ruleQuest" data-ruleid="1747373" data-loadstate="notget">
                            <li style="">
                                <div class="subject-con bor clearfix m-question " data-examid="3940703" data-examtype="6" data-rulesid="1747373" data-answer="" data-useranswer="" data-orderid="41" style="">
                                    <div class="subject-con">
                                        <div class="sub-content ">
                                            <i class="subjec-daan" style="display: none;"></i>
                                            <div class="sub-dotitle">
                                                ${fillquestion.questionContext}<span>(${fillquestion.score}分)</span>
                                            </div>
                                            <div class="mater-respond" style="display:block;">
                                                <textarea placeholder="请在此输入您的答案" id="${fillquestion.questionId}"></textarea>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </li>
                        </ul>
                        </c:forEach>
                        </c:if>
                        <c:if test="${judgequestionList.size()!=0}">
                        <div id="mistake" class="m__ruleTitle" data-ruleid="1747374">
                            <div class="m-secpart"> 三、判断题</div>
                        </div>
                        <c:forEach items="${judgequestionList}" var="judgequestion">
                        <ul class="m__ruleQuest" data-ruleid="1747374" data-loadstate="notget">
                            <li style="">
                                <div class="subject-con bor clearfix m-question " data-examid="3940704" data-examtype="7" data-rulesid="1747374" data-answer="" data-useranswer="" data-orderid="42" style="">
                                    <div class="subject-con">
                                        <div class="sub-content ">
                                            <i class="subjec-daan" style="display: none;"></i>
                                            <div class="sub-dotitle">
                                                ${judgequestion.questionContext}<span>(${judgequestion.score}分)</span>
                                            </div>
                                            <div class="mater-respond" style="display:block;">
                                                <input type="radio" name="${judgequestion.questionId}" value="true"/><span>对</span>
                                                <br/>
                                                <input type="radio" name="${judgequestion.questionId}" value="false"/><span>错</span>
                                                <br/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </li>
                        </ul>
                        </c:forEach>
                        </c:if>
                        <c:if test="${programquestionList.size()!=0} ">
                        <div id="design" class="m__ruleTitle" data-ruleid="1747375">
                            <div class="m-secpart"> 四、程序编程题</div>
                        </div>
                        <c:forEach items="${programquestionList}" var="programquestion">
                        <ul class="m__ruleQuest" data-ruleid="1747375" data-loadstate="notget">
                            <li style="">
                                <div class="subject-con bor clearfix m-question " data-examid="3940705" data-examtype="7" data-rulesid="1747375" data-answer="" data-useranswer="" data-orderid="43" style="">
                                    <div class="subject-con">
                                        <div class="sub-content ">
                                            <i class="subjec-daan" style="display: none;"></i>
                                            <div class="sub-dotitle">
                                                ${programquestion.questionContext} <span>(${programquestion.score}分)</span>
                                            </div>
                                            <div class="mater-respond" style="display:block;">
                                                <textarea placeholder="请在此输入您的答案" id="${programquestion.questionId}"style="width:800px;height: 500px"></textarea>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </li>
                        </ul>
                        </c:forEach>
                        </c:if>
                    </div>
                    <!-- 题目切换栏 -->
                    <div id="pageBar"></div>
                </div>
                <!--右侧设置-->
                <div class="pra-right-con">
                    <div id="m__rightPart" class="pra-right-con-sub" style="">

                        <div class="time-card f-mt20 bor">
                            <div class="y-time">
                                    <div class="f-fl" id="timer">

                                    </div>
                            </div>
                            <!--答题卡区域-->
                            <div class="rightArea-answer clear">
                                <div id="answerCard"><div class="hd clearfix">
                                    <span class="title f-fl">答题卡 <span class="e__doneCount card-count" style="font-size: 12px;color: #F06000;margin-left: 10px">共${number}题,总分：${sum}分</span></span>
                                </div>
                                    <div class="bd clear" style="">
                                        <c:if test="${multiquestionList.size()!=0}">
                                        <dl class="panel-item">
                                            <dt ><a href="#choose">选择题<em>共${multiquestionList.size()}题</em></a></dt>
                                        </dl>
                                        </c:if>
                                        <br/>
                                        <c:if test="${fillquestionList.size()!=0}">
                                        <dl class="panel-item">
                                            <dt ><a href="#fill">填空题<em>共${fillquestionList.size()}题</em></a></dt>
                                        </dl>
                                        </c:if>
                                        <br/>
                                        <c:if test="${judgequestionList.size()!=0}">
                                        <dl class="panel-item">
                                            <dt><a href="#mistake">判断题<em>共${judgequestionList.size()}题</em></a></dt>
                                        </dl>
                                        </c:if>
                                        <br/>
                                        <c:if test="${programquestionList.size()!=0}">
                                        <dl class="panel-item">
                                            <dt><a href="#design">程序编程题<em>共${programquestionList.size()}题</em></a></dt>
                                        </dl>
                                        </c:if>
                                        <br/>
                                    </div>
                                </div>
                                <div class="ft">
                                    <div class="btn"><a onclick="get_answer()" class="btn__submit">交卷</a></div>
                                </div>
                            </div>
                            <!--答题卡区域 end-->
                        </div>
                    </div>
                </div>
                <!--右侧设置 end-->
            </div>
        </div>
        </body>
</html>
