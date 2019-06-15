<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${message}</title>
</head>
<body>
<h1>${message2}</h1>  <!--action="${pageContext.request.contextPath}/upload/save"  -->
<form method="POST" enctype="multipart/form-data" id="fileUploadForm" action="${pageContext.request.contextPath}/upload/save">
    <input type="text" name="filename"/><br/><br/>
    <input type="file" name="files"/><br/><br/>
   <!--  <input type="file" name="files"/><br/><br/> -->
    <input type="submit" value="Submit" id="btnSubmit"/>
</form>

<!-- <h1>Ajax Post Result</h1> -->
<pre>
    <span id="result">${message}</span>
    <span id="feedback"></span>
</pre>

<script type="text/javascript"  src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
 <%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"/></script> --%>
</body>
<!-- <script>
function fire_ajax_submit() {
alert("hiii")
    // Get form
    var form = $('#fileUploadForm')[0];

    var data = new FormData(form);

    data.append("CustomField", "This is some extra data, testing");

    $("#btnSubmit").prop("disabled", true);

    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/upload/save",
        data: data,
        //http://api.jquery.com/jQuery.ajax/
        //https://developer.mozilla.org/en-US/docs/Web/API/FormData/Using_FormData_Objects
        processData: false, //prevent jQuery from automatically transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {

            $("#feedback").text(data);
            console.log("SUCCESS : ", data);
            $("#btnSubmit").prop("disabled", false);

        },
        error: function (e) {

            $("#feedback").text(e.responseText);
            console.log("ERROR : ", e);
            $("#btnSubmit").prop("disabled", false);

        }
    });

}

</script> -->
</html>