<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Feeds de Noticias</title>
<style>
*{margin:0px;padding:0px;}
body{color:#444444;font-size:13px;background: #f2f2f2;font-family:"Century Gothic", Helvetica, sans-serif;}
hr{color: gold;}
/*Banner*/
#imgbanner{border-radius: 5px;box-shadow: 3px;}
#imagen{border-radius: 5px;}
/* Footer ...pie de la página*/
  #footer{background: black;padding: 2px 2px 12px 0;width: auto;}
  #content{margin:15px auto;text-align:center;width:600px;position:relative;height:100%;}
</style>
</head>
<body>
    <jsp:useBean id="feeds" class="mx.edu.uacm.practica2.feeds.Feeds"/>
    <div id=content>
        <h2> Feeds de Noticias UACM</h2>
    </div><hr>
    <%= new String("Hello!") %>   
    <% feeds.desplegarFeeds(); %></body>
</html>

