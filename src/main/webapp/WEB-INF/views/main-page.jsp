<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BookShelf</title>
  </head>

  <body>
    Welcome to BookShelf.
    <div>

      <table>
        <thead>
          <th>Title</th>
          <th>Author</th>
          <th>Year</th>
          <th>Genre</th>
        </thead>

        <c:forEach var="books" items="${books}">
          <tr>
            <td>${books.title}</td>
            <td>${books.author}</td>
            <td>${books.year}</td>
            <td>${books.genre}</td>
          </tr>
        </c:forEach>
        
      </table>
    
    </div>
  </body>
</html>