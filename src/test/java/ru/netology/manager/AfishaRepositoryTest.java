package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {

    AfishaRepository repo = new AfishaRepository();

    // Создаём фильмы
    Film first = new Film(1, "Бладшот", "боевик");
    Film second = new Film(2, "Вперёд", "мультфильм");
    Film third = new Film(3, "Отель-Белград", "комедия");
    Film fourth = new Film(4, "Маяк", "ужасы");
    Film fifth = new Film(5, "Полицейская история", "боевик");

    @BeforeEach
    void filmsAddToRepository() {
        //Зaписываем в массив Film[]
        repo.save(first);
        repo.save(second);
        repo.save(third);
        repo.save(fourth);
        repo.save(fifth);
    }

    @Test
    void shouldCleanAll() {

        //Очищаем массив
        repo.removeAll();
        Film[] expected = new Film[0];
        Film[] actual = repo.findAll();

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldFindById() {

        //Ищим валидный элемент
        Film expected = new Film(3, "Отель-Белград", "комедия");
        Film actual = repo.findById(3);

        assertEquals(expected, actual);
    }

    @Test
    void shouldFindNull() {

        //Возвращаем Null если не находим элемент
        Film actual = repo.findById(6);

        assertNull(actual);
    }

    @Test
    void shouldRemoveById() {

        //Удаляем валидный элемент
        Film[] expected = new Film[]{first, second, third, fifth};
        repo.removeById(4);
        Film[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoteNotExist() {

        //Если при удалении элемент не найден возвращаем полностью массив
        Film[] expected = new Film[]{first, second, third, fourth, fifth};
        repo.removeById(8);
        Film[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }
}
