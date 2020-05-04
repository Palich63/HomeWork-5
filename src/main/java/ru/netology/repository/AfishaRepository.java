package ru.netology.repository;

import ru.netology.domain.Film;

public class AfishaRepository {

    private Film[] films = new Film[0];

    public void save(Film film) {
        Film[] tmpfilm = new Film[films.length + 1];
        System.arraycopy(films, 0, tmpfilm, 0, films.length);
        tmpfilm[tmpfilm.length - 1] = film;
        films = tmpfilm;
    }

    public Film[] findAll() {
        return films;
    }

    public Film findById(int id) {
        for (Film film : films) {
            if (film.getId() == id) {
                return film;
            }
        }
        return null;
    }

    public void removeById(int id) {
        Film[] tmpfilm = new Film[films.length - 1];
        int index = 0;
        if (id <= films.length) {
            for (Film film : films) {
                if (film.getId() != id) {
                    tmpfilm[index] = film;
                    index++;
                }
            }
            films = tmpfilm;
        }
    }

    public void removeAll() {
        films = new Film[0];

    }
}
