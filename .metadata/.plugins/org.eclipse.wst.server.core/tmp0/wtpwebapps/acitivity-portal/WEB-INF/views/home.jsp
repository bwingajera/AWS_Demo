<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	
  <style>
      body {
          text-align: center;
      }

      section {
          width: 81%;
          margin: auto;
          text-align: left;
      }
  </style>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, maximum-scale=1.0"/>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/froala_editor.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/froala_style.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/plugins/code_view.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/plugins/colors.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/plugins/draggable.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/plugins/emoticons.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/plugins/image_manager.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/plugins/image.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/plugins/line_breaker.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/plugins/table.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/plugins/char_counter.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/plugins/video.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/plugins/fullscreen.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/plugins/file.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/plugins/quick_insert.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.3.0/codemirror.min.css">
  
</head>

<body>
<section id="editor">
    <form action="${pageContext.request.contextPath }/save-question" id="fileUploadForm" method="post">
    
    	<h1>Admin Form</h1>

	Activity Name<input type="text"  name="activity_name" id="activity_name"><br>
	How To play <textarea rows="2" cols="2" name="tip" id="tip"></textarea><br>
	Hint<input type="text"  name="hint" id="hint">
	Activity Type<select name="activity_type" id="activity_type">
		<c:forEach var="activityType" items="${activityTypes}">
			<option value="${activityType.id }">${activityType.name }</option>		
		</c:forEach>
				
			</select>
	Template:<select name="template" id="template">
				<option value="template1">Template 1</option>
				<option>Template 2</option>
				<option>Template 3</option>
				<option>Template 4</option>
				<option>Template 5</option>
				<option>Template 6</option>
			</select>

<!--     Option1<input type="checkbox" name="ans" value="1" /> 
        Option2<input type="checkbox" name="ans" value="2" /> 
            Option3<input type="checkbox" name="ans" value="3" /> 
                Option4<input type="checkbox" name="ans" value="4" />  -->

      Question:<div id='question' style="margin-top: 30px;">
    </div>
	<div id="option_section">
	
	</div>
  <!--   Option 1<div id='opt1' style="margin-top: 30px;">
    </div>

    Option 2<div id='opt2' style="margin-top: 30px;">
    </div>
    Option 3<div id='opt3' style="margin-top: 30px;">
    </div>
     Option 4<div id='opt4' style="margin-top: 30px;">
    </div> -->
    <input type="button" value="Save" id="save-activity">
    </form>
  </section>
  
  <div>
  	<button id="add_option">Add Option</button>
  </div>

  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.3.0/codemirror.min.js"></script>
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.3.0/mode/xml/xml.min.js"></script>

  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/froala_editor.min.js" ></script>

  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/align.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/code_beautifier.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/code_view.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/colors.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/draggable.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/emoticons.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/font_size.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/font_family.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/image.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/file.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/image_manager.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/line_breaker.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/link.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/lists.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/paragraph_format.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/paragraph_style.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/video.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/table.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/url.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/entities.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/char_counter.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/inline_style.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/save.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/fullscreen.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/quote.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/quick_insert.min.js"></script>
    <script type="text/javascript" src="https://editor-latest.s3.amazonaws.com/js/third_party/image_aviary.min.js"></script>

  <script>
  $(function(){
      var options=[];
   	  var index=0;
   	  
	  $('#question').froalaEditor({
    	  imageUploadParam: 'file',
   	 //     initOnClick: true,
   // 	  imageUploadURL: '${pageContext.request.contextPath }/upload_image-base',
      }).on('froalaEditor.image.beforeUpload', function (e, editor, files) {
          if (files.length) {
              var reader = new FileReader();
              reader.onload = function (e) {
                 var result = e.target.result;
                 editor.image.insert(result, null, null, editor.image.get());
              };
              reader.readAsDataURL(files[0]);
            }
            editor.popups.hideAll();
            
            return false;
          });
      
      $('#add_option').click(function(){
    	  
    		index++;  
          	$('#option_section').append('option'+index+'<input type="checkbox" name="ans" value="'+index+'" /><div id="opt'+index+'" style="margin-top: 30px;">');
          	
          	if (!$('#opt'+index).data('froala.editor')) {
          	      $('#opt'+index).froalaEditor().on('froalaEditor.image.beforeUpload', function (e, editor, files) {
          	          if (files.length) {
         	              var reader = new FileReader();
	          	          reader.onload = function (e) {
         	                  var result = e.target.result;
          	                  editor.image.insert(result, null, null, editor.image.get());
          	              };
          	              reader.readAsDataURL(files[0]);
          	            }
          	            editor.popups.hideAll();
          	            return false;
          	          });
          	      ;
          	    }
          //	$('#opt'+index).editable("setHTML", "<p></p>", false);
      
      });
	  $('#save-activity').click(function(){
		
		 var data = new FormData();
		  data.append("activity_name",  $('#activity_name').val());
		  data.append("hint",  $('#hint').val());
		  data.append("activity_type",  $('#activity_type').val());
		  data.append("template",$('#template').val() );
		  data.append("ans", $('#opt'+$('input[type="checkbox"]:checked').val()).froalaEditor('html.get'));
		  data.append("tip", $('#tip').val());
		  data.append("question",$('#question').froalaEditor('html.get') );
		  for(var i=1;i<=index;i++){
			  data.append("opt"+i, $('#opt'+i).froalaEditor('html.get'));
		  }	 
		  
		  /* {
			   "activity_name": $('#activity_name').val(),
			   "hint": $('#hint').val(),
			   "activity_type": $('#activity_type').val(),
			   "template": $('#template').val(),
			   "ans": $('#opt'+$('input[type="checkbox"]:checked').val()).froalaEditor('html.get'),
			   "tip": $('#tip').val(),
			   "question": $('#question').froalaEditor('html.get'),
			 /*   "opt1": $('#opt1').froalaEditor('html.get'),
			   "opt2": $('#opt2').froalaEditor('html.get'),
			   "opt3": $('#opt3').froalaEditor('html.get'),
			   "opt4": $('#opt4').froalaEditor('html.get') 
		   } */
		  $.ajax({
			   url: '${pageContext.request.contextPath }/save-question',
			   type: 'post',
			   processData: false,
			   contentType: false,
			   data:data/*  {
				   "activity_name": $('#activity_name').val(),
				   "hint": $('#hint').val(),
				   "activity_type": $('#activity_type').val(),
				   "template": $('#template').val(),
				   "ans": $('#opt'+$('input[type="checkbox"]:checked').val()).froalaEditor('html.get'),
				   "tip": $('#tip').val(),
				   "question": $('#question').froalaEditor('html.get'),
				   "opt1": $('#opt1').froalaEditor('html.get'),
				   "opt2": $('#opt2').froalaEditor('html.get'),
				   "opt3": $('#opt3').froalaEditor('html.get'),
				   "opt4": $('#opt4').froalaEditor('html.get') 
			   } */,
			   error: function() {
			      alert("errop")
			   },
			  success: function(data) {
			     alert(data)
			   }
			 
			});
	  }) 

    });
  </script>
</body>
</html>
