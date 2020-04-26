package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
@ExtendWith(MockitoExtention.class)
class AfishaManagerTest {
@Mock
private AfishaRepository repository;

    @Test
    void shouldfilmAddToAfisha() {
        AfishaManager manager = new AfishaManager();

        // Создаём фильмы
        Film first = new Film(1, "Бладшот", "боевик");
        Film second = new Film(2, "Вперёд", "мультфильм");
        Film third = new Film(3, "Отель-Белград", "комедия");
        Film fourth = new Film(4, "Маяк", "ужасы");
        Film fifth = new Film(5, "Полицейская история", "боевик");
        Film sixth = new Film(6, "Вперёд", "мультфильм");
        Film seventh = new Film(7, "Джуманджи: Новый уровень", "боевик, приключение");
        Film eighth = new Film(8, "Приди ко мне", "ужасы");
        Film ninth = new Film(9, "Пингвинёнок Пороро", "мультфильм");
        Film tenth = new Film(10, "Котёл", "драма");

        //Зaписываем в массив film[]
        manager.FilmAdd(first);
        manager.FilmAdd(second);
        manager.FilmAdd(third);
        manager.FilmAdd(fourth);
        manager.FilmAdd(fifth);
        manager.FilmAdd(sixth);
        manager.FilmAdd(seventh);
        manager.FilmAdd(eighth);
        manager.FilmAdd(ninth);
        manager.FilmAdd(tenth);

        //Массива фильмов в прямом порядке и его проверка
        Film[] expected = new Film[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        Film[] actual = manager.getFilm();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldDisplayAfisha() {
        AfishaManager manager = new AfishaManager();
        // Создаём фильмы
        Film first = new Film(1, "Бладшот", "боевик");
        Film second = new Film(2, "Вперёд", "мультфильм");
        Film third = new Film(3, "Отель-Белград", "комедия");
        Film fourth = new Film(4, "Маяк", "ужасы");
        Film fifth = new Film(5, "Полицейская история", "боевик");
        Film sixth = new Film(6, "Вперёд", "мультфильм");
        Film seventh = new Film(7, "Джуманджи: Новый уровень", "боевик, приключение");
        Film eighth = new Film(8, "Приди ко мне", "ужасы");
        Film ninth = new Film(9, "Пингвинёнок Пороро", "мультфильм");
        Film tenth = new Film(10, "Котёл", "драма");

        //Зaписываем в массив film[]
        manager.FilmAdd(first);
        manager.FilmAdd(second);
        manager.FilmAdd(third);
        manager.FilmAdd(fourth);
        manager.FilmAdd(fifth);
        manager.FilmAdd(sixth);
        manager.FilmAdd(seventh);
        manager.FilmAdd(eighth);
        manager.FilmAdd(ninth);
        manager.FilmAdd(tenth);

        //Массив фильмов в обратном порядке
        Film[] expected = new Film[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        Film[] actual = manager.showAfisha();

        assertArrayEquals(expected, actual);

        //Выводим последние 5 фильмов
        manager.setLengthOfAfisha(5);
        Film[] expectedLastFive = new Film[]{tenth, ninth, eighth, seventh, sixth};
        Film[] actualLastFive = manager.showAfisha();

        assertArrayEquals(expectedLastFive, actualLastFive);

        //Выводим последние 3 фильмов
        manager.setLengthOfAfisha(3);
        Film[] expectedLastThree = new Film[]{tenth, ninth, eighth};
        Film[] actualLastThree = manager.showAfisha();

        assertArrayEquals(expectedLastThree, actualLastThree);
    }
}