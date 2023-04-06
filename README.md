# java-term-project-RauruGW
java-term-project-RauruGW created by GitHub Classroom

JAVA PROJECT - RAÚL CALERO CAPOTE

Structure of the folders:
- /src:
  · types: Package with the types of the project
  · test: Package with the test classes of the project
  · utils: Package with the util classes
- /data:
  ·indonesian_movies.csv
  
Dataset Structure:

The dataset indonesian_movies.csv has 11 columns and each row contains data about an indonesian movie. Description fo the columns:
- title: type string, title of the movie.
- release_date: type date, release date of the movie.
- descrption: type string, a little description of the movie.
- genre: type string, genre of the movie (Drama, Horror, Action,...).
- rating: type string, age restriction (13+, 17+,...).
- users_rating: type double, average punctuation of the users.
- votes: type integer, number of votes of the movie.
- language: type string, language in which the movie was made.
- director: type string, director of the movie.
- actors: type list of string, list of the main actors of the movie.
- runtime: type integer, duration in minutes of the movie.

Implemented types:

Base type - Movie
- Properties:
  - title, type String, consultable. Title of the movie.
  - releaseDate, type LocalDate, consultable. Release date of the movie.
  - sinopsis, type Sinopsis, consultable. Sinopsis of the movie with its description and its genre.
  - rating, type String, consultable. Age restriction of the movie.
  - usersRating, type Double, consultable. Avererage punctuation of the users.
  - votes, type Integer, consultable. Number of votes of the movie.
  - language, type Language, consultable. Language in which the movie was made.
  - director, type String, consultable. Director of the movie.
  - actor, type List<String>, consultable. List of the main actors of the movie.
  - runtime, type Duration, consultable. Duration in minutes of the movie.
  - wellRated, type Boolean, consultable and derived. Indicate if the movie is well rated by the users (usersRating > 7.0).
  
- Constructors:
  - C1: It has a parameter for each basic property of the type.
  - C2: It creates an object of type Movie with the following parameters: String title, String director.
  
- Constraints:
  - R1: The movie must have a title (title != null).
  - R2: The user rating cannot be negative (userRating >= 0).
  
- Criterion of equality: Two movies are equal if the title and the director are the same.
- Criterion of natural order: By release date, title and director.

- Auxiliary types:
  - Language, enumerate. Can take the values: Dutch, English, French, Indonesian, Japanese, Malay, Mandarin, Minangkabau.
  - Sinopsis, class. It has two properties: description (type String) and genre (type String), both consultable.
