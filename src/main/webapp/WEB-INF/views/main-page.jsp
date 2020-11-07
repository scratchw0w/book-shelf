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
    
    <form action="/" method="POST">
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

    <form action="/filter" method="GET">
      <input type="checkbox" name="genreType" value="ACTION" >ACTION
      <input type="checkbox" name="genreType" value="ADVENTURE" >ADVENTURE
      <input type="checkbox" name="genreType" value="CLASSIC" >CLASSIC
      <input type="checkbox" name="genreType" value="COMEDY" >COMEDY
      <input type="checkbox" name="genreType" value="CRIME" >CRIME
      <input type="checkbox" name="genreType" value="DRAMA" >DRAMA
      <input type="checkbox" name="genreType" value="HORROR" >HORROR
      <input type="checkbox" name="genreType" value="POETRY" >POETRY
      <input type="submit" value="Enter">
    </form>

  </body>
</html>