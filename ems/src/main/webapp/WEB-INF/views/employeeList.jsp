<%@taglib  uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>

<%@taglib  uri="http://www.springframework.org/security/tags"   prefix="security" %>

<form  action="search"  method="get"  style="border: 2px solid cyan;">
       Deptno : <input  type="text"   name="deptno">
       &nbsp; &nbsp; &nbsp;
       <input  type="submit"  value="search">
</form>

<hr  color="red">

<table  border="2">
   <tr>
       <th>EMPNO</th>
       <th>ENAME</th>
       <th>SALARY</th>
       <th>DEPTNO</th>
       <th>ACTIONS ON ROW</th>
   </tr>
   <c:if  test="${!empty  employees }">
   
        <c:forEach   items="${employees}"   var="emp">
              <tr>
                    <td><c:out  value="${emp.empno}"/></td>
                    <td><c:out  value="${emp.ename}"/></td>
                    <td><c:out  value="${emp.salary}"/></td>
                    <td><c:out  value="${emp.deptno}"/></td>
                    <td>     
                            <a href="editEmployee?empno=${emp.empno}"><img  src="images/edit.png"  width="50" height="30" ></a>
                            &nbsp; &nbsp; &nbsp;                                        
                            <a href="deleteEmployee?empno=${emp.empno}"><img  src="images/delete.png"  width="50"  height="30" ></a>         
                    </td>
                   <%--  <td>      <security:authorize  access="hasRole('ROLE_ADMIN')">
                            <a href="editEmployee?empno=${emp.empno}"><img  src="images/edit.png"  width="50" height="30" ></a>
                            &nbsp; &nbsp; &nbsp; 
                            </security:authorize>
                            <security:authorize  access="hasRole('ROLE_MANAGER')">
                            <a href="deleteEmployee?empno=${emp.empno}"><img  src="images/delete.png"  width="50"  height="30" ></a>      
                            </security:authorize>
                    </td>
 --%>              </tr>          
        </c:forEach>
   
   </c:if>
</table>
<a  href="logoutuser">Logout</a>


