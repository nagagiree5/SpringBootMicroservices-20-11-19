<%@taglib    uri="http://java.sun.com/jsp/jstl/core"     prefix="c"%>

<h2>
Customer  Details :
</h2>
<hr>
<h3>
Phone  No : ${dto.phoneNo}  <br>
Name         : ${dto.name}  <br>
Age            :  ${dto.age} <br>
</h3>
<hr>
<h2>
   Plan  Details:
</h2>   <hr>
  <h3>
       Plan id  :  ${dto.currentPlan.planId } <br>
       Plan Name : ${dto.currentPlan.planName }  <br>
       Tenure     :  ${dto.currentPlan.tenure } <br>
 </h3>
 <hr>
 <h2>
  Friends  Phone  numbers:
  </h2>   <hr>
  <h4>
   <c:forEach    var="x"     items="${dto.friends}">
        <c:out    value="${x}"/>  <br>
   </c:forEach>        
 </h4>   
   
   
   