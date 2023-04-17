package org.example;

import org.example.model.Director;
import org.example.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Director.class)
                .addAnnotatedClass(Movie.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            /* All Films by Director ID

            Director director = session.get(Director.class, 2);
            System.out.println(director);

            List<Movie> movies = director.getMovies();
            System.out.println(movies);
            */

            /* Get Movie and Director by movie id

            Movie movie = session.get(Movie.class, 3);
            System.out.println(movie);
            Director director = movie.getOwner();
            System.out.println(director);

             */


            /* Add Movie to existing Director

            Director director = session.get(Director.class,3);
            Movie movie = new Movie("RockNRolla", 2008, director);
            director.getMovies().add(movie);
            session.save(movie);

             */


            /* Add new Movie and Director
            Director director = new Director("Marek Brodzki", 63);
            Movie movie = new Movie("The Witcher",2002,director);

            director.setMovies(new ArrayList<>(Collections.singletonList(movie)));

            session.save(director);
            session.save(movie);


             */


            /* Remove movies
            Director director = session.get(Director.class, 10);
            List<Movie> movies = director.getMovies();

            for (Movie movie : movies){
                session.remove(movie);
            }

            director.getMovies().clear();


             */



            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }

    }
}
