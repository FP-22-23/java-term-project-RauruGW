package test;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import types.FactoryMovie;
import types.Language;
import types.Movie;
import types.Movies;
import types.Sinopsis;

public class TestMovies {
	
	public static void main(String[] args) {
		
		Movies ms1 = FactoryMovie.readMovies("data/indonesian_movies.csv");
		System.out.println(ms1.getNumberofMovies());
		Sinopsis s1 = new Sinopsis("Alfi meets Alana, a new student at school.It turns out that they are in one class and sitting next to each other. Instead of getting along, they often argue because they both are stubborn.","Drama");
		Sinopsis s2 = new Sinopsis("Randu and Dinar are happy because Dinar conceives for the fourth month. However, their happiness slowly disappears when a middle-aged woman, Sukma", "Horror");
		Movie m1 = new Movie("Dignitate",LocalDate.of(2020,5,10), s1, "17+", 6.4, 20, Language.INDONESIAN, "Fajar Nugros",List.of("Al Ghazali", "Caitlin Halderman", "Giorgino Abraham"), Duration.ofMinutes(90));
		Movie m2 = new Movie("Dignitate", "Fajar Nugros");
		Movie m3 = new Movie("Janin", LocalDate.of(2020, 4, 5), s2, "13+", 6.1, 7, Language.ENGLISH, "Ook Budiyono",List.of("Jill Gladys", "Reuben Elishama", "Meriam Bellina"), Duration.ofMinutes(110));
		Movies ms2 = new Movies();
		
		ms2.addMovie(m1);
		ms2.addMovie(m2);
		System.out.println(ms2.getMovies());
		System.out.println(ms1.equals(ms2));
		ms2.deleteMovie(m2);
		System.out.println(ms2.getMovies());
		
		List<Movie> l = new ArrayList<Movie>();
		l.add(m3);
		ms2.addMovies(l);
		System.out.println(ms2.getMovies());
		
		System.out.println(ms1.existsPerfectUsersRating());
		System.out.println(ms1.getVoteAverage());
		System.out.println(ms1.filterByLanguage(Language.DUTCH));
		System.out.println(ms1.moviesByGenre());
		System.out.println(ms1.getTotalVotesPerGenre());
	}
}
