package org.example.lec1;

/**
 * Маркерный интерфейс - без методов, нужен для того,
 * чтобы помечать, что данный класс имеет определенные свойства
 *
 * Функциональный интерфейс - с одним методом
 */
@FunctionalInterface
public interface PlainInterface {
    int action(int x, int y);
}
