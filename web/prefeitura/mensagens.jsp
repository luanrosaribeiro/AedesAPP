<%
  if(session.getAttribute("erro") != null) {
      out.print("<div class='alert alert-danger' role='alert'>" + session.getAttribute("erro") + "</div>");
      session.setAttribute("erro", null);
  }  
  if(session.getAttribute("ok") != null) {
      out.print("<div class='alert alert-success' role='alert'>" + session.getAttribute("ok") + "</div>");
      session.setAttribute("ok", null);
  }  
%> 