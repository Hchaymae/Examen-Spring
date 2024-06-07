<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="webjars/bootstrap/5.3.3/css/bootstrap.css" rel="stylesheet">
    <link href="css/styles.css" rel="stylesheet">
    <title>Affectation</title>
</head>
<body>
<sec:authorize access="hasRole('Manager')">
    <form>
        <div class="container-fluid d-flex justify-content-center align-items-center" style="height: 100vh; width:auto;">
            <div class="d-flex flex-column align-items-center">
                <div class="text-center mb-5">
                    <h1>Employee Affectation</h1>
                </div>

                <div>
                    <a href="list.jsp" style="text-decoration: none; color:cornflowerblue;">Employees</a>
                    |
                    <a href="affectation.jsp" style="text-decoration: none; color:cornflowerblue;">Back To Home</a>
                    |
                    <a href="addProject.jsp" style="text-decoration: none; color:cornflowerblue;">Add Project</a>
                </div>
                <br/><br/>
                <div class="mb-5">
                    <label>Employee Name</label>
                    <select name="selectedEmployee" style="width: 200px;" class="form-select">
                        <c:forEach var="employee" items="${employees}">
                            <option value="${employee.id}">${employee.name}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="mb-5">
                    <label>Project Name</label>
                    <select name="selectedProject" size="3" class="form-select" style="width: 200px;">
                        <c:forEach var="project" items="${projects}">
                            <option value="${project.id}">${project.name}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="mb-5">
                    <label>Implications</label>
                    <select name="selectedPercentage" style="width: 200px;" class="form-select">
                        <option value="10">10%</option>
                        <option value="20">20%</option>
                        <option value="30">30%</option>
                    </select>
                </div>

                <div>
                    <input type="submit" value="Affecter projet" class="btn btn-primary text-center" style="margin-bottom:10px;" />
                </div>
            </div>
        </div>
    </form>
</sec:authorize>

</body>
</html>