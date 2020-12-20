$(document).ready(function(){
	$.getJSON("http://localhost:8088/FirstJavaWeb/menLeiServlet","action=getMLList",function (msg) {
    	 //alert(msg);
	     var str="";
	     var obj=eval(msg);
	     for(var i=0;i<obj.length;i++){
	     	 str+="<option value='"+obj[i].mlid+"'>"+obj[i].menlei+"</option>";
	                    
	     }
	     $("#mlname").append(str);
	    });		  
	  $("#findbtn").click(function(){
		  $.getJSON("http://localhost:8088/FirstJavaWeb/resultServlet","action=getreList&"+$("#form01").serialize(),function (msg) {
				//alert(msg);
				//alert($("#form01").serialize());
				var str="<tr>"+
				"<th>省份</th>"+
				"<th>学校</th>"+
				"<th>门类</th>"+
				"<th>学科</th>"+
				"<th>专业</th>"+
				"</tr>";
				var obj=eval(msg);
				for(var i=0;i<obj.length;i++){
					str+="<tr>"+
	                "<td align='center'>" + obj[i].province+ "</td>" +
	                "<td align='center'>" + obj[i].school + "</td>"  +
	                "<td align='center'>" + obj[i].menlei+ "</td>" +
	                "<td align='center'>" + obj[i].xueke + "</td>"+	
	                "<td align='center'>" + obj[i].major+ "</td>" 
	                +"</tr>";
				}
				$("#tbody_result").html(str);
				//List<Person> mlist = gson.fromJson(data, new PersonListType().getType());			
				});
		  });

});

 
  //点击门类下拉框发生的事件
  function setback(){
	  var select_id=$("option:selected").val();//获取选择门类的id
  //alert(id);
  $.getJSON("http://localhost:8088/FirstJavaWeb/xueKeServlet","action=getXKList&mlId="+select_id,function (msg) {
     	//alert(msg);
	     var str="";
	     var obj=eval(msg);
	     for(var i=0;i<obj.length;i++){
	     	 str+="<option value='"+obj[i].xkid+"'>"+obj[i].xueke+"</option>";
	                    
	     }
    	 $("#xkname").html(str);
	    	});		  
  }
  function zySetback(){
	  var select_id=$("#xkname").find("option:selected").val();//获取选择学科的id
  //alert(select_id);
	  $.getJSON("http://localhost:8088/FirstJavaWeb/zhuanyeServlet","action=getZYList&zyId="+select_id,function (msg) {
     
	 // alert(msg);
	     var str="";
	     var obj=eval(msg);
	     for(var i=0;i<obj.length;i++){
	     	 str+="<option value='"+obj[i].mjid+"'>"+obj[i].major+"</option>";
	                    
	     }
    	 $("#zyname").html(str);
	    	});	
  }
