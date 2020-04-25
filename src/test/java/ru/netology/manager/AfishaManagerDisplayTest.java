package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AfishaManagerDisplayTest {

    @Test
    void shouldLessDisplayFilm() {
        AfishaManager manager = new AfishaManager();
        // Если в массиве меньше 10 фильмов
        Film first = new Film(1, "Бладшот", "боевик");
        Film second = new Film(2, "Вперёд", "мультфильм");
        Film third = new Film(3, "Отель-Белград", "комедия");
        Film fourth = new Film(4, "Маяк", "ужасы");
        Film fifth = new Film(5, "Полицейская история", "боевик");
        Film sixth = new Film(6, "Вперёд", "мультфильм");
        Film seventh = new Film(7, "Джуманджи: Новый уровень", "боевик, приключение");

        //Зaписываем в массив film[]
        manager.FilmAdd(first);
        manager.FilmAdd(second);
        manager.FilmAdd(third);
        manager.FilmAdd(fourth);
        manager.FilmAdd(fifth);
        manager.FilmAdd(sixth);
        manager.FilmAdd(seventh);

        //Массив фильмов в обратном порядке
        Film[] expectedSeven = new Film[]{seventh, sixth, fifth, fourth, third, second, first};
        Film[] actualSeven = manager.showAfisha();

        assertArrayEquals(expectedSeven, actualSeven);
    }
}