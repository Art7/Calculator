package main;

/**
 * Created by Artur on 28.04.2015.
 */
public class Main {
    public static void main(String[] args) {
        Model logic = new Model();
        ViewCalculator gui = new ViewCalculator(logic);
        gui.buildGUI();
    }
}
//1) Убрать 0 ok
//2) Выделить общий обработчик событий для арифметических операций ok
//3) Избавится от анонимных классов  ok
//4) Сделать обработчик для кнопки "." ok
//5) Слева - панель доп. действий:  ok
// - кнопка С (полное очищение)  ok
// - кнопка Backspace  ok
//6) Обработка всех ошибок ok
//7) Обеспечить функцию накапливания результата  ok