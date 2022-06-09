<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
            <form:form action="processForm" modelAttribute="student">

                FirstName : <form:input path="firstName"></form:input>
                <br><br>
                Last name: <form:input path="lastName"></form:input>

                <br><br>
                Country:

                <form:select path="Country" items="${student.countryOptions}">


                </form:select>
                <br><br>
                <form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}"  />
                <br><br>
                Operating systems:
               Linux <form:checkbox path="operatingSystems" value="Linux"></form:checkbox>
               MacOS <form:checkbox path="operatingSystems" value="Mac"></form:checkbox>
               Windows  <form:checkbox path="operatingSystems" value="MS Windows"></form:checkbox>




                <input type="submit" value="Submit">
            </form:form>
</body>
</html>