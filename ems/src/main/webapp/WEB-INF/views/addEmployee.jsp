<%@taglib  uri="http://www.springframework.org/tags/form"   prefix="form"%>

<form:form  action="save"  method="post"  modelAttribute="employee">
  <table>
     <tr>
          <td>Empno : </td> <td> <form:input  path="empno"/> </td>
     </tr>
     <tr>
          <td>Ename : </td> <td> <form:input  path="ename"/> </td>
     </tr>
     <tr>
          <td>Salary : </td> <td> <form:input  path="salary"/> </td>
     </tr>
     <tr>
          <td>Deptno : </td> <td> <form:input  path="deptno"/> </td>
     </tr>
     <tr>
          <td  colspan="2"  align="center">
                <input  type="submit"   value="SAVE Employee">
          </td>
     </tr>     
  </table>

</form:form>