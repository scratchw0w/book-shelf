<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Construct Page</title>
</head>
<body>
    <h1>Construct Page</h1>
    <form:form action="/constructor" modelAttribute="book" method="POST">
    <form:input path="title" placeholder="Enter title" id="text-input" />
    <form:input path="author" placeholder="Enter author" id="text-input" />
    <form:input path="year" placeholder="Enter year" id="text-input" />
    <form:select path="genre">
        <form:option value="ACTION" />
        <form:option value="ADVENTURE" />
        <form:option value="CLASSIC" />
        <form:option value="COMEDY" />
        <form:option value="CRIME" />
        <form:option value="DRAMA" />
        <form:option value="HORROR" />
        <form:option value="POETRY" />
    </form:select>
    <input type="submit" value="Save" />
    </form:form>
</body>
</html>