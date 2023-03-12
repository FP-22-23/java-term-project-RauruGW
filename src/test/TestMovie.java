package test;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import types.Language;
import types.Movie;
import types.Sinopsis;

public class TestMovie {
	public static void main (String args[]) {
		
		Sinopsis s1 = new Sinopsis("Alfi meets Alana, a new student at school.It turns out that they are in one class and sitting next to each other. Instead of getting along, they often argue because they both are stubborn.","Drama");
		Sinopsis s2 = new Sinopsis("Randu and Dinar are happy because Dinar conceives for the fourth month. However, their happiness slowly disappears when a middle-aged woman, Sukma", "Horror");
		Movie m1 = new Movie("Dignitate",LocalDate.of(2020,5,10), s1, "17+", 6.4, 20, Language.Indonesian, "Fajar Nugros",List.of("Al Ghazali", "Caitlin Halderman", "Giorgino Abraham"), Duration.ofMinutes(90));
		Movie m2 = new Movie("Dignitate", "Fajar Nugros");
		Movie m3 = new Movie("Janin", LocalDate.of(2020, 4, 5), s2, "13+", 6.1, 7, Language.English, "Ook Budiyono",List.of("Jill Gladys", "Reuben Elishama", "Meriam Bellina"), Duration.ofMinutes(110));
		System.out.println(m1.toString());
		System.out.println(m2.toString());
		System.out.println(m1.equals(m2));
		System.out.println(m1.equals(m3));
		System.out.print(m1.compareTo(m3));
	}

}
