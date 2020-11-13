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
    
    <div class="top-section">
      <a href="/"><h1 id="top-label">Book Shelf</h1></a>
      <hr id = "top-line">
    </div>
    <div class="search-section">
      <form action="/" method="POST">
        <input type="text" name="bookParams" id="search-field" placeholder="Title or Author..">
        <input type="submit" id="search-btn" value="Find">
      </form>
    </div>
    <div class="filter-section">
      <form action="/filter" method="GET">
        <input type="checkbox" name="genreType" value="ACTION" >ACTION<br>
        <input type="checkbox" name="genreType" value="ADVENTURE" >ADVENTURE<br>
        <input type="checkbox" name="genreType" value="CLASSIC" >CLASSIC <br>
        <input type="checkbox" name="genreType" value="COMEDY" >COMEDY<br>
        <input type="checkbox" name="genreType" value="CRIME" >CRIME<br>
        <input type="checkbox" name="genreType" value="DRAMA" >DRAMA<br>
        <input type="checkbox" name="genreType" value="HORROR" >HORROR<br>
        <input type="checkbox" name="genreType" value="POETRY" >POETRY<br>
        <input type="submit" id="filter-btn" value="Enter">
      </form>
    </div>

    <div class="book-section-wrapper">
      <c:forEach var="books" items="${books}">
        <div class="book-section">
          <table id="book-table">
            <thead id = "table-head">
              <th>Title</th>
              <th>Author</th>
            </thead>
            <tr>
              <td>${books.title}</td>
              <td>${books.author}</td>
            </tr>
            <thead id = "table-head">
              <input type="button" id="delete-btn" value="Delete">
              <th>Year</th>
              <th>Genre</th>
            </thead>
            <tr>
              <td>${books.year}</td>
              <td>${books.genre}</td>
            </tr>
          </table>
        </div>
      </c:forEach>
    </div>
    <div class="control-section">
      <a href="/constructor" id="add-link">Add New Book</a>
      <a id="delete-link">Delete Existing Book</a>
    </div>

    <div>
      <a href="https://github.com/scratchw0w/book-shelf" id="author-id">@scratchy</a>
    </div>
  </body>
</html>