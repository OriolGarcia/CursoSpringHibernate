<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>hello World</title>
</head>
<body>

Escribe tu nombre:
    <form:form action="processForm" method="get" modelAtribute="student">
        First  name:<form:input type="text" path="firstName"/>
        <br><br>
        Last name:<form:input path="lastName"/>
        <br>
    <input type="submit" value="Submit">
    </form:form>
</body>
</html>