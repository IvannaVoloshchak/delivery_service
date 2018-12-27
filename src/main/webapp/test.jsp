<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>

<html>
   <head>
      <title>JSTL fmt:message Tag</title>
   </head>

   <body>
      <fmt:setLocale value = "en"/>
      <fmt:setBundle basename = "my.delivery.app.i18n.pageContent" var = "lang"/>

      <fmt:message key = "count.one" bundle = "${lang}"/><br/>
      <fmt:message key = "count.two" bundle = "${lang}"/><br/>
      <fmt:message key = "count.three" bundle = "${lang}"/><br/>

   </body>
</html>