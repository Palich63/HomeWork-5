package ru.netology.repository;

import ru.netology.domain.Film;

public class    AfishaRepository {

    private Film[] film = new Film[0];

    public Film[] findAll() {
        return film;
    }

    public Film[] findById(int id) {
        for (Film film : film) {
            if (film.getId() == id) {

            }

        }
return film;

    }

    public void save(Film films) {
        int length = film.length + 1;
        Film[] tmpfilm = new Film[length];
        System.arraycopy(film, 0, tmpfilm, 0, film.length);
        int lastIndex = tmpfilm.length - 1;
        tmpfilm[lastIndex] = films;
        film = tmpfilm;
    }

    public void removeById(int id) {
        int length = film.length - 1;
        Film[] tmpfilm = new Film[length];
        int index = 0;
        for (Film film : film) {
            if (film.getId() != id) {
                tmpfilm[index] = film;
                index++;
            }
        }
        film = tmpfilm;
    }

    void removeAll() {
        film = new Film[0];

    }
}
