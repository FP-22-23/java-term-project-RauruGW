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
  - C2: It creates an object of the type Movie with the following parameters: String title, String director.
  
- Constraints:
  - R1: The movie must have a title (title != null).
  - R2: The user rating cannot be negative (userRating >= 0).
  
- Criterion of equality: Two movies are equal if the title and the director are the same.
- Criterion of natural order: By release date, title and director.

- Auxiliary types:
  - Language, enumerate. Can take the values: DUTCH, ENGLISH, INDONESIAN, MINANGKABAU.
  - Sinopsis, class. It has two properties: description (type String) and genre (type String), both consultable.

Factory - FactoryMovie
  
Factory class to construct objects of type Movies.
- Movies readMovies(String file): It creates an object of type Movies with the data stored in the csv file.
- Movie parseMovie(String line): It receives a String line of the csv and returns an object of type Movie with the data from the String.

Container type - Movies
- Properties:
  - movies, type List<Movie>, consultable. List of movies.
  - number of movies, type Integer, consultable. Number of movies in the container.

- Constructors:
  - C1: Creates an object of the type Movies without any movie stored.
  - C2: Constructor with a type Collection<Movie> as a parameter. It creates an object of the type Movies with the movies included in the given collection.
  - C3: Constructor with a type Stream<Movie> as a parameter. It creates an object of the type Movies with the movies included in the given stream.
  
- Criterion of equality: Two objects of the type Movies are equal if their properties are.
  
- Other operations: 
  - void addMovie(Movie m): It adds a movie to the object.
  - void addMovies(List<Movie> ms): It adds all the movies from a list to the object.
  - void deleteMovie(Movie m): It deletes the movie given as a parameter from the object.
  - boolean existsPerfectUsersRating(): It returns true if there is any movie that has 10.0 as users rating in the object.
  - Double getVoteAverage(): It returns the average of all the votes of the movies in the object.
  - Movies filterByLanguage(Language l): It returns an object of the type Movies with the movies that are in the language that is received as a parameter.
  - Map<String, List<Movie>> moviesByGenre(): It returns a map in which the keys are the genres of the movies (Which it is a property of the auxiliary type Sinopsis) and the values the movies that are of those genres.
  - Map<String, Integer> getTotalVotesPerGenre(): It returns a map in which the keys are the genres of the movies and the values the sum of all the votes of the movies that are of those genres.
  - Boolean existsPerfectUsersRatingWithStreams(): The same as existsPerfectUsersRating() but using streams.
  - Double getVoteAverageWithStreams(): The same as getVoteAverage() but using streams.
  - Movies filterByLanguageWithStreams(Language l): The same as filterByLanguage(Language l) but using streams.
  - Movie mostWellRatedMovieLanguage(Language l): It returns an object of the type Movie which is the movie with the highest users rating.
  - Movies filterByRatingSortedByReleaseDate(String rating): It returns an object of the type Movies with the movies that have the rating that is received as a parameter sorted by its release date.
  - Map<String, List<Movie>> moviesByGenreWithStreams(): The same moviesByGenreWithStreams() but using streams.
  - SortedSet<String> getTitlesGenre(String genre): It returns a sorted set with the titles of the movies that are of the genre that is received as a parameter.
  - Map<String,Integer> maxVotesByGenre(): It returns a map in which the keys are the genres of the movies and the values the maximun number of votes of that genre.
  - SortedMap<String,List<Movie>> nOldestMoviesByGenre(Integer n): It returns a sorted map that shows the n oldest movies filtered by genre, being the keys of the map the genres of the movie, and the values a list with the n oldest movies of that genre.
  - List<Movie> nOldestMovies(List<Movie> m, Integer n): It returns a list with the n oldest movies from a list received as a parameter. This is an auxiliar method for the method
  nOldestMoviesByGenre(Integer n).
  - Map.Entry<String, Double> mostWellRatedMovie(): It returns an entry of the highest rated movie being the key the title of the movie and the value its users rating.
