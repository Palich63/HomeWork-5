package ru.netology.manager;

import lombok.NoArgsConstructor;
import ru.netology.domain.Film;

@NoArgsConstructor
public class AfishaManager {

    private Film[] films = new Film[0];
    private int defaultfAfishaLength = 10;
    private int lengthOfAfisha;

    public Film[] getFilms() {
        return films;
    }

    public AfishaManager(int lengthOfAfisha) {
        this.lengthOfAfisha = lengthOfAfisha;
    }

    //Создаём афишу
    public void filmAdd(Film film) {
        Film[] tmpfilm = new Film[films.length + 1];
        System.arraycopy(films, 0, tmpfilm, 0, films.length);
        tmpfilm[tmpfilm.length - 1] = film;
        films = tmpfilm;
    }

    //Выводим афишу в обратном порядке
    public Film[] showAfisha() {
        if (lengthOfAfisha < 0 || lengthOfAfisha > defaultfAfishaLength) {
            lengthOfAfisha = defaultfAfishaLength;
        }
        if (films.length < defaultfAfishaLength) {
            lengthOfAfisha = films.length;
        }
        Film[] display = new Film[lengthOfAfisha];
        for (int i = 0; i < lengthOfAfisha; i++) {
            int index = films.length - i - 1;
            display[i] = films[index];
        }
        return display;
    }
}
