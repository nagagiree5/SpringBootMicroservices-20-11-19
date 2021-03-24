<%@taglib   uri="http://www.springframework.org/tags/form"     prefix="form"%>
<form:form    action="signup"    method="post"   modelAttribute="customer">
    <table>
         <tr>
             <td>Phone No : </td>   <td> <form:input    path="phoneNo"/> </td>
         </tr>             
         <tr>
             <td>Name : </td>   <td> <form:input    path="name"/> </td>
         </tr>
         <tr>
             <td>password : </td>   <td> <form:password    path="password"/> </td>
         </tr>
         <tr>
             <td>age : </td>   <td> <form:input    path="age"/> </td>
         </tr>
         <tr>
             <td>Plan Id : </td>   <td> <form:input    path="planId"/> </td>
         </tr>
         
          <tr>
              <td   colspan="2">  <input  type=submit   value="submit">  </td>
          </tr>    
    </table>
</form:form>

