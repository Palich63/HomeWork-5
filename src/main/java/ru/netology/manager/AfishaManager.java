package ru.netology.manager;

import lombok.NoArgsConstructor;
import ru.netology.domain.Film;
import ru.netology.repository.AfishaRepository;

@NoArgsConstructor
public class AfishaManager {

    private AfishaRepository repository;

    private int defaultfAfishaLength = 10;
    private int lengthOfAfisha;

    public AfishaManager(AfishaRepository repository, int lengthOfAfisha) {
        this.repository = repository;
        this.lengthOfAfisha = lengthOfAfisha;
    }

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    //Добовляем элемент
    public void add(Film film) {
        repository.save(film);
    }

    //Выводим весь массив
    public Film[] show() {
        return repository.findAll();
    }

    //Выводим афишу в обратном порядке
    public Film[] showAfisha() {
        Film[] filmsFromRepository = repository.findAll();

        if (lengthOfAfisha <= 0 || lengthOfAfisha > defaultfAfishaLength) {
            lengthOfAfisha = defaultfAfishaLength;
        }
        if (filmsFromRepository.length < lengthOfAfisha) {
            lengthOfAfisha = filmsFromRepository.length;
        }

        Film[] display = new Film[lengthOfAfisha];
        for (int i = 0; i < lengthOfAfisha; i++) {
            int index = filmsFromRepository.length - i - 1;
            display[i] = filmsFromRepository[index];
        }
        return display;
    }
}
