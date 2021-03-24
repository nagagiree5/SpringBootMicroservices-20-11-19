<%@taglib   uri="http://www.springframework.org/tags/form"   prefix="form"%>
<form:form    action="doLogin"    method="post"    modelAttribute="login">
    <table>
        <tr>
            <td>Phone No: </td> <td> <form:input   path="phoneNo"/> </td>
       </tr>
       <tr>
            <td>Password: </td> <td> <form:password  path="password"/> </td>            
       </tr>
       <tr>
          <td  colspan="2"> <input  type=submit   value="LOGIN">   </td>
       </tr>          
    </table>
 
</form:form>