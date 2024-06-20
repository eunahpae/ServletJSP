<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Info</title>
</head>
<body>
    <h1>${ param.empId }번 직원의 정보</h1>
    <h4>성명 : ${ selectedEmp.empName }</h4>
    <h4>부서 코드 : ${ selectedEmp.deptCode }</h4>
    <h4>직급 코드 : ${ selectedEmp.jobCode }</h4>
    <h4>급여 : ${ selectedEmp.salary }</h4>
</body>
</html>
