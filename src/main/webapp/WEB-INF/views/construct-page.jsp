<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/constructor-style.css">
    <title>Construct Page</title>
</head>
<body>
    <h1>Construction Page</h1>

    <form:form action="/constructor" modelAttribute="book" method="POST">
      <table>
        <tr>
          <td>
            <form:input path="title" placeholder="Enter title" id="text-input" />
          </td>
          <td>
            <form:errors path="title" cssClass="err-message" />
          </td>
        </tr>
        <tr>
          <td>
            <form:input path="author" placeholder="Enter author" id="text-input" />
          </td>
          <td>
            <form:errors path="author" cssClass="err-message" />
          </td>
        </tr>
        <tr>
          <td>
            <form:input path="year" placeholder="Enter year" id="text-input" />
          </td>
          <td>
            <form:errors path="year" cssClass="err-message" />
          </td>
        </tr>
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
      </table>
    </form:form>
</body>
</html>