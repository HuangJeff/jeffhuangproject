/**************************************************************************
 * tprs.js  
 * Version 2.0 
 * Copyright www.thinkpower.info
 * 說明 :
 * 本程式為TPRS智能推薦系統的瀏覽器端javascript串接函式庫
 ***************************************************************************/
	 
//var tprs_server_url = "http://localhost/trs"; //修改為實際TPRS server位置
var tprs_server_url = "http://192.168.1.88/trs";
var debug = false;

function TrsApi(cid,acctId,campaignId) {
	
	var ptsub = cid;
	var ptsua = acctId;
	var ptsmd = campaignId;	
	var ajax_content_type = "application/x-www-form-urlencoded;charset=utf-8";
	alert("--init--" + cid + " : " + acctId + " -- " + campaignId);
	/******************************************
	 * Feedback log
	 *******************************************/
	
	/*
	 * 更新商品資料
	 * 參數說明:
	 * -------------------------------------------------
	 * itemId : 商品編號
	 * mainCate : 大類
	 * middleCate : 中類
	 * endCate : 小類
	 * itemName : 商品名稱
	 * newItem : 新品標示,"0" 或 "1"("1"表示新品) 
	 * outDate: 到期日 YYYYMMDD 
	 * priority: 優先序(數字) 
	 * attributes: 附加屬性,最多10個,以','隔開
	 * listPrice: 定價
	 * specialPrice: 優惠價
	 * itemUrl: 商品url
	 * imgUrl: 圖片url
	 * stock: 庫存量
	 * --------------------------------------------------
	 */
	this.product = function(itemId,mainCate,middleCate,endCate,itemName,newItem,outDate,priority,attributes,listPrice,specialPrice,itemUrl,imgUrl,stock) {
		alert("itemName : " + itemName + " -campaignId- " + campaignId);
		mainCate = encodeURI(mainCate);
		middleCate = encodeURI(middleCate);
		endCate = encodeURI(endCate);
		attributes = encodeURI(attributes);
		itemName = encodeURI(itemName);
		
		$.ajax({
			type: "post",
			contentType: ajax_content_type,
			url: tprs_server_url + "/api/fblog/product",			
			data: {ptsub : ptsub , ptsua : ptsua, ptsmd : ptsmd, ptsri: itemId,ptscmm : mainCate ,ptscmd : middleCate, ptsced : endCate,newitem:newItem,outdate:outDate,priority:priority,attrs:attributes,lprice:listPrice,sprice:specialPrice,itemurl:itemUrl,imgurl:imgUrl,itemname:itemName,stock:stock},
			error: function(xhr) {
				if (debug) alert('Ajax request error');
			},
			success: function(response) {
				if (debug) alert(response);		
			}
		});
	}
	
	/*
	 * 將商品下架停用
	 * 參數說明:
	 * -------------------------------
	 * itemIds : 商品編號(以','隔開)
	 * -------------------------------
	 */		
	this.productOff = function(itemIds) {
		$.ajax({
			type: "post",
			contentType: ajax_content_type,
			url: tprs_server_url + "/api/fblog/productOff",
			data: {ptsub : ptsub , ptsua : ptsua, ptsmd : ptsmd, ptsri : itemIds },
			error: function(xhr) {
				//alert('Ajax request error');
			},
			success: function(response) {
				if (debug) alert(response);		
			}
		});
	}
	
	/*
	 * 將商品上架啟用
	 * 參數說明:
	 * -------------------------------
	 * itemIds : 商品編號(以','隔開)
	 * -------------------------------
	 */		
	this.productOn = function(itemIds) {
		$.ajax({
			type: "post",
			contentType: ajax_content_type,
			url: tprs_server_url + "/api/fblog/productOn",
			data: {ptsub : ptsub , ptsua : ptsua, ptsmd : ptsmd, ptsri : itemIds },
			error: function(xhr) {
				//alert('Ajax request error');
			},
			success: function(response) {
				if (debug) alert(response);		
			}
		});
	}
	
	/*
	 * 熱銷推薦
	 * 參數說明:
	 * -------------------
	 * mainCate : 大類
	 * middleCate : 中類
	 * endCate : 小類
	 * howMany : 推薦個數
	 * -------------------
	 */
	this.runrcmd = function(mainCate, middleCate, endCate, howMany,targetDivId) {
		
		$.ajax({
			url: tprs_server_url + "/api/html/allrcmd",
			data: {ptsub : ptsub , ptsua : ptsua, ptsmd : ptsmd, ptscmm : mainCate , ptscmd : middleCate, ptsced : endCate,ptsrhm : howMany},
			error: function(xhr) {
				//$("#"+targetDivId).html('Ajax request error');
			},
			success: function(response) {
				if (debug) alert(response);					
				$("#"+targetDivId).html(response);
			}
		});
	}
	
}



function createCookie(name,value,days) {
    if (days) {
        var date = new Date();
        date.setTime(date.getTime()+(days*24*60*60*1000));
        var expires = "; expires="+date.toGMTString();
    }
    else var expires = "";
    document.cookie = name+"="+value+expires+"; path=/";
}

function readCookie(name) {
    var nameEQ = name + "=";
    var ca = document.cookie.split(';');
    for(var i=0;i < ca.length;i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1,c.length);
        if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
    }
    return null;
}

function eraseCookie(name) {
    createCookie(name,"",-1);
}

var guid = (function() {
  function s4() {
    return Math.floor((1 + Math.random()) * 0x10000)
               .toString(16)
               .substring(1);
  }
  return function() {
  
	var date = new Date();
	return s4() + s4() + date.getTime();
  };
})();

function get_TprsUserId(){
	return readCookie('trsuser');
}

var trsuser = readCookie('trsuser');
var guidno = guid();

if(trsuser == '' || trsuser == 'undefined' || trsuser == 'null'){
	createCookie ('trsuser', guidno,10000);
}

	

