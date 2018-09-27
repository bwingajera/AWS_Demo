<!DOCTYPE html>
<html lang="en">
<head>
    <title>Upload MultipartFile</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
	<script src="/js/postrequest.js"></script>
	<script src="/js/getrequest.js"></script>
</head>
 
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-5">
				<h3>Upload MultipartFile to S3</h3>
				<form method="POST" enctype="multipart/form-data" id="fileUploadForm">
					<div class="form-group">
						<label class="control-label" for="uploadfile">Upload File:</label>
						<input type="file" class="form-control" id="uploadfile" placeholder="Upload File"  name="uploadfile"></input>
					</div>
					
			        <button type="submit" class="btn btn-default" id="btnSubmit">Upload</button>
			        <button type="button" class="btn btn-default" id="btnGetFiles">Files</button>
				</form>
				<hr/>
				<div id="listFiles">
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
$(document).ready( () => {
    $("#btnSubmit").click((event) => {
        //stop submit the form, we will post it manually.
        event.preventDefault();
        doAjax();
    });
 
});
 
function doAjax() {
 
    // Get form
    var form = $('#fileUploadForm')[0];
    var data = new FormData(form);
 
    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/api/file/upload",
        data: data,
        processData: false, //prevent jQuery from automatically transforming the data into a query string
        contentType: false,
        cache: false,
        success: (data) => {
            $("#listFiles").text(data);
        },
        error: (e) => {
            $("#listFiles").text(e.responseText);
        }
    });
    
    
	$("#btnGetFiles").click( (event) => {
		event.preventDefault();
		ajaxGet();
	});
	
 // DO GET
	function ajaxGet(){
		$.ajax({
			type : "GET",
			dataType: "json",	
			url : "/api/file/all",
			success: (data) => {
				//clear old data
				$("#listFiles").html("");
				
				/*
					render list of files
				*/
				$("#listFiles").append('<ul>');
				$.each(data, (index, filename) => {
					$("#listFiles").append('<li><a href=/api/file/' + filename + '>' + filename + '</a></li>');
				});
				$("#listFiles").append('</ul>');
			},
			error : (err) => {
				$("#listFiles").html(err.responseText);
			}
		});	
	}
}

</script>
</html>