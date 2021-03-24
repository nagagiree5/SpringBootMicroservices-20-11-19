<%@taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<c:if  test="${message ne null }">
    <font color="red"> Reason: <c:out value="${message}"/></font>
</c:if>

<form  action="doLogin"  method="post">
  Username : <input  type="text"   name="username"> <br>
  Password : <input  type="password"  name="password"> <br>
  Remember Me:<input type="checkbox" name="remember-me" />
  <input  type="submit"   value="submit">
</form>

                
                