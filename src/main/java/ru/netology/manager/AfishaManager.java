package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Film;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AfishaManager {

    private Film[] film = new Film[0];
    private int lengthOfAfisha = 10;

    public AfishaManager(int lengthOfAfisha) {
        this.lengthOfAfisha = lengthOfAfisha;
    }

    //Создаём афишу
    public void FilmAdd(Film films) {

        int length = film.length + 1;
        Film[] tmpfilm = new Film[length];

        for (int i = 0; i < film.length; i++) {
            tmpfilm[i] = film[i];
        }
        int lastIndex = tmpfilm.length - 1;
        tmpfilm[lastIndex] = films;
        film = tmpfilm;
    }

    //Выводим афишу в обратном порядке
    public Film[] showAfisha() {
        if (film.length < lengthOfAfisha) {
            lengthOfAfisha = film.length;
        }
        Film[] display = new Film[lengthOfAfisha];
        for (int i = 0; i < lengthOfAfisha; i++) {
            int index = film.length - i - 1;
            display[i] = film[index];
        }
        return display;
    }
}
