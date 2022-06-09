<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Costumer Confirmation</title>
</head>
<body>
    The costumer is confirmed: ${customer.firstName} ${customer.lastName}

<br><br>
Free passes : ${customer.freePasses}

    <br><br>
    PostalCode : ${customer.postalCode}
    <br><br>
    Course code : ${customer.courseCode}
</body>
</html>