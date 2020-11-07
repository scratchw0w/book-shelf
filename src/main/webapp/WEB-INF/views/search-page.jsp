<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BookShelf</title>
</head>
<body>
    <h1>Search Page!</h1>

    <table>
      <c:forEach items="${books}" var="tempBooks">
      <tr>${tempBooks.title}</tr>
      <tr>${tempBooks.author}</tr>
      <tr>${tempBooks.year}</tr>
      <tr>${tempBooks.genre}</tr>  
      </c:forEach>
    </table>
</body>
</html>