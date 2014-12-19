<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	/* ☆☆☆麗嬰房的Sample☆☆☆ */
	//使用者ID
	String userId = "11";
	
	
	//帳號/活動代碼
	String cid = "T04377371";								//系統給定的公司帳號
	String acctId = "admin";								//系統給定的使用者帳號
	String campaignId = "A_1412190939536"; 	//系統給定的活動代碼
	
	//產品的各項資訊(資料來源：資料庫)
	String itemId = "103";			//商品編號
	String mainCate = "A";			//大類
	String middleCate = "AB";		//中類
	String endCate = "ABC";			//小類
	String itemName = "波卡圓點極暖羽絨外套";		//商品名稱
	String newItem = "1";				//新品標示,"0" 或 "1"("1"表示新品) 
	String outDate = "";				//到期日 YYYYMMDD (一般建議給"",系統會預設隔天過期)
	String priority = null;			//優先序(數字) 
	String attributes = null;		//附加屬性,最多10個,以','隔開
	String listPrice = "1799";	//定價	
	String specialPrice = "";		//優惠價
	String itemUrl = "http://www.littlemoni.com.tw/littlemoni/index.php?action=product_detail&prod_no=P0000100003864";		//商品url
	String imgUrl = "http://www.littlemoni.com.tw/website/uploads_product/website_1/P0000100003864_2_82527.jpg";		//圖片url
	String stock = "10";					//庫存量
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sample for TPRS API And Updating the product information</title>

<!-- 步驟一、在使用TPRS推薦API的頁面上引用 tprs-2.1.js 與 jquery-x.x.0.min.js -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
<script type="text/javascript" src="js/tprs-2.1.js"></script>

<!-- 步驟二、套用TPRS-Style.css -->
<link rel="stylesheet" href="css/TPRS-Style.css" />

