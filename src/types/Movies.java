package types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Movies {
	
	private List<Movie> movies;
	
	public Movies() {
		movies = new ArrayList<Movie>();
	}
	
	public Movies(Collection<Movie> movies) {
		this.movies = new ArrayList<Movie>();
	}
	
	public Movies(Stream<Movie> m) {
		movies = m.collect(Collectors.toList());
	}
	
	public List<Movie> getMovies() {
		return movies;
	}

	@Override
	public int hashCode() {
		return Objects.hash(movies);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movies other = (Movies) obj;
		return Objects.equals(movies, other.movies);
	}

	@Override
	public String toString() {
		return "Movies [movies=" + movies + "]";
	}
	
	public Integer getNumberofMovies() {
		return movies.size();
	}
	
	public void addMovie(Movie m) {
		movies.add(m);
	}
	
	public void addMovies(List<Movie> ms) {
		movies.addAll(ms);
	}
	
	public void deleteMovie(Movie m) {
		for(Movie movie : movies) {
			if(movie.equals(m) ) {
				movies.remove(movie);
			}
		}
	}
	
	public boolean existsPerfectUsersRating() {
		boolean res = false;
		for (Movie m : movies) {
			if (m.getUsersRating() == 10.0) {
				res = true;
				break;
			}
		}
		return res;
	}
	
	public Boolean existsPerfectUsersRatingWithStreams() {
		return movies.stream().anyMatch(x->x.getUsersRating().equals(10.0));
	}
	
	public Double getVoteAverage() {
		Double res = 0.0;
		for (Movie m : movies) {
			res += m.getVotes();
		}
		return res/movies.size();
	}
	
	public Double getVoteAverageWithStreams() {
		return movies.stream().mapToInt(x->x.getVotes()).average().getAsDouble();
	}
	
	public Movies filterByLanguage(Language l) {
		Movies res = new Movies();
		for(Movie m : movies) {
			if (m.getLang() == l) {
				res.addMovie(m);
			}
		}
		return res;
	}
	
	public Movies filterByLanguageWithStreams(Language l) {
		Movies res = new Movies();
		res.addMovies(movies.stream().filter(x->x.getLang().equals(l)).collect(Collectors.toList()));
		return res;
	}
	
	public Map<String, List<Movie>> moviesByGenre(){
		Map<String, List<Movie>> genres = new HashMap<String, List<Movie>>();
		for(Movie m: movies) {
			if(genres.containsKey(m.getSinopsis().getGenre())) {
				genres.get(m.getSinopsis().getGenre()).add(m);
			}else {
				List<Movie> l = new ArrayList<Movie>();
				l.add(m);
				genres.put(m.getSinopsis().getGenre(), l);
			}
		}
		return genres;
	}
	
	public Map<String, List<Movie>> moviesByGenreWithStreams(){
		return movies.stream().collect(Collectors.groupingBy(Movie::getGenre));
	}
	
	public Map<String, Integer> getTotalVotesPerGenre(){
		Map<String, Integer> genres = new HashMap<String, Integer>();
		for(Movie m : movies) {
			if(genres.containsKey(m.getSinopsis().getGenre())) {
				genres.put(m.getSinopsis().getGenre(), genres.get(m.getSinopsis().getGenre()) + m.getVotes());
			}else {
				genres.put(m.getSinopsis().getGenre(), m.getVotes());
			}
		}
		return genres;
	}
	
	public Movie mostWellRatedMovieLanguage(Language l) {
		return movies.stream().filter(x->x.getLang().equals(l))
				.max(Comparator.comparing(Movie::getUsersRating)).orElse(null);
	}
	
	public Movies filterByRatingSortedByReleaseDate(String rating) {
		Movies res = new Movies();
		res.addMovies(movies.stream().filter(x->x.getRating().equals(rating))
		.sorted(Comparator.comparing(Movie::getReleaseDate)).collect(Collectors.toList()));
		return res;
	}
	
	public SortedSet<String> getTitlesGenre(String genre){
		return movies.stream().filter(x->x.getGenre().equals(genre))
				.collect(Collectors.mapping(Movie::getTitle,Collectors.toCollection(TreeSet::new)));
	}
	
	public Map<String,Integer> maxVotesByGenre(){
		return movies.stream()
				.collect(Collectors.groupingBy(x->x.getGenre(), Collectors
						.collectingAndThen(Collectors
								.maxBy(Comparator.comparing(Movie::getVotes)), x->x.orElse(null)
								.getVotes())));
	}
	
	public SortedMap<String,List<Movie>> nOldestMoviesByGenre(Integer n){
		Map<String,List<Movie> > sm = movies.stream()
				.collect(Collectors.groupingBy(Movie::getGenre));
		return new TreeMap<>(sm.entrySet().stream()
				.collect(Collectors.toMap(x->x.getKey(),x->nOldestMovies(x.getValue(),n))));
		
	}
	
	private List<Movie> nOldestMovies(List<Movie> m, Integer n){
		return m.stream().sorted(Comparator.comparing(Movie::getReleaseDate)).limit(n)
				.collect(Collectors.toList());
	}
	
	public Map.Entry<String, Double> mostWellRatedMovie(){
		Map<String,Double> m = movies.stream()
				.collect(Collectors.toMap(x->x.getTitle(),x->x.getUsersRating()));
		return m.entrySet().stream().max(Comparator.comparing(x->x.getValue())).orElse(null);
	}
}
