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

    private AfishaRepository repository = new AfishaRepository();

    private int lengthOfAfisha = 10;

    public AfishaManager(int lengthOfAfisha) {
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
