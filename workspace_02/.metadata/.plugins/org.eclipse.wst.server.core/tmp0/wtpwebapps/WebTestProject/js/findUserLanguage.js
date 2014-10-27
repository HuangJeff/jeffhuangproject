/**
 * 找出使用者端語系
 */
jeff.test = function() {
	var lang = window.navigator.userLanguage || window.navigator.language;
   	//var relang=lang.toLowerCase();
   	alert("jeff.test lang : " + lang);
	return lang;
};

function getLang() {
	var lang = window.navigator.userLanguage || window.navigator.language;
   	//var relang=lang.toLowerCase();
   	//alert("getLang lang11 : " + lang);
	return lang;
}

function getTransLang() {
	//alert("beCheckLang lang = ");
	var lang = getLang();
	//alert("beCheckLang lang = " + lang);
	var result = "";
	switch(lang.toLowerCase()) {
	case "en-us":
		//英文美國
		result = "英文美國";
		break;
	case "zh-tw":
		//中文台灣
		result = "中文台灣";
		break;
	case "zh-cn":
		//中文大陸
		result = "中文大陸";
		break;
	default:
		//其他
		result = "其他";
		break;
	};
	return result;
}

//頁面初始完畢之後
$(document).ready(function() {
	//將語系的值塞回頁面上的某欄位上
	//$("#js_language").text(jeff.test);
});