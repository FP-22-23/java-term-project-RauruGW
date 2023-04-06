package types;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import utils.Checkers;

public class Movie implements Comparable<Movie>{
	
	private String title;
	private LocalDate releaseDate;
	private Sinopsis sinopsis;
	private String rating;
	private Double users_rating;
	private Integer votes;
	private Language lang;
	private String director;
	private List<String> actors;
	private Duration runtime;
	
	public Movie(String title, LocalDate releaseDate, Sinopsis sinopsis,
			String rating, Double users_rating, Integer votes, Language lang,
			String director, List<String> actors, Duration runtime) {
		Checkers.check("The movie must have a title", title != null);
		Checkers.check("The user rating cannot be negative", users_rating >= 0);
		this.title = title;
		this.releaseDate = releaseDate;
		this.sinopsis = sinopsis;
		this.rating = rating;
		this.users_rating = users_rating;
		this.votes = votes;
		this.lang = lang;
		this.director = director;
		this.actors = actors;
		this.runtime = runtime;
	}
	
	public Movie (String title, String director) {
		this.title = title;
		releaseDate = null;
		sinopsis = null;
		rating = null;
		users_rating = null;
		votes = null;
		lang = null;
		this.director = director;
		actors = null;
		runtime = null;
	}

	public String getTitle() {
		return title;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public Sinopsis getSinopsis() {
		return sinopsis;
	}

	public String getRating() {
		return rating;
	}

	public Double getUsers_rating() {
		return users_rating;
	}

	public Integer getVotes() {
		return votes;
	}

	public Language getLang() {
		return lang;
	}

	public String getDirector() {
		return director;
	}

	public List<String> getActors() {
		return actors;
	}

	public Duration getRuntime() {
		return runtime;
	}
	
	public boolean getWellRated() {
		boolean res = false;
		if (getUsers_rating() >= 7.0) {
			res = true;
		}
		return res;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", relDate=" + releaseDate + ", sinopsis=" + sinopsis + ", rating=" + rating
				+ ", users_rating=" + users_rating + ", votes=" + votes + ", lang=" + lang + ", director=" + director
				+ ", actors=" + actors + ", runtime=" + runtime + "]";
	}

	//Two movies are equal if the title, the director, the genre and the description are the same

	@Override
	public int hashCode() {
		return Objects.hash(director, title);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(director, other.director) && Objects.equals(title, other.title);
	}
	
	// Movies are ordered by release date, title and director
	
	public int compareTo(Movie m) {
		int res = 0;
		if(getReleaseDate()!= null && m.getReleaseDate() != null) {
			res = getReleaseDate().compareTo(m.getReleaseDate());
			if (res == 0) {
				res = getTitle().compareTo(m.getTitle());
				if (res == 0) {
					res = getDirector().compareTo(m.getDirector());
				}
			}
		}
		
		return res;
	}
	

}
