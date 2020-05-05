package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AfishaManagerTest {

    private AfishaManager manager;
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
    Film eleventh = new Film(11, "1+1", "драма, комедия");

    @Test
    void shouldCheckAfisha() {
        manager = new AfishaManager();
        //Зaписываем в массив Film[]
        //Добавляем три фильма и проверяем
        manager.filmAdd(first);
        manager.filmAdd(second);
        manager.filmAdd(third);

        Film[] expected = new Film[]{first, second, third};
        assertArrayEquals(expected, manager.getFilms());

        //Добавляем фильм и снова проверяем
        manager.filmAdd(fourth);

        Film[] expectedFourth = new Film[]{first, second, third, fourth};

        assertArrayEquals(expectedFourth, manager.getFilms());
    }

    @Test
    void shouldfilmAddToAfisha() {
        manager = new AfishaManager();
        //Зaписываем в массив Film[]
        manager.filmAdd(first);
        manager.filmAdd(second);
        manager.filmAdd(third);
        manager.filmAdd(fourth);
        manager.filmAdd(fifth);
        manager.filmAdd(sixth);
        manager.filmAdd(seventh);
        manager.filmAdd(eighth);
        manager.filmAdd(ninth);
        manager.filmAdd(tenth);
        manager.filmAdd(eleventh);
        //Массива фильмов в прямом порядке и его проверка
        Film[] expected = new Film[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
        Film[] actual = manager.getFilms();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldDisplayfiveFilmsInAfisha() {
        manager = new AfishaManager(5);
        //Зaписываем в массив Film[]
        manager.filmAdd(first);
        manager.filmAdd(second);
        manager.filmAdd(third);
        manager.filmAdd(fourth);
        manager.filmAdd(fifth);
        manager.filmAdd(sixth);
        //Выводим последние 5 фильмов
        Film[] expectedLastFive = new Film[]{sixth, fifth, fourth, third, second};
        Film[] actualLastFive = manager.showAfisha();

        assertArrayEquals(expectedLastFive, actualLastFive);
    }

    @Test
    void shouldDisplayThreeFilmsInAfisha() {
        manager = new AfishaManager(3);
        //Зaписываем в массив Film[]
        manager.filmAdd(first);
        manager.filmAdd(second);
        manager.filmAdd(third);
        manager.filmAdd(fourth);
        manager.filmAdd(fifth);
        manager.filmAdd(sixth);
        //Выводим последние 3 фильмов
        Film[] expectedLastThree = new Film[]{sixth, fifth, fourth};
        Film[] actualLastThree = manager.showAfisha();

        assertArrayEquals(expectedLastThree, actualLastThree);
    }

    @Test
    void shouldDisplayByDefaultAfisha() {
        manager = new AfishaManager();
        //Зaписываем в массив Film[]
        manager.filmAdd(first);
        manager.filmAdd(second);
        manager.filmAdd(third);
        manager.filmAdd(fourth);
        manager.filmAdd(fifth);
        manager.filmAdd(sixth);
        manager.filmAdd(seventh);
        manager.filmAdd(eighth);
        manager.filmAdd(ninth);
        manager.filmAdd(tenth);
        manager.filmAdd(eleventh);
        //Выводим фильмы в обратном порядке (по умолчанию 10)
        Film[] expected = new Film[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        Film[] actual = manager.showAfisha();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldDisplayZeroFilmsInAfisha() {
        manager = new AfishaManager(0);
        //Зaписываем в массив Film[]
        manager.filmAdd(first);
        manager.filmAdd(second);
        manager.filmAdd(third);
        manager.filmAdd(fourth);
        manager.filmAdd(fifth);
        manager.filmAdd(sixth);
        manager.filmAdd(seventh);
        manager.filmAdd(eighth);
        manager.filmAdd(ninth);
        manager.filmAdd(tenth);
        manager.filmAdd(eleventh);
        //Проверка при нулевом значении массива
        //Результат вывод массива с длиной по умолчанию
        Film[] expectedZero = new Film[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        Film[] actualZero = manager.showAfisha();

        assertArrayEquals(expectedZero, actualZero);
    }

    @Test
    void shouldDisplayDefaultAfisha() {
        manager = new AfishaManager(18);
        //Зaписываем в массив Film[]
        manager.filmAdd(first);
        manager.filmAdd(second);
        manager.filmAdd(third);
        manager.filmAdd(fourth);
        manager.filmAdd(fifth);
        manager.filmAdd(sixth);
        manager.filmAdd(seventh);
        manager.filmAdd(eighth);
        manager.filmAdd(ninth);
        manager.filmAdd(tenth);
        manager.filmAdd(eleventh);
        //Проверка вывода при значении массива больше значения по умолчанию.
        //Результат, вывод массива длиной по умолчанию
        Film[] expectedDefault = new Film[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        Film[] actualDefault = manager.showAfisha();

        assertArrayEquals(expectedDefault, actualDefault);
    }

    @Test
    void shouldLessDisplayFilm() {
        manager = new AfishaManager();
        //Зaписываем в массив Film[]
        manager.filmAdd(first);
        manager.filmAdd(second);
        manager.filmAdd(third);
        manager.filmAdd(fourth);
        manager.filmAdd(fifth);
        manager.filmAdd(sixth);
        manager.filmAdd(seventh);
        //В случае если фильмов меньше чем вывод значения по умолчанию
        //Массив фильмов в обратном порядке
        Film[] expectedSeven = new Film[]{seventh, sixth, fifth, fourth, third, second, first};
        Film[] actualSeven = manager.showAfisha();

        assertArrayEquals(expectedSeven, actualSeven);
    }

    @Test
    void shouldNegativelengthOfAfisha() {
        manager = new AfishaManager(-10);
        //Зaписываем в массив Film[]
        manager.filmAdd(first);
        manager.filmAdd(second);
        manager.filmAdd(third);
        manager.filmAdd(fourth);
        manager.filmAdd(fifth);
        manager.filmAdd(sixth);
        manager.filmAdd(seventh);
        manager.filmAdd(eighth);
        manager.filmAdd(ninth);
        manager.filmAdd(tenth);
        manager.filmAdd(eleventh);
        //Проверка вывода при отрицательном значении массива
        //Результат, вывод массива длиной по умолчанию
        Film[] expectedNegative = new Film[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        Film[] actualNegative = manager.showAfisha();

        assertArrayEquals(expectedNegative, actualNegative);
    }
}
