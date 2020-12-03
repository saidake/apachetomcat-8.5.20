function(){


	setTimeout(function(){
						$("#chujuan").on("click",function(){

						$.get('koko?m=getchoice_question',function(res){
							var cho_question=JSON.parse(res);
							$.get('koko?m=getcompletion',function(res){
								var com_question=JSON.parse(res);
								$.get('koko?m=getcalculation',function(res){
									var cal_question=JSON.parse(res);





									var cho_str=["一、选择题  （每小题2分，共20分）\n"];
									var com_str=["\n\n二、填空题  （每小题2分，共20分）\n"];
									var cal_str=["\n\n三、计算题  （每小题10分，共60分）\n"];

									//获取选中的option索引，匹配试卷 刷新出题目
									var exam_val;
									$("#select2").children("select").children("option").each(function(){
										if($(this).is(":selected")){
											exam_val=$(this).text();      //试卷套数名称
											var u_exam_name;             //科目名
											$("#exam_name").children("option").each(function(){
												if($(this).is(":selected")) u_exam_name=$(this).text();
											}); 
											// console.log("u_exam_name---"+u_exam_name);
											// console.log('exam_val----'+exam_val);

											cho_str.unshift("\t\t\t\t\t"+exam_val+"\n");  //试卷标题




											var a=0,b=0,c=0; //题目序号
											cho_question.forEach(function(ele){
												if(ele.exam_name==u_exam_name){  //判断科目


													var cat_obj=JSON.parse(ele.cat)
													
													Reflect.ownKeys(cat_obj).forEach(function(key){	    //判断套数名
														if(cat_obj[key]==exam_val){
															cho_str.push(++a+'. '+ele.question+"（）\n"
															+'   A. '+ele.answer_a+'\t'
															+'B. '+ele.answer_b+'\t'
															+'C. '+ele.answer_c+'\t'
															+'D. '+ele.answer_d+'\n\n'
															);// 添加题目
														}
													})



									
												}

											});
											com_question.forEach(function(ele){
												if(ele.exam_name==u_exam_name){
													var cat_obj=JSON.parse(ele.cat)
													Reflect.ownKeys(cat_obj).forEach(function(key){	    //判断套数名
														if(cat_obj[key]==exam_val){
															var acc=ele.question.replace(/？/g,"_________");
															com_str.push(++b+'. '+acc+"。\n\n");
															console.log(acc);
														}
													})
												}
											});


											// console.log("cal begin");
											cal_question.forEach(function(ele){
												if(ele.exam_name==u_exam_name){
													var cat_obj=JSON.parse(ele.cat)
													Reflect.ownKeys(cat_obj).forEach(function(key){	    //判断套数名

														// console.log('key----'+key);
														// console.log('cat_obj[key]'+cat_obj[key]);

														if(cat_obj[key]==exam_val){
															cal_str.push(++c+'. '+ele.question+"\n\n");

															// console.log('ele----'+ele);
															// console.log("cal:cat_obj[key]"+cat_obj[key]);
															// console.log("cal:ele.question"+ele.question);
														}
													})
												}
											});



											var t_text=cho_str.concat(com_str,cal_str).join("");


											$("#exampaper_v").text(t_text);

										}
									})






								});

							});
						});
						
						



					})
},1000);


	
}