<script>
	<!-- 步驟三、宣告「公司帳號」、「使用者帳號」、「活動代碼」。以及變數 tprs (固定名稱，保留字) -->
	var cid = "<%= cid %>"; 							//系統給定的公司帳號
	var acctId = "<%= acctId %>"; 				//系統給定的使用者帳號
	var campaignId = "<%= campaignId %>"; //系統給定的活動代碼
	/*
		實體化 TrsApi
		宣告變數 tprs (固定名稱[保留字]，勿異動，程式會認此變數名稱)
	*/
	var tprs = new TrsApi(cid,acctId,campaignId);
	
	<%-- 步驟四、增加「更新商品資料Function」，並呼叫tprs.product() --%>
	
	/*
	 * 更新商品資料
	 * 參數說明:
	 * itemId : 商品編號
	 * mainCate : 大類
	 * middleCate : 中類
	 * endCate : 小類
	 * itemName : 商品名稱
	 * newItem : 新品標示,"0" 或 "1"("1"表示新品) 
	 * outDate: 到期日 YYYYMMDD (一般建議給"",系統會預設隔天過期)
	 * priority: 優先序(數字) 
	 * attributes: 附加屬性,最多10個,以','隔開
	 * listPrice: 定價
	 * specialPrice: 優惠價
	 * itemUrl: 商品url
	 * imgUrl: 圖片url
	 * stock: 庫存量
	 */
	function updateProduct(){
		var itemId = "<%= itemId %>";
		var mainCate = "<%= mainCate %>";
		var middleCate = "<%= middleCate %>";
		var endCate = "<%= endCate %>";
		var itemName = "<%= itemName %>";
		var newItem = "<%= newItem %>";
		var outDate = "<%= outDate %>";//建議不設定,系統會預設隔天過期
		var priority = "<%= priority %>";
		var attributes = "<%= attributes %>";
		var listPrice = "<%= listPrice %>";
		var specialPrice = "<%= specialPrice %>";
		var itemUrl = "<%= itemUrl %>";
		var imgUrl = "<%= imgUrl %>";
		var stock = "<%= stock %>";
		
		tprs.product(itemId,mainCate,middleCate,endCate,itemName,newItem,outDate,priority,attributes,listPrice,specialPrice,itemUrl,imgUrl,stock);
	}
	 
	 <%-- 步驟五、選取推薦呈現模組樣式(共10組範本，參照TPRS_API_Sample.html範例)--%>
	 
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
	 * newItem : 是否用新品取代 : ex: 2 表示前兩個用新品取代; -2表示後兩個用新品取代
	 * howMany : 推薦個數
	 * titles : 推薦畫面欲呈現的title,若有一個以上則以","隔開
	 * targetDivId : 頁面顯示區域[推薦顯示區]的Div ID
	 * -------------------
	 */	 
	function recommend8(){
		<%--var mainCate = "<%= mainCate %>";
		var middleCate = "<%= middleCate %>";
		var endCate = "<%= endCate %>";
		var itemId = "<%= itemId %>"; --%>
		
		var mainCate = "";
		var middleCate = "";
		var endCate = "";
		var itemId = "";
		
		var hotSale = "Y";
		var sameCate = false;
		var bonly = "N";
		var newItem = "1";
		var howMany = 5;
		var targetDivId = "tprs";
		var titles = "同類推薦,看此商品的人也看了,買此商品的人也買了";
		tprs.itemcate_alsoview_alsobuy(mainCate, middleCate, endCate,itemId,hotSale,sameCate,bonly,newItem,howMany,titles,targetDivId);
	}
	 
	 /*
	 * 紀錄Click Log
	 * 參數說明:
	 * userId : 使用者代號
	 * itemId : 商品編號
	 * isTRS : 此click是否因為TRS推薦, "Y" or "N" (預設為N)
	 * page : 此click所屬網頁名稱
	 * mainCate : 大類
	 * middleCate : 中類
	 * endCate : 小類
	 */
	 function clickLog() {
		 //如果發現有帶trs=y(Server端會帶)，表示是點選模板內推薦的商品，此時clicklog已經於點選時記錄 ，所以此處不需再次記錄
		 if(window.location.href.indexOf("trs=y") != -1){
			 return;
		 }
		 var userId = "<%= userId %>";
		 
		 //Cookie ID
		 userId = get_TprsUserId();
		 
		 var itemId = "<%= itemId %>";
		 
		 var page = window.location.pathname;
		 
		 var mainCate = "<%= mainCate %>";
		 var middleCate = "<%= middleCate %>";
		 var endCate = "<%= endCate %>";
		 
		 tprs.click(userId,itemId,'',page,mainCate,middleCate,endCate);
	 }
	 
	 /*
	 * 紀錄Buy Log
	 * 參數說明:
	 * userId : 使用者代號
	 * itemId : 商品編號
	 * quantity : 購買數量
	 */
	 function buyLog() {
		 var userId = "<%= userId %>";
		 
		 //Cookie ID
		 userId = get_TprsUserId();
		 
		 var itemId = "<%= itemId %>";
		 var quantity = $("#quantity").val();
		 if(quantity == "")
			 quantity = 0;
		 tprs.buy(userId,itemId,quantity);
	 }
</script>

</head>

<!-- 步驟六、body onload 呼叫function 「更新商品資料」、「推薦呈現模組」、「Click Log」 -->
<body onload="updateProduct(); recommend8(); clickLog();">
	<div align="center">
		<table style="width:70%;border: 0px solid #000;">
			<tr>
				<td style="border: 0px solid #000;">
					<img alt="測試用圖片" src="<%= imgUrl %>">
				</td>
				<td style="border: 0px solid #000;">
					<b><%= itemName %></b><p>
					商品編號： A -1618340 -00     <p>
					★皮革拉鍊片展現精品風範<p>
					★天使之翼皮革烙印LOGO<p>
					★高質感厚實尼龍材質，兼具高耐磨與抗拉扯<p>
					★各類書籍雜物都可輕鬆置入<p>
					★可放14吋筆電<p>
					<div align="right">
						數量：<input id="quantity" type="text" style="width: 40px;">
						<button id="buy" onclick="buyLog();">購買</button>
					</div>
				</td>
			</tr>
			<tr>
				<td style="border: 0px solid #000;"></td>
				<td style="border: 0px solid #000;"></td>
			</tr>
		</table>
		
		<!-- 步驟七、推薦顯示區 -->
		<div id="tprs" style=" width:95%; margin:0 auto; "></div>
		
		<img alt="測試用" src="http://www.savesafe.com.tw/EcActive/ACimg/Spotlight/signboard-A4.jpg">
	</div>
</body>
</html>