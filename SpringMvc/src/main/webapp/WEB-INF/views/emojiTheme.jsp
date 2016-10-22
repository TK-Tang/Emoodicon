<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>


<html>
  
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css"
    rel="stylesheet" type="text/css">
    <link href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css"
    rel="stylesheet" type="text/css">
  </head>
  
  <body>
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <h1>Emoji themes</h1>
          </div>
        </div>
      </div>
    </div>
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-10">
            <form class="form-horizontal" role="form">
              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                  <div class="checkbox">
                    <label>
                      <input type="checkbox">New &nbsp;emoji &nbsp;theme?</label>
                  </div>
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="inputEmail3" class="control-label">New theme name</label>
                </div>
                <div class="col-sm-10">
                  <input type="text" class="form-control" id="inputEmail3" placeholder=${u.nameFirst}>
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label class="control-label">Existing theme</label>
                </div>
                <div class="col-sm-10">
                  <select class="form-control">
                  	<c:forEach items="${themeNames}" var="item" varStatus="count"> 
            			<option value="${count.index}">${item}</option>
        			</c:forEach>
                  </select>
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                  <div class="checkbox">
                    <label>
                      <input type="checkbox">Project default</label>
                  </div>
                </div>
              </div>
            </form>
            <div class="row">
              <div class="col-md-4">
                <img src="data:image/jpeg;charset=utf-8;base64,${emojiImg1}"
                class="img-responsive">
              </div>
              <div class="col-md-4">
                <img src="data:image/jpeg;charset=utf-8;base64,${emojiImg2}"
                class="img-responsive">
              </div>
              <div class="col-md-4">
                <img src="data:image/jpeg;charset=utf-8;base64,${emojiImg3}"
                class="img-responsive">
              </div>
            </div>
            <div class="row">
              <div class="col-md-4">
                <form role="form">
                  <div class="form-group">
                    <label class="control-label">Low mood</label>
                    <input type="file">
                  </div>
                </form>
              </div>
              <div class="col-md-4">
                <form role="form">
                  <div class="form-group">
                    <label class="control-label">Medium mood</label>
                    <input type="file">
                  </div>
                </form>
              </div>
              <div class="col-md-4">
                <form role="form">
                  <div class="form-group">
                    <label class="control-label">High mood</label>
                    <input type="file">
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <button type="submit" class="btn btn-default">Save</button>
          </div>
        </div>
      </div>
    </div>
  </body>

</html>