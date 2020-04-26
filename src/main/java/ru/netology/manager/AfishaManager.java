package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Film;
import ru.netology.repository.AfishaRepository;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AfishaManager {

    private Film[] film = new Film[0];
    private int lengthOfAfisha = 10;

    private AfishaRepository repository;

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    public AfishaManager(int lengthOfAfisha) {
        this.lengthOfAfisha = lengthOfAfisha;
    }

    public void add(Film films){
        repository.save(films);
    }

    //Создаём афишу
    public void filmAdd(Film films) {

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
