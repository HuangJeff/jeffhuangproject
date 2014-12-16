/**************************************************************************
 * tprs.js  
 * Version 2.1
 * Copyright www.thinkpower.info
 * 說明 :
 * 本程式為TPRS智能推薦系統的瀏覽器端javascript串接函式庫
 ***************************************************************************/
	 
var tprs_server_url = "http://192.168.1.88/trs"; //修改為實際TPRS server位置
var debug = false;

function TrsApi(cid,acctId,campaignId) {
	
	var ptsub = cid;
	var ptsua = acctId;
	var ptsmd = campaignId;	
	var ajax_content_type = "application/x-www-form-urlencoded;charset=utf-8";
	
	/******************************************
	 * Feedback log
	 *******************************************/
	 
	/*
	 * 紀錄Click Log
	 * 參數說明:
	 * -------------------------------------------------
	 * userId : 使用者代號
	 * itemId : 商品編號
	 * isTRS : 此click是否因為TRS推薦, "Y" or "N" (預設為N)
	 * page : 此click所屬網頁名稱
	 * mainCate : 大類
	 * middleCate : 中類
	 * endCate : 小類
	 * --------------------------------------------------
	 */		
	this.click = function(userId,itemId,isTRS,page,mainCate,middleCate,endCate) {
		
		mainCate = encodeURI(mainCate);
		middleCate = encodeURI(middleCate);
		endCate = encodeURI(endCate);
		
		$.ajax({
			type: "post",
			contentType: ajax_content_type,
			url: tprs_server_url + "/api/fblog/click",			
			data: {ptsub : ptsub ,
				   ptsua : ptsua, 
				   ptsmd : ptsmd, 
				   ptsru : userId,
				   ptsri: itemId,
				   trs : isTRS,
				   ptpge : page,
				   ptscmm : mainCate ,
				   ptscmd : middleCate, 
				   ptsced : endCate
				   },
			error: function(xhr) {
				if (debug) alert('Ajax request error');
			},
			success: function(response) {
				if (debug) alert(response);		
			}
		});
	}
	
	/*
	 * 紀錄Buy Log
	 * 參數說明:
	 * -------------------------------------------------
	 * userId : 使用者代號
	 * itemId : 商品編號
	 * quantity : 購買數量
	 * --------------------------------------------------
	 */	
	this.buy = function(userId,itemId,quantity) {
		$.ajax({
			type: "post",
			contentType: ajax_content_type,
			url: tprs_server_url + "/api/fblog/buy",			
			data: {ptsub : ptsub ,
				   ptsua : ptsua, 
				   ptsmd : ptsmd, 
				   ptsru : userId,
				   ptsri: itemId,
				   qty : quantity
				   },
			error: function(xhr) {
				if (debug) alert('Ajax request error');
			},
			success: function(response) {
				if (debug) alert(response);		
			}
		});
	}
	
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
				if (debug) alert('Ajax request error' + xhr);
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
	 * 1.熱銷推薦
	 * 參數說明:
	 * -------------------
	 * mainCate : 大類
	 * middleCate : 中類
	 * endCate : 小類
	 * howMany : 推薦個數
	 * targetDivId : 頁面顯示區域的Div ID
	 * -------------------
	 */
	this.allrcmd = function(mainCate, middleCate, endCate, howMany,targetDivId) {
		alert('allrcmd');
		$.ajax({
			url: tprs_server_url + "/api/html/allrcmd",
			data: {ptsub : ptsub , ptsua : ptsua, ptsmd : ptsmd, ptscmm : mainCate , ptscmd : middleCate, ptsced : endCate,ptsrhm : howMany},
			error: function(xhr) {
				if (debug){
					$("#"+targetDivId).html('Ajax request error');
				}
			},
			success: function(response) {
				response = decodeURI(response);
				if (debug) alert(response);					
				$("#"+targetDivId).html(response);
			}
		});
	}
	
	/*
	 * 2.分類精選推薦
	 * 參數說明:
	 * -------------------
	 * mainCate : 大類
	 * middleCate : 中類
	 * endCate : 小類
	 * userId : 使用者ID
	 * howMany : 推薦個數
	 * hotSale : 是否自動補熱銷, Y or N (預設為Y)
	 * targetDivId : 頁面顯示區域的Div ID
	 * -------------------
	 */
	this.catercmd = function(mainCate, middleCate, endCate,userId, hotSale,howMany,targetDivId) {
		
		$.ajax({
			url: tprs_server_url + "/api/html/catercmd",
			data: {ptsub : ptsub , 
				   ptsua : ptsua, 
				   ptsmd : ptsmd, 
				   ptscmm : mainCate , 
				   ptscmd : middleCate, 
				   ptsced : endCate,
				   ptsrhm : howMany,
				   ptsru :userId,
				   hotsale : hotSale
				   },
			error: function(xhr) {
				//$("#"+targetDivId).html('Ajax request error');
			},
			success: function(response) {
				response = decodeURI(response);
				if (debug) alert(response);					
				$("#"+targetDivId).html(response);
			}
		});
	}
	
	/*
	 * 3.買此商品的人也買了
	 * 參數說明:
	 * -------------------
	 * mainCate : 大類
	 * middleCate : 中類
	 * endCate : 小類
	 * itemId : 商品編號
	 * sameCate : 是否限縮在此商品之同類別, "true" 或 "false"(預設false)
	 * howMany : 推薦個數
	 * hotSale : 是否自動補熱銷, Y or N (預設為Y)
	 * newitem : 是否用新品取代 : ex: 2 表示前兩個用新品取代; -2表示後兩個用新品取代
	 * targetDivId : 頁面顯示區域的Div ID
	 * -------------------
	 */			
	this.alsobuyrcmd = function(mainCate, middleCate, endCate,itemId,sameCate,hotSale,newitem,howMany,targetDivId) {
		
		$.ajax({
			url: tprs_server_url + "/api/html/alsobuyrcmd",
			data: {ptsub : ptsub , 
				   ptsua : ptsua, 
				   ptsmd : ptsmd, 
				   ptscmm : mainCate , 
				   ptscmd : middleCate, 
				   ptsced : endCate,
				   ptsrhm : howMany,
				   ptsri : itemId,
				   ptsca : sameCate,
				   hotsale : hotSale,
				   newitem : newitem
				   },
			error: function(xhr) {
				//$("#"+targetDivId).html('Ajax request error');
			},
			success: function(response) {
				response = decodeURI(response);
				if (debug) alert(response);					
				$("#"+targetDivId).html(response);
			}
		});
	}
	
	/*
	 * 4.看此商品的人也看了
	 * 參數說明:
	 * -------------------
	 * mainCate : 大類
	 * middleCate : 中類
	 * endCate : 小類
	 * itemId : 商品編號
	 * sameCate : 是否限縮在此商品之同類別, "true" 或 "false"(預設false)
	 * howMany : 推薦個數
	 * hotSale : 是否自動補熱銷, Y or N (預設為Y)
	 * newitem : 是否用新品取代 : ex: 2 表示前兩個用新品取代; -2表示後兩個用新品取代
	 * targetDivId : 頁面顯示區域的Div ID
	 * -------------------
	 */			
	this.alsoviewrcmd = function(mainCate, middleCate, endCate,itemId,sameCate,hotSale,newitem,howMany,targetDivId) {
		
		$.ajax({
			url: tprs_server_url + "/api/html/alsoviewrcmd",
			data: {ptsub : ptsub , 
				   ptsua : ptsua, 
				   ptsmd : ptsmd, 
				   ptscmm : mainCate , 
				   ptscmd : middleCate, 
				   ptsced : endCate,
				   ptsrhm : howMany,
				   ptsri : itemId,
				   ptsca : sameCate,
				   hotsale : hotSale,
				   newitem : newitem
				   },
			error: function(xhr) {
				//$("#"+targetDivId).html('Ajax request error');
			},
			success: function(response) {
				response = decodeURI(response);
				if (debug) alert(response);					
				$("#"+targetDivId).html(response);
			}
		});
	}
	
	/*
	 * 5.同類推薦
	 * 參數說明:
	 * -------------------
	 * mainCate : 大類
	 * middleCate : 中類
	 * endCate : 小類
	 * itemId : 商品編號
	 * bonly : 是否只查瀏覽行為, Y or N (預設為N)
	 * howMany : 推薦個數
	 * hotSale : 是否自動補熱銷, Y or N (預設為Y)	
	 * targetDivId : 頁面顯示區域的Div ID
	 * -------------------
	 */	 
	this.itemcatercmd = function(mainCate,middleCate, endCate,itemId,hotSale,bonly,howMany,targetDivId){		
		$.ajax({
			url: tprs_server_url + "/api/html/itemcatercmd",
			data: {ptsub : ptsub, 
				   ptsua : ptsua, 
				   ptsmd : ptsmd, 
				   ptscmm : mainCate, 
				   ptscmd : middleCate, 
				   ptsced : endCate,
				   ptsrhm : howMany,
				   ptsri : itemId,
				   bonly : bonly,
				   hotsale : hotSale
				   },
			error: function(xhr) {
				//$("#"+targetDivId).html('Ajax request error');
			},
			success: function(response) {
				response = decodeURI(response);
				if (debug) alert(response);					
				$("#"+targetDivId).html(response);
			}
		});
	}
	/*
	 * 6.同類推薦 + 買此商品的人也買了
	 * 參數說明:
	 * -------------------
	 * mainCate : 大類
	 * middleCate : 中類
	 * endCate : 小類
	 * itemId : 商品編號
	 * sameCate : 是否限縮在此商品之同類別, "true" 或 "false"(預設false)
	 * bonly : 是否只查瀏覽行為, Y or N (預設為N)	 
	 * hotSale : 是否自動補熱銷, Y or N (預設為Y)	
	 * newitem : 是否用新品取代 : ex: 2 表示前兩個用新品取代; -2表示後兩個用新品取代
	 * howMany : 推薦個數
	 * targetDivId : 頁面顯示區域的Div ID
	 * -------------------
	 */	 
	this.itemcate_alsobuy = function(mainCate, middleCate, endCate,itemId,hotSale,sameCate,bonly,newItem,howMany,targetDivId) {
		
		$.ajax({
			url: tprs_server_url + "/api/html/itemcate_alsobuy",
			data: {ptsub : ptsub , 
				   ptsua : ptsua, 
				   ptsmd : ptsmd, 
				   ptscmm : mainCate , 
				   ptscmd : middleCate, 
				   ptsced : endCate,
				   ptsri : itemId,
				   hotsale : hotSale,
				   ptsca : sameCate,
				   bonly : bonly,
				   newitem : newItem,
				   ptsrhm : howMany
				   },
			error: function(xhr) {
				//$("#"+targetDivId).html('Ajax request error');
			},
			success: function(response) {
				response = decodeURI(response);
				if (debug) alert(response);					
				$("#"+targetDivId).html(response);
			}
		});
	}
	
	/*
	 * 7.看此商品的人也看了 + 買此商品的人也買了
	 * 參數說明:
	 * -------------------
	 * mainCate : 大類
	 * middleCate : 中類
	 * endCate : 小類
	 * itemId : 商品編號
	 * sameCate : 是否限縮在此商品之同類別, "true" 或 "false"(預設false)
	 * howMany : 推薦個數
	 * hotSale : 是否自動補熱銷, Y or N (預設為Y)
	 * newitem : 是否用新品取代 : ex: 2 表示前兩個用新品取代; -2表示後兩個用新品取代
	 * targetDivId : 頁面顯示區域的Div ID
	 * -------------------
	 */	
	this.alsoview_alsobuy = function(mainCate, middleCate, endCate,itemId,sameCate,hotSale,newitem,howMany,targetDivId) {
		
		$.ajax({
			url: tprs_server_url + "/api/html/alsoview_alsobuy",
			data: {ptsub : ptsub , 
				   ptsua : ptsua, 
				   ptsmd : ptsmd, 
				   ptscmm : mainCate , 
				   ptscmd : middleCate, 
				   ptsced : endCate,
				   ptsri : itemId,
				   ptsca : sameCate,
				   ptsrhm : howMany,	
				   hotsale : hotSale,
				   newitem : newitem
				   },
			error: function(xhr) {
				//$("#"+targetDivId).html('Ajax request error');
			},
			success: function(response) {
				response = decodeURI(response);
				if (debug) alert(response);					
				$("#"+targetDivId).html(response);
			}
		});
	}
	
	/*
	 * 8.同類推薦 + 看此商品的人也看了 + 買此商品的人也買了
	 * 參數說明:
	 * -------------------
	 * mainCate : 大類
	 * middleCate : 中類
	 * endCate : 小類
	 * itemId : 商品編號
	 * sameCate : 是否限縮在此商品之同類別, "true" 或 "false"(預設false)
	 * bonly : 是否只查瀏覽行為, Y or N (預設為N)	 
	 * hotSale : 是否自動補熱銷, Y or N (預設為Y)	
	 * newitem : 是否用新品取代 : ex: 2 表示前兩個用新品取代; -2表示後兩個用新品取代
	 * howMany : 推薦個數
	 * targetDivId : 頁面顯示區域的Div ID
	 * -------------------
	 */	 
	this.itemcate_alsoview_alsobuy = function(mainCate, middleCate, endCate,itemId,hotSale,sameCate,bonly,newItem,howMany,targetDivId) {
		
		$.ajax({
			url: tprs_server_url + "/api/html/itemcate_alsoview_alsobuy",
			data: { ptsub : ptsub , 
				    ptsua : ptsua, 
				    ptsmd : ptsmd, 
				    ptscmm : mainCate , 
				    ptscmd : middleCate, 
				    ptsced : endCate,
				    ptsrhm : howMany,
				    ptsri : itemId,
				    ptsca : sameCate,
				    bonly : bonly,
				    hotsale : hotSale,
				    newItem : newItem
				   },
			error: function(xhr) {
				//$("#"+targetDivId).html('Ajax request error');
			},
			success: function(response) {
				response = decodeURI(response);
				if (debug) alert(response);					
				$("#"+targetDivId).html(response);
			}
		});
	}
	
	/*
	 * 9.購買相似推薦
	 * 參數說明:
	 * -------------------	
	 * itemId : 商品編號
	 * userId : 使用者ID
	 * newitem : 是否用新品取代 : ex: 2 表示前兩個用新品取代; -2表示後兩個用新品取代
	 * howMany : 推薦個數
	 * -------------------
	 */	 
	 this.user_buy = function(itemId,userId,newItem,howMany,targetDivId) {
		
		$.ajax({
			url: tprs_server_url + "/api/html/user_buy",
			data: {ptsub : ptsub , 
				   ptsua : ptsua, 
				   ptsmd : ptsmd, 				  
				   ptsrhm : howMany,
				   ptsri : itemId,
				   ptsru : userId,
				   newitem : newItem
				   },
			error: function(xhr) {
				//$("#"+targetDivId).html('Ajax request error');
			},
			success: function(response) {
				response = decodeURI(response);
				if (debug) alert(response);					
				$("#"+targetDivId).html(response);
			}
		});
	}
	
	/*
	 * 10.瀏覽相似推薦
	 * 參數說明:
	 * -------------------	
	 * itemId : 商品編號
	 * userId : 使用者ID
	 * newitem : 是否用新品取代 : ex: 2 表示前兩個用新品取代; -2表示後兩個用新品取代
	 * howMany : 推薦個數
	 * -------------------
	 */	 
	 this.user_view = function(itemId,userId,newItem,howMany,targetDivId) {
		
		$.ajax({
			url: tprs_server_url + "/api/html/user_view",
			data: {ptsub : ptsub , 
				   ptsua : ptsua, 
				   ptsmd : ptsmd, 				  
				   ptsrhm : howMany,
				   ptsri : itemId,
				   ptsru : userId,
				   newitem : newItem
				   },
			error: function(xhr) {
				//$("#"+targetDivId).html('Ajax request error');
			},
			success: function(response) {
				response = decodeURI(response);
				if (debug) alert(response);					
				$("#"+targetDivId).html(response);
			}
		});
	}
}


