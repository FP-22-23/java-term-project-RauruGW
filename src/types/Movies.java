package types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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
	
	public Double getVoteAverage() {
		Double res = 0.0;
		for (Movie m : movies) {
			res += m.getVotes();
		}
		return res/movies.size();
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
}
