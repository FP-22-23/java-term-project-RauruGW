package types;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import utils.Checkers;

public class FactoryMovie {
	
	public static Movies readMovies(String file) {
		Movies res = null;
		try {
			Stream<String> movies = Files.lines(Path.of(file)).skip(1);
			Stream<Movie> m = movies.map(FactoryMovie::parseMovie);
			res = new Movies(m);
		}catch (IOException e){
			System.out.println("Error with the file " + file);
			e.printStackTrace();
		}
		return res;
	}
	
	private static Movie parseMovie(String line) {
		String[] fields = line.split(";");
		Checkers.check("Error in line", fields.length == 11);
		
		String title = fields[0].trim();
		LocalDate releaseDate = LocalDate.parse(fields[1].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String description = fields[2].trim();
		String genre = fields[3].trim();
		Sinopsis sinopsis = new Sinopsis(description, genre);
		String rating = fields[4];
		Double usersRating = Double.parseDouble(fields[5].trim());
		Integer votes = Integer.parseInt(fields[6].trim());
		Language lang = Language.valueOf(fields[7].trim().toUpperCase());
		String director = fields[8].trim();
		List<String> actors = parseList(fields[9].trim());
		Duration runtime = Duration.ofMinutes(Integer.parseInt(fields[10].trim()));
		
		return new Movie(title, releaseDate, sinopsis, rating, usersRating, votes, lang, director, actors, runtime);
	}
	
	private static List<String> parseList(String l) {
		List<String> res = new ArrayList<String>();
		String s1 = l.replace("[", "").replace("]", "").replace("'", "");
		for(String s : s1.split(",")) {
			res.add(s);
		}
		return res;	
	}
}
