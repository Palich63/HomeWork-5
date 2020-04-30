package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AfishaRepositoryTest {

    AfishaRepository repo = new AfishaRepository();

    // Создаём фильмы
    private Film first = new Film(1, "Бладшот", "боевик");
    private Film second = new Film(2, "Вперёд", "мультфильм");
    private Film third = new Film(3, "Отель-Белград", "комедия");
    private Film fourth = new Film(4, "Маяк", "ужасы");
    private Film fifth = new Film(5, "Полицейская история", "боевик");

    void filmsAddToRepository(AfishaRepository repo) {
        //Зaписываем в массив Film[]
        repo.save(first);
        repo.save(second);
        repo.save(third);
        repo.save(fourth);
        repo.save(fifth);
    }

    @Test
    void shouldCleanAll() {
        filmsAddToRepository(repo);

        //Очищаем массив
        repo.removeAll();
        Film[] expected = new Film[0];
        Film[] actual = repo.findAll();

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldFindById() {
        filmsAddToRepository(repo);

        //Ищим валидный элемент
        Film expected = new Film(3, "Отель-Белград", "комедия");
        Film actual = repo.findById(3);

        assertEquals(expected, actual);
    }

    @Test
    void shouldFindNull() {
        filmsAddToRepository(repo);

        //Возвращаем Null если не находим элемент
        Film actual = repo.findById(6);

        assertEquals(null, actual);
    }

    @Test
    void shouldRemoveById() {
        filmsAddToRepository(repo);

        //Удаляем валидный элемент
        Film[] expected = new Film[]{first, second, third, fifth};
        repo.removeById(4);
        Film[] actual = repo.findAll();

        assertArrayEquals(expected, actual);


    }
}