function createCookie(name,value,days) {
	//if(debug) alert('[createCookie] I am in.');
    if (days) {
        var date = new Date();
        date.setTime(date.getTime()+(days*24*60*60*1000));
        var expires = "; expires="+date.toGMTString();
    }
    else var expires = "";
    document.cookie = name+"="+value+expires+"; path=/";
	//if(debug) alert('[createCookie] document.cookie:' +  document.cookie);
}

function readCookie(name) {
	var cookie_value ;
    var nameEQ = name + "=";
	//if(debug) alert('cookie : ' + document.cookie);
    var ca = document.cookie.split(';');
    for(var i=0;i < ca.length;i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1,c.length);
        if (c.indexOf(nameEQ) == 0){
			cookie_value =  c.substring(nameEQ.length,c.length);
		} 
    }
	//if(debug) alert('cookie ' + name + ' : ' + cookie_value);
    return cookie_value;
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
	
	var trsuser = readCookie('trsuser');	 
	
	if(typeof trsuser == undefined || trsuser == undefined || trsuser == '' || trsuser == 'undefined' || trsuser == 'null'){
		//if(debug) alert('trsuser is undefined or null, creat one..');
		createCookie ('trsuser', guid(),10000);
	}
	trsuser = readCookie('trsuser');
	//if(debug) alert('userId : ' + 	trsuser);
	return trsuser;
}


jQuery(function () {
	jQuery("ul.TPRSMenu > li").on("mouseenter", function () {
		jQuery("ul.TPRSMenu > li").removeClass("selected");
		var selitem = tprsjq(this);
		selitem.addClass("selected");
		//console.log(selitem.index());

		jQuery("div.TPRSContent > table.selected").removeClass("selected");
		jQuery("div.TPRSContent > table[data-index=" + selitem.index() + "]").addClass("selected");
	});

	//set default item
	jQuery("ul.TPRSMenu > li:nth-child(1)").trigger("mouseenter");
});

	

