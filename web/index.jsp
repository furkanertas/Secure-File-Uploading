<%--
  Created by IntelliJ IDEA.
  User: Furkan
  Date: 8.8.2015
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
      <title>Safely Upload</title>
      <link type="text/css" rel="stylesheet" href="materialize/css/materialize.min.css"  media="screen,projection"/>
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
      <script type="text/javascript" src="materialize/js/materialize.min.js"></script>
      <link href="materialize//font-awesome/css/font-awesome.min.css" rel="stylesheet">

  </head>
  <body>

  <main>
      <div class="container">
          <div class="row">
              <div class="col s12 m7">
                  <div class="card medium">
                      <div class="card-image">
                          <img src="image/sample-1.jpg">
                          <span class="card-title">Upload Image</span>
                      </div>
                      <div class="card-content">
                          <p>Buradan .jpg fotoğraflarınızı güvenli bir şekilde yükleyebilirsiniz.</p>
                      </div>
                      <div class="card-action">
                          <form action="upload" method="post" enctype="multipart/form-data">
                          <div class="col s11" style="margin: -10px">
                              <div class="file-field input-field">
                                  <div class="btn">
                                      <span>File</span>
                                      <input type="file" name="file">
                                  </div>
                                  <div class="file-path-wrapper">
                                      <input class="file-path validate" type="text">
                                  </div>
                              </div>
                          </div>
                          <div class="col s1" style="margin: 0px">
                              <button type="submit" class="btn-floating btn-large waves-effect waves-light btn"><i class="material-icons">cloud_upload</i></button>
                          </div>
                          </form>
                      </div>
                  </div>

              </div>
          </div>
          <div class="row">
              <div class="col s12 m7">
                  <c:if test="${not empty error}">
                      <div class="card-panel red lighten-1">
                            <span class="white-text"style="font-size: 20px"> <i class="fa fa-times-circle-o"></i> ${error} </span>
                      </div>
                  </c:if>
                  <c:if test="${not empty ok}">
                      <div class="card-panel green lighten-1">
                          <span class="white-text" style="font-size: 20px"> <i class="fa fa-check-circle-o"></i> ${ok} </span>
                      </div>
                  </c:if>
              </div>
          </div>
      </div>
  </main>

  </body>
</html>
