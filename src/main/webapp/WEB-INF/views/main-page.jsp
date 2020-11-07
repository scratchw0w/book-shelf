<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BookShelf</title>
    <link rel="stylesheet" href="styles/main-page-style.css">
  </head>

  <body>
    <h1 id = "top-label">Book Shelf</h1>
    
    <hr id = "top-line">
    
    <form action="/search" method="POST">
      <input type="text" name="bookParams" >
      <input type="submit" value="Enter">
    </form>

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

    <form action="" method="GET">
      <input type="checkbox" >ACTION
      <input type="checkbox">ADVENTURE
      <input type="checkbox">CLASSIC
      <input type="checkbox">COMEDY
      <input type="checkbox">CRIME
      <input type="checkbox">DRAMA
      <input type="checkbox">HORROR
      <input type="checkbox">POETRY
    </form>
  </body>
</html>